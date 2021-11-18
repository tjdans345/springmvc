package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age =Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            // 파라미터 명과 변수명이 같으면 ("파라미터명") 생략 가능
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ) {
        log.info("username ={}, age={} ", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            // 파라미터 명과 변수명이 같으면 ("파라미터명") 생략 가능
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username ={}, age={} ", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            // 파라미터 명과 변수명이 같으면 ("파라미터명"), @RequestParam 생략 가능
            String username,
            int age
    ) {
        log.info("username ={}, age={} ", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            // required = true -> 무조건 있어야하는 필수 파라미터
            // required = false -> 없어도 되는 선택 파라미터
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age
    ) {
        // 기본형에는 null이 못들어간다.!
        // 객체형에는 null이 들어갈 수 있다.!
        // int 기본형, Integer wrapper 타입(객체형)
        log.info("username ={}, age={} ", username, age);
        return "okz";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamRequired(
            // Map으로 한꺼번에 다 받을 수 있다.
            // MultiValueMap -> 같은 키값의 파라미터가 여러개일 경우에 사용하면 된다 ex) username=kim&username=lee 이렇게 같은 파라미터로 키값으로 데이터가 들어오는 경우
            @RequestParam Map<String, Object> paramMap
    ) {
        // 기본형에는 null이 못들어간다.
        // 객체형에는 null이 들어갈 수 있다.
        // int 기본형, Integer wrapper 타입(객체형)
        log.info("username ={}, age={} ", paramMap.get("username") , paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        // ModelAttribute -> 객체로 받아 올 수 있는 역할
        // 객체를 찍었을 때 스트링으로 바꿔주는 역할 .toString()
        // 예외 처리가 중요하다.
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("modelAttributeV2 username={}, age={} " + helloData.getUsername(), helloData.getAge());
        // 객체를 찍었을 때 스트링으로 바꿔주는 역할 .toString()
        // 예외 처리가 중요하다.
        return "ok";
    }

}
