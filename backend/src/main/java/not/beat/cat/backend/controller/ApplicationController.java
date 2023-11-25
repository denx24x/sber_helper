package not.beat.cat.backend.controller;

import not.beat.cat.backend.dto.ApplicationTo;
import not.beat.cat.backend.dto.FormTo;
import not.beat.cat.backend.exception.ResourceNotFoundException;
import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.service.ApplicationService;
import not.beat.cat.backend.service.FormService;
import not.beat.cat.backend.transformer.ApplicationTransformer;
import not.beat.cat.backend.transformer.FormTransformer;
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
    private final ApplicationService applicationService;
    private final FormService formService;
    private final ApplicationTransformer applicationTransformer;
    private final FormTransformer formTransformer;

    public ApplicationController(
            ApplicationService applicationService,
            FormService formService,
            ApplicationTransformer applicationTransformer,
            FormTransformer formTransformer
    ) {
        this.applicationService = applicationService;
        this.formService = formService;
        this.applicationTransformer = applicationTransformer;
        this.formTransformer = formTransformer;
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
    public Long save(@RequestBody ApplicationTo applicationTo) {
        return applicationService.save(applicationTransformer.transform(
                applicationTo
        )).getId();
    }

    @GetMapping("/{id}/forms")
    public List<FormTo> findForms(@PathVariable("id") Long id) {
        return formService.findAllByApplicationId(id).stream()
                .map(formTransformer::transform)
                .toList();
    }
}
