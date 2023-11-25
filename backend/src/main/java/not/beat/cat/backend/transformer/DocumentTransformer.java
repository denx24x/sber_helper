package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.DocumentTo;
import not.beat.cat.backend.model.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentTransformer {

    public Document transform(DocumentTo documentTo) {
        return new Document();
    }

    public DocumentTo transform(Document document) {
        return null;
    }
}
