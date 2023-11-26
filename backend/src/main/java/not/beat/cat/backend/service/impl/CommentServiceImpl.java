package not.beat.cat.backend.service.impl;

import not.beat.cat.backend.model.Comment;
import not.beat.cat.backend.repository.CommentRepository;
import not.beat.cat.backend.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<Comment> findById(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllByApplicationId(long applicationId) {
        return commentRepository.findByApplicationId(applicationId);
    }
}
