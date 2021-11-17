package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    /**
     * 
     * @param request
     * @param response
     * @param httpMethod
     * @param locale
     * @param headerMap
     * @param host
     * @param cookie
     * @return
     */
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          // locale -> 언어정보
                          Locale locale,
                          //MultiValueMap -> 하나의 키에 여러값을 받을 수 있다. -> 모든 값을 다 받는다.
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host, // 단일 값만 받고싶을 때
                          @CookieValue(value = "myCookie", required = false) String cookie) {

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }




}
