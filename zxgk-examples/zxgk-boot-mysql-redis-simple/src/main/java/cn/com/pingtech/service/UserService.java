package cn.com.pingtech.service;

import cn.com.pingtech.dao.IUserDao;
import cn.com.pingtech.entity.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gumx
 * @className: UserService
 * @description: 用户逻辑
 * @date 2019/10/18 9:51
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private IUserDao dao;

    @Autowired
    RedisTemplate redisTemplate;

    public List<User> getUserList(){
        List<User> userList = dao.findList();
        try {
            redisTemplate.opsForHash().put("h:springcloud:test", "user:" + userList.get(0).getId(), JSON.toJSONString(userList.get(0)));
        }catch (Exception e){
            log.error("存入Redis报错，错误信息：{}",e.getMessage());
        }
        return dao.findList();
    }
}
