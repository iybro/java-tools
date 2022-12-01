package top.bettery.tools.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResultDto<T> extends BaseResultDto {

    private T data;

    public ResultDto(Integer code, String msg, T data) {
        super(code, msg);
        this.data = data;
    }

    public boolean isOk() {
        return resultOk() && Objects.nonNull(this.data);
    }

    public static <T> ResultDto<T> ok() {
        return new ResultDto<>(success, success_message, null);
    }

    public static <T> ResultDto<T> ok(T data) {
        return new ResultDto<>(success, success_message, data);
    }

    public static <T> ResultDto<T> ok(String msg, T data) {
        return new ResultDto<>(success, msg, data);
    }

    public static <T> ResultDto<T> error(String msg) {
        return new ResultDto<>(common_error, msg, null);
    }

    public static <T> ResultDto<T> error(Integer code, String msg) {
        return new ResultDto<>(code, msg, null);
    }

    public static <T> ResultDto<T> error(Integer code, String msg, T data) {
        return new ResultDto<>(code, msg, data);
    }
}
