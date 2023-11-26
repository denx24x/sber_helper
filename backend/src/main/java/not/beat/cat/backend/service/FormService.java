package not.beat.cat.backend.service;

import not.beat.cat.backend.model.BankAccountInfo;
import not.beat.cat.backend.model.Form;

import java.util.List;
import java.util.Optional;

public interface FormService {
    Optional<Form> findById(long id);

    List<Form> findAllByApplicationId(long applicationId);

    Form save(long applicationId, Form form);

    BankAccountInfo saveBankAccountInfo(long id, BankAccountInfo bankAccountInfo);
}
