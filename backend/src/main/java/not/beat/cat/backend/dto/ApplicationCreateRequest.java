package not.beat.cat.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplicationCreateRequest {
    @Min(0)
    private final BigDecimal amount;

    @Min(0)
    private final Integer termMonths;

    @Min(0)
    @Max(100)
    private final BigDecimal interest;

    @NotBlank
    private final String product;
}
