package not.beat.cat.backend.repository;

import not.beat.cat.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT comment FROM Comment comment " +
            "WHERE comment.application.id = :applicationId " +
            "ORDER BY comment.creationDate"
    )
    List<Comment> findByApplicationId(@Param("applicationId") long applicationId);
}
