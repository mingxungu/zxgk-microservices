package cn.com.pingtech.senseFace.controller;

import cn.com.pingtech.api.entity.ResponseVo;
import cn.com.pingtech.senseFace.domain.RequestPerson;
import cn.com.pingtech.senseFace.domain.UserInfo;
import cn.com.pingtech.senseFace.exception.SenseFaceException;
import cn.com.pingtech.senseFace.facade.SenseFaceFacade;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: psf
 * @Date: 2019/8/30 09:57
 * @Description:商汤静态库相关功能服务
 */

@Api(value = "商汤静态人脸服务", tags = {"商汤静态人脸服务接口"})
@RestController
@RequestMapping(value = "/senseFace")
public class SenseFaceStaticController {
    private final Logger logger = LoggerFactory.getLogger(SenseFaceStaticController.class);

    @Resource
    private SenseFaceFacade senseFaceFacade;

    /**
     * @Description 通过客户端传入的图片信息调用商汤1:N 静态人脸比对服务，若比中返回人员基本信息
     * @Author psf
     * @Date 2019/8/30
     */
    @RequestMapping  (value = "/searchInfoByImage")
    @ApiOperation(value = "根据传入图片搜索比中结果，人员信息查询", notes = "参数说明,base64Image:待检索人脸的base64字符串;dbType:db_id_check(人脸核查比对)或者db_id_login(民警人脸登录)")
    public ResponseVo searchInfoByImage(@ApiParam(name = "person", value = "人像图片参数", required = true)   @RequestBody RequestPerson person){

        logger.info("searchInfoByImage 接口被调用===== " + JSON.toJSONString(person));
        UserInfo userInfo = null;
        try {
            userInfo = senseFaceFacade.searchInfoByImage(person.getBase64Image(),person.getDbType() );
        } catch (SenseFaceException e) {
            logger.error(e.getMessage());
            return ResponseVo.error(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseVo.error(e.getMessage());
        }
        return ResponseVo.success(userInfo);
    }
}
