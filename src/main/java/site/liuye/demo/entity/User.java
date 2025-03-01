package site.liuye.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private Boolean deleted;
}
