package spring_pro.controller;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_pro.entity.User;
import spring_pro.resEnum.ResponseResult;
import spring_pro.resEnum.ResponseStatus;
import spring_pro.service.UserService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * @author Enki
 * @ClassName UserController
 * @Description: TODO
 * @Date 2024/8/6 21:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/logger")
    public ResponseResult<User> loggerPri() {
        User byId = userService.getById(1);
        logger.info("user的测试" + byId);
        return ResponseResult.success(byId);
    }

    /**
     * 根据id返回用户信息
     *
     * @param id
     * @return
     */
    @PostMapping("/findUser/{id}")
    public ResponseResult<User> queryUser(@PathVariable Long id) {
        return ResponseResult.success(userService.getById(id));
    }

    /**
     * 根据姓名查询用户信息
     * 查询urL:/user/getUser/
     *
     * @param name
     * @return
     */
    @GetMapping("/getUser/{name}")
    public ResponseResult<User> getUser(@PathVariable("name") String name) {
        logger.info("Received request to get user with name: {}", name);//这里的日志会记录在日志文件中 具体设置路径在-spring.xml
        User targetUser = userService.getUserByName(name);
        if (targetUser == null) {
            return ResponseResult.fail(null, "User not found with name: " + name);
        } else
            return ResponseResult.success(targetUser);
    }

    /**
     * http://localhost:8080/user/getName?name=Jone
     *
     * @param name
     * @return
     */
    @GetMapping("/getName")
    public ResponseResult<User> getUserByName(@RequestParam String name) {
        logger.info("user get name with requestParm");
//        logger.warn("控制台日志显示");
        User user = userService.getUserByName(name);
        if (user == null) {
            return ResponseResult.fail(null, "fail");
        } else return ResponseResult.success(user);
    }

    /***
     * post提交表单信息
     * @param user
     * @return
     */
    @PostMapping("/getBody")
    public ResponseResult<User> getUserBody(@Valid @RequestBody User user) {
        return ResponseResult.success(user);
    }
}
