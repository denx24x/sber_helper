package not.beat.cat.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountInfoCreateRequest {
    private final long formId;

    @Min(0)
    private final BigDecimal amount;

    @NotBlank
    private final String category;
}
