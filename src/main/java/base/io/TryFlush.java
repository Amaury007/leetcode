package base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author sannian
 * @Date 2021/3/26 10:19
 * @Version 1.0
 */

public class TryFlush {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("/Users/nineer/IdeaProjects/Util-Collecttion/src/main/java/sx/nine/swagger/swagger.md");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/nineer/IdeaProjects/Util-Collecttion/src/main/java/sx/nine/swagger/swagger33.md");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);){

            int size;
            byte[] bytes = new byte[1024];
            while ((size=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,size);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
