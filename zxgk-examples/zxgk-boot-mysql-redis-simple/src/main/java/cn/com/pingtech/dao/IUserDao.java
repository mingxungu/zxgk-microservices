package cn.com.pingtech.dao;

import cn.com.pingtech.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gumx
 * @className: IUserDao
 * @description: 用户的Dao
 * @date 2019/10/18 9:50
 */
@Repository
public interface IUserDao {

    List<User> findList();

}
