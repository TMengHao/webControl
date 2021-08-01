package org.blue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;

@SpringBootTest
class WebControlApplicationTests {

    @Test
    void contextLoads() {
        String currentpath = "";
        String logAppContext = "";
        if (Thread.currentThread().getContextClassLoader().getResource("") != null) {
            currentpath = Thread.currentThread().getContextClassLoader().getResource("").toString().replace("%23", "#")
                    .replace("file:/", "");
            logAppContext = currentpath.isEmpty() ? logAppContext
                    : Paths.get(currentpath).getParent().getParent().getFileName().toString();
            System.out.println(currentpath);
            System.out.println(logAppContext);
            //System.setProperty("finLog", logAppContext);
            //System.setProperty("context", logAppContext);
        }
    }

}
