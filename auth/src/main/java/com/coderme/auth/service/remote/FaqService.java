package com.coderme.auth.service.remote;

import com.coderme.utils.JsonResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qiudm
 * @date 2018/5/23 19:34
 * @desc
 */
@FeignClient(value = "FAQ")
public interface FaqService {

    @GetMapping("test/test")
    JsonResult test();

}
