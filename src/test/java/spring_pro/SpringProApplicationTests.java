package spring_pro;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring_pro.entity.User;
import spring_pro.service.UserService;

import java.util.List;


@SpringBootTest
class SpringProApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> list = userService.list();
        list.forEach(System.out::println);
//        logger.info("这是测试测试");
    }

}
