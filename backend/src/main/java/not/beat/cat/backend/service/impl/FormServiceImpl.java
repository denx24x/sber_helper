package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.model.BankAccountInfo;
import not.beat.cat.backend.model.Form;
import not.beat.cat.backend.repository.BankAccountInfoRepository;
import not.beat.cat.backend.repository.FormRepository;
import not.beat.cat.backend.service.FormService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormServiceImpl implements FormService {
    private final FormRepository formRepository;
    private final BankAccountInfoRepository bankAccountInfoRepository;

    public FormServiceImpl(
            FormRepository formRepository,
            BankAccountInfoRepository bankAccountInfoRepository
    ) {
        this.formRepository = formRepository;
        this.bankAccountInfoRepository = bankAccountInfoRepository;
    }

    @Override
    public Optional<Form> findById(long id) {
        return formRepository.findById(id);
    }

    @Override
    public List<Form> findAllByApplicationId(long applicationId) {
        return formRepository.findAllByApplicationId(applicationId);
    }

    @Override
    public Form save(Form form) {
        return formRepository.save(form);
    }

    @Override
    public BankAccountInfo saveBankAccountInfo(BankAccountInfo bankAccountInfo) {
        return bankAccountInfoRepository.save(bankAccountInfo);
    }
}
