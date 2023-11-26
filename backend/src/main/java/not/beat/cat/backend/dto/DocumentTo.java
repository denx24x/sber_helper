package not.beat.cat.backend.dto;

import lombok.Data;
import not.beat.cat.backend.model.DocumentType;
import org.springframework.core.io.Resource;

import java.time.LocalDateTime;

@Data
public class DocumentTo {
    private final Long id;
    private final DocumentType type;
    private final Resource file;
    private final String location;
    private final LocalDateTime creationDate;
    private final LocalDateTime updateDate;
}
