package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*클래스 레벨에도 @RequestMapping 사용이 가능하다.
* URL을 공통 부분을 이용해서 설정하고 나면 매번 핸들러 메소드의 URL에 중복 내용을 작성하지 않아도 된다.*/
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    @GetMapping("regist")
    public String registOrder(Model model) {
        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메세지 호출");

        return "mappingResult";

    }

    /*여러개의 패턴 매핑*/
    @RequestMapping(value= {"/modify", "/delete"}, method= RequestMethod.POST)
    public String modifyAndDelete(Model model) {
        model.addAttribute("message", "POST 방식의 주문 수정, 삭제 공통 처리 핸들러 메세지 호출");

    return "mappingResult";

    }

    /*path variable : 요청 주소에 포함 된 변수 */
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(@PathVariable("orderNo") int orderNo, Model model) {

        /*parsing 불가능한 path variable이 전달 되면 400(Bad Request) 에러가 발생한다. */
        model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출");

        return "mappingResult";

    }
    /*그 외의 다른 요청
    * 아무런 URL을 설정하지 않으면 요청 처리에 대한 핸들러 메소드가 준비되지 않았을 때 해당 메소드를 호출 */
    @RequestMapping
    public String otherRequest(Model model) {
        model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 아직 준비 되지 않음");
        return "mappingResult";
    }

}
