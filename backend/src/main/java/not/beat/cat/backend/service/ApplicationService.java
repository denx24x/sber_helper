package not.beat.cat.backend.service;

import not.beat.cat.backend.dto.FormTo;
import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.model.Form;
import not.beat.cat.backend.transformer.ApplicationTransformer;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ApplicationService {

    Optional<Application> findById(long id);

    List<Application> findAll();

    List<Application> findAllByStatuses(Set<ApplicationStatus> statuses);

    Application save(Application application);
}