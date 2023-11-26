package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.exception.ResourceNotFoundException;
import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.BankAccountInfo;
import not.beat.cat.backend.model.Form;
import not.beat.cat.backend.repository.BankAccountInfoRepository;
import not.beat.cat.backend.repository.FormRepository;
import not.beat.cat.backend.service.ApplicationService;
import not.beat.cat.backend.service.FormService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormServiceImpl implements FormService {
    private final ApplicationService applicationService;
    private final FormRepository formRepository;
    private final BankAccountInfoRepository bankAccountInfoRepository;

    public FormServiceImpl(
            ApplicationService applicationService,
            FormRepository formRepository,
            BankAccountInfoRepository bankAccountInfoRepository
    ) {
        this.applicationService = applicationService;
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
    public Form save(long applicationId, Form form) {
        Application application = applicationService.findById(applicationId)
                .orElseThrow(ResourceNotFoundException::new);
        application.addForm(form);
        form.setApplication(application);

        return formRepository.save(form);
    }

    @Override
    public BankAccountInfo saveBankAccountInfo(long id, BankAccountInfo bankAccountInfo) {
        Form form = formRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        form.setBankAccountInfo(bankAccountInfo);
        bankAccountInfo.setForm(form);

        return bankAccountInfoRepository.save(bankAccountInfo);
    }
}
