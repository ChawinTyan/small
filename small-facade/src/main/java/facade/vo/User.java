package facade.vo;

import lombok.Data;

/**
 * Created by tianwenyuan on 2016/6/6.
 */
@Data
public class User {
    private Integer id;
    private String userCode;
    private String userName;
    private String telephoneNumber;
    private Integer status;
}
