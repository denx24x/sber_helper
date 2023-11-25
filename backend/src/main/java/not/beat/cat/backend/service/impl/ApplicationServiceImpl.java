package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.repository.ApplicationRepository;
import not.beat.cat.backend.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Optional<Application> findById(long id) {
        return applicationRepository.findById(id);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public List<Application> findAllByStatuses(Set<ApplicationStatus> statuses) {
        return applicationRepository.findAllByStatuses(statuses);
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }
}
