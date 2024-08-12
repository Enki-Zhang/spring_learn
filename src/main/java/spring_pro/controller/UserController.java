package spring_pro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import spring_pro.entity.User;
import spring_pro.exception.MyException;
import spring_pro.result.ResponseResult;
import spring_pro.service.UserService;

import javax.validation.Valid;

/**
 * @author Enki
 * @ClassName UserController
 * @Description: TODO
 * @Date 2024/8/6 21:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
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
    @ApiOperation(value = "根据ID获取用户", notes = "提供用户ID来获取用户详细信息")
    public ResponseResult<User> queryUser(@ApiParam(value = "用户ID", required = true) @PathVariable Long id) {
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
    @ApiOperation(value = "根据用户名获取用户", notes = "提供用户名来获取用户详细信息")
    public ResponseResult<User> getUser(@ApiParam(value = "用户名", required = true) @PathVariable("name") String name) {
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
    @ApiOperation(value = "根据用户名获取用户", notes = "提供用户名来获取用户详细信息")
    public ResponseResult<User> getUserByName(@ApiParam(value = "用户名", required = true) @RequestParam String name) {
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

    /**
     * 测试全局异常
     *
     * @param user
     * @return
     */
    @PostMapping("/insertUser")
    public Boolean insertUser(@RequestBody User user) {
        System.out.println("新增用户");
        //若是用户名为空则爆出异常
        if (user.getName() == null) {
            throw new MyException("-1", "用户姓名不能为空！");
        }
        return true;
    }

}
