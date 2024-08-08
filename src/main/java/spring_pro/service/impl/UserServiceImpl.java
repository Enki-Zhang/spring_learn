package spring_pro.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_pro.entity.User;
import spring_pro.mapper.UserMapper;
import spring_pro.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Enki
 * @Date 2024/8/7 9:21
 * @Verison 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
