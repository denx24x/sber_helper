package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.exception.ResourceNotFoundException;
import not.beat.cat.backend.model.Application;
import not.beat.cat.backend.model.ApplicationStatus;
import not.beat.cat.backend.model.Comment;
import not.beat.cat.backend.repository.ApplicationRepository;
import not.beat.cat.backend.service.ApplicationService;
import not.beat.cat.backend.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final CommentService commentService;

    public ApplicationServiceImpl(
            ApplicationRepository applicationRepository,
            CommentService commentService
    ) {
        this.applicationRepository = applicationRepository;
        this.commentService = commentService;
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

    @Override
    public Comment saveComment(long id, Comment comment) {
        Application application = findById(id).orElseThrow(ResourceNotFoundException::new);
        application.addComment(comment);
        comment.setApplication(application);

        return commentService.save(comment);
    }
}
