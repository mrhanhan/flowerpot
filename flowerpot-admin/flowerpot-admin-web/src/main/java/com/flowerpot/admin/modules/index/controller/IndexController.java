package com.flowerpot.admin.modules.index.controller;

import com.flowerpot.admin.modules.base.BaseController;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * IndexController
 *
 * @author Mrhan
 * @date 2021/3/20 11:16
 */
@RestController
public class IndexController extends BaseController {

    @GetMapping("")
    public String index(HttpServletResponse resp) {
        resp.setHeader("Set-Cookie", ResponseCookie.from("test", "a")
                                             .domain(".local.com")
                                             .httpOnly(true)
                                             .build().toString());
        return "Hello World";
    }
}
