package site.liuye.demo.entity;

import lombok.Data;

@Data
public class UserRoleDTO {
    private Long id;
    private Long userId;
    private String username;
    private Long roleId;
    private String roleName;
}
