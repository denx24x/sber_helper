package not.beat.cat.backend.service;

import not.beat.cat.backend.model.Form;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FormService {

    List<Form> findAll();
}
