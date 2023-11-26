package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.DocumentCreateRequest;
import not.beat.cat.backend.dto.DocumentTo;
import not.beat.cat.backend.model.Document;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

@Component
public class DocumentTransformer {

    public Document transform(DocumentCreateRequest createRequest) {
        Document document = new Document();
        document.setType(createRequest.getType());
        document.setLocation(createRequest.getLocation());

        return document;
    }

    public DocumentTo transform(Document document, byte[] data) {
        return new DocumentTo(
                document.getId(),
                document.getType(),
                new ByteArrayResource(data),
                document.getLocation(),
                document.getCreationDate(),
                document.getUpdateDate()
        );
    }
}
