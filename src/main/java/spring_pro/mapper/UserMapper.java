package spring_pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import spring_pro.entity.User;

/**
 * @author Enki
 * @ClassName UserRepository
 * @Description: TODO
 * @Date 2024/8/6 21:34
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //    数据访问层，数据放在内存中。
    @Select("select * from user where name = #{name}")
    User getUserByName(String name);
}
