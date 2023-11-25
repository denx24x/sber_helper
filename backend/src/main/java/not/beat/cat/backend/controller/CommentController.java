package not.beat.cat.backend.controller;

import jakarta.validation.Valid;
import not.beat.cat.backend.dto.CommentCreateRequest;
import not.beat.cat.backend.dto.CommentTo;
import not.beat.cat.backend.exception.BadParametersException;
import not.beat.cat.backend.exception.ResourceNotFoundException;
import not.beat.cat.backend.model.Comment;
import not.beat.cat.backend.service.ApplicationService;
import not.beat.cat.backend.service.CommentService;
import not.beat.cat.backend.transformer.CommentTransformer;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comments")
public class CommentController {
    private final ApplicationService applicationService;
    private final CommentService commentService;
    private final CommentTransformer commentTransformer;

    public CommentController(
            ApplicationService applicationService,
            CommentService commentService,
            CommentTransformer commentTransformer
    ) {
        this.applicationService = applicationService;
        this.commentService = commentService;
        this.commentTransformer = commentTransformer;
    }

    @GetMapping("/{id}")
    public CommentTo findById(@PathVariable("id") Long id) {
        Comment comment = commentService.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        return commentTransformer.transform(comment);
    }

    @PostMapping
    public Long save(
            @Valid @RequestBody CommentCreateRequest createRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new BadParametersException(bindingResult);
        }

        return applicationService.saveComment(
                createRequest.getApplicationId(),
                commentTransformer.transform(createRequest)
        ).getId();
    }
}
