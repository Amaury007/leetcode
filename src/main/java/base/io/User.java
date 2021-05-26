package base.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author sannian
 * @Date 2021/5/26 15:27
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String address;
}
