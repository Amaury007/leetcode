package algorithm.multithreading;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author sannian
 * @Date 2021/3/8 16:55
 * @Version 1.0
 */

public class FooBar {
    public static void main(String[] args) throws ParseException {
        String str = "1615050161378";
        DateFormat pf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Long craw= pf.parse(str).getTime();
        System.out.println(craw);
    }
}
