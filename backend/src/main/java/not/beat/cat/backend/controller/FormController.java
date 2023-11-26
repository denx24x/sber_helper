package not.beat.cat.backend.controller;

import jakarta.validation.Valid;
import not.beat.cat.backend.dto.BankAccountInfoCreateRequest;
import not.beat.cat.backend.dto.DocumentTo;
import not.beat.cat.backend.dto.FormCreateRequest;
import not.beat.cat.backend.dto.FormTo;
import not.beat.cat.backend.exception.BadParametersException;
import not.beat.cat.backend.exception.ResourceNotFoundException;
import not.beat.cat.backend.model.Form;
import not.beat.cat.backend.service.DocumentService;
import not.beat.cat.backend.service.FormService;
import not.beat.cat.backend.transformer.BankAccountInfoTransformer;
import not.beat.cat.backend.transformer.DocumentTransformer;
import not.beat.cat.backend.transformer.FormTransformer;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/forms")
public class FormController {
    private final FormService formService;
    private final DocumentService documentService;
    private final FormTransformer formTransformer;
    private final DocumentTransformer documentTransformer;
    private final BankAccountInfoTransformer bankAccountInfoTransformer;

    public FormController(
            FormService formService,
            DocumentService documentService,
            FormTransformer formTransformer,
            DocumentTransformer documentTransformer,
            BankAccountInfoTransformer bankAccountInfoTransformer
    ) {
        this.formService = formService;
        this.documentService = documentService;
        this.formTransformer = formTransformer;
        this.documentTransformer = documentTransformer;
        this.bankAccountInfoTransformer = bankAccountInfoTransformer;
    }

    @GetMapping("/{id}")
    public FormTo findById(@PathVariable("id") Long id) {
        Form form = formService.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        return formTransformer.transform(form);
    }

    @PostMapping
    public Long save(
            @Valid @RequestBody FormCreateRequest createRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new BadParametersException(bindingResult);
        }

        return formService.save(
                createRequest.getApplicationId(),
                formTransformer.transform(createRequest)
        ).getId();
    }

    @PostMapping("{id}/bank-account")
    public Long save(
            @Valid @RequestBody BankAccountInfoCreateRequest createRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new BadParametersException(bindingResult);
        }

        return formService.saveBankAccountInfo(
                createRequest.getFormId(),
                bankAccountInfoTransformer.transform(createRequest)
        ).getId();
    }

    @GetMapping("/{id}/documents")
    public List<DocumentTo> findDocumentsById(@PathVariable("id") Long id) {
        return documentService.findAllByFormId(id).stream()
                .map(documentTransformer::transform)
                .toList();
    }
}
