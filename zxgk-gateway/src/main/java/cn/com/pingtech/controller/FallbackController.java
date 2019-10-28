package cn.com.pingtech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gumx
 * @className: FallbackController
 * @description: 降级处理
 * @date 2019/10/15 14:51
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback() {
        return "error......Hello World!\nfrom gateway";
    }

    @GetMapping("/defaultFallback")
    public String defaultFallback() {
        return "defaultFallback...error...Hello World!\nfrom gateway";
    }

}
