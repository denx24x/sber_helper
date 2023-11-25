package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.BankAccountInfoTo;
import not.beat.cat.backend.model.BankAccountInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BankAccountTransformer {

    public BankAccountInfo transform(BankAccountInfoTo bankAccountInfoTo) {
        BankAccountInfo bankAccountInfo = new BankAccountInfo();
        bankAccountInfo.setFormId(bankAccountInfo.getFormId());
        bankAccountInfo.setAmount(bankAccountInfo.getAmount());
        bankAccountInfo.setCategory(bankAccountInfo.getCategory());

        return bankAccountInfo;
    }

    public BankAccountInfoTo transform(BankAccountInfo bankAccountInfo) {
        return new BankAccountInfoTo(
                bankAccountInfo.getFormId(),
                bankAccountInfo.getAmount(),
                bankAccountInfo.getCategory()
        );
    }
}
