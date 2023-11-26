package not.beat.cat.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import not.beat.cat.backend.model.DocumentType;
import org.springframework.web.multipart.MultipartFile;

@Data
public class DocumentCreateRequest {
    private final long formId;

    @NotBlank
    private final String location;

    @NotNull
    private final DocumentType type;

    @NotNull
    private final MultipartFile file;
}
