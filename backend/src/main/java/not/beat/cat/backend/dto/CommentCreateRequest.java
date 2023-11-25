package not.beat.cat.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentCreateRequest {
    @NotNull
    private final Long applicationId;

    @NotBlank
    private final String content;
}
