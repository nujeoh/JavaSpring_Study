package com.example.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
        @PathVariable String userName
    ){
        log.info("user-name :  {}", userName);
    }
}
