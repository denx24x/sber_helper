package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.model.Form;
import not.beat.cat.backend.repository.FormRepository;
import not.beat.cat.backend.service.FormService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FormServiceImpl implements FormService {
    private final FormRepository formRepository;

    public FormServiceImpl(FormRepository formRepository) {
        this.formRepository = formRepository;
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
}
