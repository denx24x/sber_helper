package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.model.Document;
import not.beat.cat.backend.repository.DocumentRepository;
import not.beat.cat.backend.service.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
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
    public Document save(Document document) {
        return documentRepository.save(document);
    }
}
