package com.coderme.auth.controller;

import com.coderme.auth.controller.param.LoginParam;
import com.coderme.auth.controller.param.RegisterParam;
import com.coderme.auth.service.ISecurityService;
import com.coderme.commons.base.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author qiudm
 * @date 2018/5/30 17:51
 * @desc
 */
@RestController
@RequestMapping("security")
public class SecurityController {

    @Autowired
    private ISecurityService securityService;

    @PostMapping("/register")
    public JsonResult register(@RequestBody @Valid RegisterParam param) {
        securityService.register(param);
        return JsonResult.SUCCESS();
    }

    @PostMapping("/login")
    public JsonResult login(@RequestBody LoginParam param) {
        return JsonResult.SUCCESS(securityService.login(param));
    }






}
