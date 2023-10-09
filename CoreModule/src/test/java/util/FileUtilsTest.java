package util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {

    @Value("{file.upload.path}")
    private static String UPLOAD_DIR;

//    private final Environment environment;
//
//    public FileUtilsTest(Environment environment) {
//        this.environment = environment;
//    }
    @Test
    public void test() {
//        UPLOAD_DIR = environment.getProperty("file.upload.path");
        System.out.println("zz");
    }

}