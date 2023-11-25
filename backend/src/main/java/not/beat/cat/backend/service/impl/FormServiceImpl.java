package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.model.Form;
import not.beat.cat.backend.repository.FormRepository;
import not.beat.cat.backend.service.FormService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    private final FormRepository formRepository;

    public FormServiceImpl(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @Override
    public List<Form> findAll() {
        return formRepository.findAll();
    }
}
