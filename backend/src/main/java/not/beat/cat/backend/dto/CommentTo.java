package not.beat.cat.backend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentTo {
    private final Long id;
    private final String content;
    private final LocalDateTime creationDate;
    private final LocalDateTime updateDate;
}
