package postgre.create.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private String createdDate;
    private Long viewCount;
    private String language;
    private String password;


}
