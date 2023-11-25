package not.beat.cat.backend.dto;

import lombok.Data;
import not.beat.cat.backend.model.ApplicationStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ApplicationTo {
    private final Long id;
    private final BigDecimal amount;
    private final Integer termMonths;
    private final BigDecimal interest;
    private final String product;
    private final ApplicationStatus status;
    private final LocalDateTime creationDate;
    private final LocalDateTime updateDate;
}
