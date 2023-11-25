package not.beat.cat.backend.service;

import not.beat.cat.backend.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Optional<Comment> findById(long id);

    Comment save(Comment comment);

    List<Comment> findAllByApplicationId(long applicationId);
}
