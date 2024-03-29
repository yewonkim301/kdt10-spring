package codingon.condingonspringbootjpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private String registered;
}
