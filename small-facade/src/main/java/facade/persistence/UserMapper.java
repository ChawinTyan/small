package facade.persistence;

import facade.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by tianwenyuan on 2016/6/17.
 */

public interface UserMapper {

    @Options(
            useGeneratedKeys = true,
            keyColumn = "id",
            keyProperty = "id"
    )
    @Insert("insert into user(user_code,user_name,telephone_number,status) values (#{userCode},#{userName},#{telephoneNumber},#{status})")
    public int addUser(User user);


    @Results({
            @Result(column = "user_code", property = "userCode"),
            @Result(column = "user_Name", property = "userName"),
            @Result(column = "telephone_number", property = "telephoneNumber")
    })
    @Select("select * from user")
    public List<User> queryUsers();
}
