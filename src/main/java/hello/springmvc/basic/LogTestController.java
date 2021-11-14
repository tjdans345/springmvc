package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        log.trace("trace log={}", name);
        // debug : 개발서버에서 보는 정보
        log.debug("debug log={}", name);
        // info 비지니스 정보 또는 운영시스템에서 봐야하는 정보
        log.info(" info log = {}", name);
        // 경고 위험한 것
        log.warn(" warn log = {}", name);
        // 에러야 빨리 확인해야하는 것
        log.error(" error log = {}", name);
        return "ok";
    }

}
