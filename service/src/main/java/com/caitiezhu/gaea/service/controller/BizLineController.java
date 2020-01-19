package com.caitiezhu.gaea.service.controller;

import com.caitiezhu.gaea.service.common.Response;
import com.caitiezhu.gaea.service.model.dto.bizline.CreateBizLineDTO;
import com.caitiezhu.gaea.service.service.BizLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/biz-line")
public class BizLineController {
    @Autowired
    BizLineService bizLineService;

    @PostMapping("/create")
    public Response create(@RequestBody CreateBizLineDTO createBizLineDTO) {
        return bizLineService.create(createBizLineDTO);
    }
}
