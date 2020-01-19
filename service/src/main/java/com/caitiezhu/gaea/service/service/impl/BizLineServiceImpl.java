package com.caitiezhu.gaea.service.service.impl;

import com.caitiezhu.gaea.service.common.Response;
import com.caitiezhu.gaea.service.dao.BizLineDAO;
import com.caitiezhu.gaea.service.enums.ErrorCode;
import com.caitiezhu.gaea.service.model.dto.bizline.CreateBizLineDTO;
import com.caitiezhu.gaea.service.service.BizLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BizLineServiceImpl implements BizLineService {
    @Autowired
    private BizLineDAO bizLineDAO;

    @Override
    public Response create(CreateBizLineDTO createBizLineDTO) {
        int result = bizLineDAO.insert(createBizLineDTO);
        if (result > 0) {
            return Response.build(ErrorCode.SUCCESS);
        }
        return Response.build(ErrorCode.FAIL);
    }
}
