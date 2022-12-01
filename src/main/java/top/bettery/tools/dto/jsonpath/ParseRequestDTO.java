package top.bettery.tools.dto.jsonpath;

import lombok.Data;

/**
 * @author zy
 * @version 2022/11/30
 */
@Data
public class ParseRequestDTO {
    private String content;

    private String expression = "$";
}
