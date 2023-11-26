package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.exception.ResourceNotFoundException;
import not.beat.cat.backend.model.Document;
import not.beat.cat.backend.model.DocumentType;
import not.beat.cat.backend.model.Form;
import not.beat.cat.backend.repository.DocumentRepository;
import not.beat.cat.backend.repository.FileRepository;
import not.beat.cat.backend.service.DocumentService;
import not.beat.cat.backend.service.FormService;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final FormService formService;
    private final DocumentRepository documentRepository;
    private final FileRepository fileRepository;

    public DocumentServiceImpl(
            FormService formService,
            DocumentRepository documentRepository,
            FileRepository fileRepository
    ) {
        this.formService = formService;
        this.documentRepository = documentRepository;
        this.fileRepository = fileRepository;
    }

    @Override
    public Optional<Document> findById(long id) {
        return documentRepository.findById(id);
    }

    @Override
    public List<Document> findAllByFormId(long formId) {
        return documentRepository.findAllByFormId(formId);
    }

    @Override
    public Optional<Document> findByType(long formId, DocumentType documentType) {
        return documentRepository.findByType(formId, documentType);
    }

    @Override
    public Document save(long formId, Document document) {
        Form form = formService.findById(formId)
                .orElseThrow(ResourceNotFoundException::new);
        document.setForm(form);

        return documentRepository.save(document);
    }

    @Override
    public byte[] load(long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        return fileRepository.load(document);
    }

    @Override
    public void upload(Path path, byte[] data) {
        fileRepository.upload(path, data);
    }
}
