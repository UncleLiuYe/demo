package site.liuye.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRole extends BaseEntity {
    private Long userId;
    private Long roleId;
}