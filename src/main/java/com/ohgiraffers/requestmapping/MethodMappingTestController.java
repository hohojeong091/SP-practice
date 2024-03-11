package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*DispatcherServlet은 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
* 그 과정은 컨트롤러 클래스의 핸들러 메서드에 선언 된 다양한 @RequestMapping 설정 내용에 따른다. */

@Controller
public class MethodMappingTestController {

    /*컨트롤러 안에 있는 메서드는 핸들러 메서드
    *  : 요청을 처리하는 메소드로 작동한다. */

    /*1. 요청 메소드 미지정*/
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        /*임포트 주소 확인 */

        /*Model 객체 addAttribute 메서드를 이용해 key, value를 추가하면 view에서 사용할 수 있다.
        * chap03-view-resolver에서 다시 다룬다*/
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");

        /*반환하고자 하는 view의 경로를 포함한 이름을 작성한다.
        * resources/templates 하위부터의 경로를 작성한다.
        * chap03-view-resolver에서 다시 다룬다. */

        return "mappingResult";
    }

    /*2. 요청 메소드 지정 */

    @RequestMapping(value ="/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {

        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출");


        return "mappingResult";

    }

        /*3. 요청 메소드 전용 어노테이션
        * @RequestMapping 어노테이션에 method 속성을 사용하여 요청 방법을 지정하는 것과 동일하다. */
    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }
}
