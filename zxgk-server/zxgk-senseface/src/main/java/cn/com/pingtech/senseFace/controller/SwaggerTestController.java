package cn.com.pingtech.senseFace.controller;

import cn.com.pingtech.api.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: psf
 * @Date: 2019/9/25 10:25
 * @Description:
 */


@RestController
@Api(value = "swagger测试Controller", tags = "swagger接口测试")
public class SwaggerTestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "test方法传入用户名和密码,返回用户名密码")
    public ResponseVo test(String name, String password) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("password", password);
        return ResponseVo.success(data);
    }


}
