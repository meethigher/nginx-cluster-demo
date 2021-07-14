package top.meethigher.nginxserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class NginxServerApplicationTests {
    @Autowired
    RestTemplate restTemplate;

    @Test
    void contextLoads() {
        int _8080=0,_8081=0,_8082=0;
        for(int i=0;i<12;i++){
            String forObject = restTemplate.getForObject("http://localhost:13000", String.class);
            if(forObject.equals("8080")){
                _8080++;
            }else if(forObject.equals("8082")){
                _8082++;
            }else {
                _8081++;
            }
        }
        System.out.println("8080="+_8080+"次");
        System.out.println("8081="+_8081+"次");
        System.out.println("8082="+_8082+"次");

    }

}
