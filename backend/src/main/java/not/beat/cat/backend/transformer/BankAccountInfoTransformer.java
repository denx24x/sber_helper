package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.BankAccountInfoCreateRequest;
import not.beat.cat.backend.dto.BankAccountInfoTo;
import not.beat.cat.backend.model.BankAccountInfo;
import org.springframework.stereotype.Component;

@Component
public class BankAccountInfoTransformer {

    public BankAccountInfo transform(BankAccountInfoTo bankAccountInfoTo) {
        BankAccountInfo bankAccountInfo = new BankAccountInfo();
        bankAccountInfo.setId(bankAccountInfo.getId());
        bankAccountInfo.setAmount(bankAccountInfo.getAmount());
        bankAccountInfo.setCategory(bankAccountInfo.getCategory());
        bankAccountInfo.setCreationDate(bankAccountInfoTo.getCreationDate());
        bankAccountInfo.setUpdateDate(bankAccountInfoTo.getUpdateDate());

        return bankAccountInfo;
    }

    public BankAccountInfo transform(BankAccountInfoCreateRequest createRequest) {
        BankAccountInfo bankAccountInfo = new BankAccountInfo();
        bankAccountInfo.setAmount(createRequest.getAmount());
        bankAccountInfo.setCategory(createRequest.getCategory());

        return bankAccountInfo;
    }

    public BankAccountInfoTo transform(BankAccountInfo bankAccountInfo) {
        return new BankAccountInfoTo(
                bankAccountInfo.getId(),
                bankAccountInfo.getAmount(),
                bankAccountInfo.getCategory(),
                bankAccountInfo.getCreationDate(),
                bankAccountInfo.getUpdateDate()
        );
    }
}
