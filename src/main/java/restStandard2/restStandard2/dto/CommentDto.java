package restStandard2.restStandard2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import restStandard2.restStandard2.domain.Comment;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String user;
    private String content;
    private Long boardId;
    private LocalDateTime createdDate;

    public Comment toEntity() {
        return Comment.builder()
                .id(id)
                .user(user)
                .content(content)
                .boardId(boardId)
                .build();
    }
}
