package not.beat.cat.backend.controller;

import not.beat.cat.backend.dto.FormTo;
import not.beat.cat.backend.service.FormService;
import not.beat.cat.backend.transformer.FormTransformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/forms")
public class FormController {
    private final FormService formService;

    private final FormTransformer formTransformer;

    public FormController(
            FormService formService,
            FormTransformer formTransformer
    ) {
        this.formService = formService;
        this.formTransformer = formTransformer;
    }

    @GetMapping
    public List<FormTo> findForms(
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "limit", required = false) Integer limit
    ) {
        return formService.findAll().stream()
                .map(formTransformer::transform)
                .toList();
    }

    @PostMapping
    public Long save(@RequestBody FormTo formTo) {
        return formService.save(formTransformer.transform(formTo)).getId();
    }
}
