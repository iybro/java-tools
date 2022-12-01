package top.bettery.tools.dto;

import lombok.Data;

@Data
public class BaseResultDto {

    private static final long serialVersionUID = -5307177740321084526L;

    public static final int success = 1;

    public static final int common_error = 500;

    public static final String success_message = "请求成功";

    private Integer code;

    private String message;

    public boolean resultOk() {
        return success == this.code;
    }

    public BaseResultDto(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public BaseResultDto() {

    }

}
