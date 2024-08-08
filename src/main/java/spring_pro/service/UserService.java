package spring_pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import spring_pro.entity.User;

/**
 * @author Enki
 * @ClassName UserService
 * @Description: TODO
 * @Date 2024/8/6 21:40
 * @Version 1.0
 */
public interface UserService extends IService<User> {
    User getUserByName(String name);
}
