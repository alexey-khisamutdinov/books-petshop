package net.shamansoft.readinglist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Value("${main.message.hello}")
    private String helloMessage;

    public String sayHello(List<String> names){
        if(names == null || names.isEmpty()){
            return String.format(helloMessage, "Anonymous");
        }
        String username;
        switch (names.size()){
            case 1 :
                username = names.get(0);
                break;
            case 2:
                username = String.format("%s and %s", names.get(0), names.get(1));
                break;
            default:
                username = String.join(", ", names);
        }
        return String.format(helloMessage, username);
    }
}
