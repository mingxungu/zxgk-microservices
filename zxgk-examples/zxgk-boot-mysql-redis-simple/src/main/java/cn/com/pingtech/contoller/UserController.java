package cn.com.pingtech.contoller;

import cn.com.pingtech.entity.User;
import cn.com.pingtech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gumx
 * @className: UserController
 * @description: 用户Controller
 * @date 2019/10/21 8:42
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userList")
    public List<User> getUserList(){
       return userService.getUserList();
    }
}
