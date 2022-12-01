package top.bettery.tools.service.jsonpath;

import com.jayway.jsonpath.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.bettery.tools.dto.ResultDto;
import top.bettery.tools.dto.jsonpath.ParseRequestDTO;
import top.bettery.tools.dto.jsonpath.ParseResponseDTO;

/**
 * @author zy
 * @version 2022/11/30
 */
@Slf4j
@Service
public class JsonPathService {
    public ResultDto<ParseResponseDTO> parse(ParseRequestDTO request){
        ParseResponseDTO responseDTO = new ParseResponseDTO();

        Configuration conf = Configuration.defaultConfiguration();
        Configuration conf2 = conf.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        DocumentContext context = JsonPath.using(conf2).parse(request.getContent());
        try {
            Object read = context.read(request.getExpression());
            String clazzName = null;
            if(read != null){
                clazzName = read.getClass().getName();
                log.info("数据类型:{}",clazzName);
            }
            responseDTO.setDataType(clazzName);
            responseDTO.setContent(read);
        }catch (JsonPathException exception){
            String res = "路径:【"+request.getExpression()+"】解析失败，请检查。";
            responseDTO.setDataType(null);
            responseDTO.setContent(res);
            return ResultDto.error(500,res,responseDTO);
        }

        return ResultDto.ok(responseDTO);
    }
}
