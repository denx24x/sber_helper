package not.beat.cat.backend.model;

import lombok.Data;

@Data
public class Document {
    private final long id;
    private final DocumentType type;
    private final String location;
}
