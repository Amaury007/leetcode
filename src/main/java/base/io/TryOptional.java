package base.io;

import java.util.Optional;

/**
 * @Author sannian
 * @Date 2021/5/26 15:11
 * @Version 1.0
 */

public class TryOptional {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("zhangsan");
        System.out.println(stringOptional.map(e -> e.toUpperCase()).orElse("失败"));

        stringOptional = Optional.empty();
        System.out.println(stringOptional.map(e -> e.toUpperCase()).orElse("失败"));
    }
}
