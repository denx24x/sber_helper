package not.beat.cat.backend.service;

import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.model.Form;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FormService {
    Optional<Form> findById(long id);

    List<Form> findAllByApplicationId(long applicationId);

    Form save(Form form);
}
