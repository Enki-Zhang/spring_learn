package spring_pro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringProApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringProApplication.class, args);
        logger.info("日志测试");
    }

}
