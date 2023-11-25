package not.beat.cat.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountInfoCreateRequest {
    @NotNull
    private final Long formId;

    @Min(0)
    private final BigDecimal amount;

    @NotBlank
    private final String category;
}
