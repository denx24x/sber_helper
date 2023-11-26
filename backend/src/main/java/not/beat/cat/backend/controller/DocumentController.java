package not.beat.cat.backend.controller;

import not.beat.cat.backend.model.DocumentType;
import not.beat.cat.backend.service.DocumentService;
import not.beat.cat.backend.transformer.DocumentTransformer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Long save(
            @RequestParam("formId") long formId,
            @RequestParam("location") String location,
            @RequestParam("type") DocumentType type,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            Path filePath = Path.of(location).resolve(file.getOriginalFilename());
            documentService.upload(filePath, file.getBytes());
            return documentService.save(
                    formId,
                    documentTransformer.transform(type, filePath.toString())
            ).getId();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
