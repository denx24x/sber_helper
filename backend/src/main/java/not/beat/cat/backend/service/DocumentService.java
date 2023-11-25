package not.beat.cat.backend.service;

import not.beat.cat.backend.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Optional<Document> findById(long id);

    List<Document> findAllByFormId(long formId);

    Document save(Document document);
}
