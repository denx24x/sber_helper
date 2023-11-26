package not.beat.cat.backend.service;

import not.beat.cat.backend.model.Document;
import not.beat.cat.backend.model.DocumentType;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Optional<Document> findById(long id);

    List<Document> findAllByFormId(long formId);

    Document save(long formId, Document document);

    byte[] load(long id);

    void upload(Path path, byte[] data);

    Optional<Document> findByType(long id, DocumentType documentType);
}
