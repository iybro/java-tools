package top.bettery.tools.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bettery.tools.dto.ResultDto;
import top.bettery.tools.dto.jsonpath.ParseRequestDTO;
import top.bettery.tools.service.jsonpath.JsonPathService;

import javax.annotation.Resource;

/**
 * @author zy
 * @version 2022/11/30
 */
@RestController
@RequestMapping("/api/json")
public class JsonPathController {
    @Resource
    JsonPathService jsonPathService;

    @PostMapping("/parse")
    public ResultDto parse(@RequestBody ParseRequestDTO request){
        return  jsonPathService.parse(request);
    }

}
