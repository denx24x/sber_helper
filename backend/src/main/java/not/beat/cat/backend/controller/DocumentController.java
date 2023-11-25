package not.beat.cat.backend.controller;

import not.beat.cat.backend.dto.DocumentTo;
import not.beat.cat.backend.exception.ResourceNotFoundException;
import not.beat.cat.backend.model.Document;
import not.beat.cat.backend.service.DocumentService;
import not.beat.cat.backend.transformer.DocumentTransformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public DocumentTo findById(@PathVariable("id") Long id) {
        Document document = documentService.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        return documentTransformer.transform(document);
    }

    @PostMapping
    public Long save(@RequestBody DocumentTo documentTo) {
        return documentService.save(documentTransformer.transform(
                documentTo
        )).getId();
    }
}
