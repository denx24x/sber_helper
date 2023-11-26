package not.beat.cat.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentCreateRequest {
    private final long applicationId;

    @NotBlank
    private final String content;
}
