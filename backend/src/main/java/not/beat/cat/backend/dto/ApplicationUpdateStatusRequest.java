package not.beat.cat.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import not.beat.cat.backend.model.ApplicationStatus;

@Data
public class ApplicationUpdateStatusRequest {
    @NotNull
    private final ApplicationStatus newStatus;

    private final String comment;
}
