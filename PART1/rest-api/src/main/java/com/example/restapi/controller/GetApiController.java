package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import com.example.restapi.model.Multiply;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetApiController {

    //http://localhost:8080/api/hello
    //GET으로 Path Variable 을 통해 받기
    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";
        return html;
    }

    //http://localhost:8080/api/echo/steve/age/20/is-man/20
    //GET으로 Path Variable 을 통해 받기
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String ehco(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("echo message " + msg);
        System.out.println("echo age " + age);
        System.out.println("echo isMan " + isMan);

        return msg.toUpperCase();
    }

    //http://www.localhost:8080/api/book?category=IT&issuedYear=2024&issued-month=01&issued_day=31
    //GET으로 QueryParameter 받기
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    //http://www.localhost:8080/api/book2?category=IT&issuedYear=2024&issuedMonth=01&issuedDay=31
    //GET으로 QueryParameter 객체 받기
    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam //객체로 받을 때는 @RequestParam 생략 가능
    ){
        System.out.println(bookQueryParam);
    }

    // TODO 연습!
    // TODO Parameter 2가지를 int 형태로 받아서 두 수의 덧셈 return
    //http://localhost:8080/api/add?firstNum=3&secondNum=2
    @GetMapping(path = "/add")
    public int add(
            @RequestParam int firstNum,
            @RequestParam int secondNum
    ){
        return firstNum + secondNum;
    }

    // TODO Parameter 2가지를 int 형태로 받아서 두 수의 곱셈 return
    //http://localhost:8080/api/multiply?firstNum=3&secondNum=2
    @GetMapping(path = "multiply")
    public int multiply(
        Multiply Multiply
    ){
        return Multiply.getFirstNum() * Multiply.getSecondNum();
    }
}
