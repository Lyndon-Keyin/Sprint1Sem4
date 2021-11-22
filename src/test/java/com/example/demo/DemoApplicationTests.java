package com.example.demo;

import com.example.restservice.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private MainController greetingController;

    @Test
    void contextLoads() throws Exception{
        assertThat(greetingController).isNotNull();
    }

}
