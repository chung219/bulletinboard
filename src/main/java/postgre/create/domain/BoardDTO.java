package postgre.create.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDTO {
    private String title;
    private String writer;
    private String content;
    private String password;
    private String language;
}
