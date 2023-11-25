package not.beat.cat.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountInfoTo {
    private final Long id;
    private final BigDecimal amount;
    private final String category;
}
