package not.beat.cat.backend.controller;

import jakarta.validation.Valid;
import not.beat.cat.backend.dto.ApplicationCreateRequest;
import not.beat.cat.backend.dto.ApplicationTo;
import not.beat.cat.backend.dto.ApplicationUpdateStatusRequest;
import not.beat.cat.backend.dto.CommentCreateRequest;
import not.beat.cat.backend.dto.CommentTo;
import not.beat.cat.backend.dto.FormTo;
import not.beat.cat.backend.exception.BadParametersException;
import not.beat.cat.backend.exception.ResourceNotFoundException;
import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.service.ApplicationService;
import not.beat.cat.backend.service.CommentService;
import not.beat.cat.backend.service.FormService;
import not.beat.cat.backend.transformer.ApplicationTransformer;
import not.beat.cat.backend.transformer.CommentTransformer;
import not.beat.cat.backend.transformer.FormTransformer;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/applications")
public class ApplicationController {
    private static final String UPDATE_STATUS_COMMENT_TEMPLATE = "Статус заявки изменился на %s.\n";

    private final ApplicationService applicationService;
    private final FormService formService;
    private final CommentService commentService;
    private final ApplicationTransformer applicationTransformer;
    private final FormTransformer formTransformer;
    private final CommentTransformer commentTransformer;

    public ApplicationController(
            ApplicationService applicationService,
            FormService formService,
            CommentService commentService,
            ApplicationTransformer applicationTransformer,
            FormTransformer formTransformer,
            CommentTransformer commentTransformer
    ) {
        this.applicationService = applicationService;
        this.formService = formService;
        this.commentService = commentService;
        this.applicationTransformer = applicationTransformer;
        this.formTransformer = formTransformer;
        this.commentTransformer = commentTransformer;
    }

    @GetMapping("/{id}")
    public ApplicationTo findById(@PathVariable("id") Long id) {
        Application application = applicationService.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        return applicationTransformer.transform(application);
    }

    @GetMapping
    public List<ApplicationTo> findAll() {
        return applicationService.findAll().stream()
                .map(applicationTransformer::transform)
                .toList();
    }

    @GetMapping("/not-finished")
    public List<ApplicationTo> findAllNotFinished() {
        return applicationService.findAllByStatuses(
                Arrays.stream(ApplicationStatus.values())
                        .filter(status -> !ApplicationStatus.FINISHED.equals(status))
                        .collect(Collectors.toSet())
        ).stream().map(applicationTransformer::transform).toList();
    }

    @PostMapping
    public Long save(
            @Valid @RequestBody ApplicationCreateRequest createRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new BadParametersException(bindingResult);
        }

        return applicationService.save(applicationTransformer.transform(createRequest)).getId();
    }

    @GetMapping("/{id}/forms")
    public List<FormTo> findForms(@PathVariable("id") Long id) {
        return formService.findAllByApplicationId(id).stream()
                .map(formTransformer::transform)
                .toList();
    }

    @GetMapping("/{id}/comments")
    public List<CommentTo> findComments(@PathVariable("id") Long id) {
        return commentService.findAllByApplicationId(id).stream()
                .map(commentTransformer::transform)
                .toList();
    }

    @PostMapping("/{id}/update-status")
    public void updateStatus(
            @PathVariable("id") Long id,
            @Valid @RequestBody ApplicationUpdateStatusRequest updateStatusRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new BadParametersException(bindingResult);
        }

        String commentContent = UPDATE_STATUS_COMMENT_TEMPLATE.formatted(updateStatusRequest.getNewStatus());
        if (updateStatusRequest.getComment() != null) {
            commentContent += "\n" + updateStatusRequest.getComment();
        }

        applicationService.updateStatus(
                id,
                updateStatusRequest.getNewStatus(),
                commentTransformer.transform(new CommentCreateRequest(id, commentContent))
        );
    }
}
