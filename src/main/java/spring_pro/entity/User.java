package spring_pro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Enki
 * @ClassName User
 * @Description: TODO
 * @Date 2024/8/6 21:34
 * @Version 1.0
 */
@TableName("user")
@Data
@ToString
public class User {

    @TableId("id")
    private int userId;
    private String name;
    private Integer age;
    private String email;

}
