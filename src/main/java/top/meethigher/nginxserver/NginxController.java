package top.meethigher.nginxserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Controller
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/7/14
 */
@Controller
public class NginxController {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    private Logger log= LoggerFactory.getLogger(NginxController.class);
    @Value("${server.port}")
    private Integer port;
    @RequestMapping(value="/",method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity enter(){
        log.info("访问"+port+"服务器...");
        return new ResponseEntity(port, HttpStatus.OK);
    }
}
