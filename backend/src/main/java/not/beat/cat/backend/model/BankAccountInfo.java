package not.beat.cat.backend.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountInfo {
    private final BigDecimal amount;
    private final String category;
}
