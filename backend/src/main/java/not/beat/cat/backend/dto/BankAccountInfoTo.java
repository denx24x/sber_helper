package not.beat.cat.backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BankAccountInfoTo {
    private final Long id;
    private final BigDecimal amount;
    private final String category;
    private final LocalDateTime creationDate;
    private final LocalDateTime updateDate;
}
