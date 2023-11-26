package not.beat.cat.backend.transformer;

import not.beat.cat.backend.dto.CommentCreateRequest;
import not.beat.cat.backend.dto.CommentTo;
import not.beat.cat.backend.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentTransformer {
    public CommentTo transform(Comment comment) {
        return new CommentTo(
                comment.getId(),
                comment.getContent(),
                comment.getCreationDate(),
                comment.getUpdateDate()
        );
    }

    public Comment transform(CommentCreateRequest createRequest) {
        Comment comment = new Comment();
        comment.setContent(createRequest.getContent());

        return comment;
    }
}
