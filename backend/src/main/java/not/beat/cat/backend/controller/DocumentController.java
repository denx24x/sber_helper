package not.beat.cat.backend.controller;

import jakarta.validation.Valid;
import not.beat.cat.backend.dto.DocumentCreateRequest;
import not.beat.cat.backend.exception.BadParametersException;
import not.beat.cat.backend.service.DocumentService;
import not.beat.cat.backend.transformer.DocumentTransformer;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;

@RestController
@RequestMapping("/v1/documents")
public class DocumentController {
    private final DocumentService documentService;
    private final DocumentTransformer documentTransformer;

    public DocumentController(
            DocumentService documentService,
            DocumentTransformer documentTransformer
    ) {
        this.documentService = documentService;
        this.documentTransformer = documentTransformer;
    }

    @PostMapping
    public Long save(
            @Valid @RequestBody DocumentCreateRequest createRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new BadParametersException(bindingResult);
        }

        try {
            documentService.upload(
                    Path.of(createRequest.getLocation()),
                    createRequest.getFile().getBytes()
            );
            return documentService.save(
                    createRequest.getFormId(),
                    documentTransformer.transform(createRequest)
            ).getId();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
