package com.flowerpot.admin.modules.index.controller;

import com.flowerpot.admin.modules.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @author Mrhan
 * @date 2021/3/20 11:16
 */
@RestController
public class IndexController extends BaseController {

    @GetMapping("")
    public String index() {
        return "Hello World";
    }
}
