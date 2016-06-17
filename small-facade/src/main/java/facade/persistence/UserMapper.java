package facade.persistence;

import facade.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by tianwenyuan on 2016/6/17.
 */

public interface UserMapper {
    @Insert("insert into user(user_code,user_name,telephone_number,status) values (#{userCode},#{userName},#{telephoneNumber},#{status})")
    public int addUser(User user);

    @Select("select * from user")
    public List<User> queryUsers();
}
