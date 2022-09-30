package com.ruoyi.extend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Gpu is all you need
 * @date 2022/9/24
 */
@RestController
@CrossOrigin
@Validated
@RequiredArgsConstructor
@RequestMapping("nocheck")
public class TestController {
    @RequestMapping("data")
    public String getData() {
        return "nihao";
    }
}
