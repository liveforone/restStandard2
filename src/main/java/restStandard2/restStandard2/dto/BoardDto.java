package restStandard2.restStandard2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;
import restStandard2.restStandard2.domain.Board;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private int good;
    private String saveFileName;
    private LocalDateTime createdDate;

    public Board toEntity() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .good(good)
                .saveFileName(saveFileName)
                .build();
    }
}
