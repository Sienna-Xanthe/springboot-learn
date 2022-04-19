package com.kuang;

import com.kuang.pojo.Dog;
import com.kuang.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Springboot02ConfigApplicationTests {

    @Autowired
    private Person per;

    @Test
    void contextLoads(){
        System.out.println(per);
    }
}
