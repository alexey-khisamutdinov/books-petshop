package net.shamansoft.readinglist;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.util.Lists.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void sayHelloTo3Users() {
        assertEquals("Hola, User 1, User 2, User 3!", helloService.sayHello(
                list("User 1", "User 2", "User 3")));
    }
    @Test
    void sayHelloTo2Users() {
        assertEquals("Hola, User 1 and User 2!", helloService.sayHello(
                list("User 1", "User 2")));
    }

    @Test
    void sayHelloTo1Users() {
        assertEquals("Hola, User 1!", helloService.sayHello(
                list("User 1")));
    }
    @Test
    void sayHelloTo0Users() {
        assertEquals("Hola, Anonymous!", helloService.sayHello(emptyList()));
    }

    @Test
    void sayHelloToNullInput() {
        assertEquals("Hola, Anonymous!", helloService.sayHello(null));
    }
}