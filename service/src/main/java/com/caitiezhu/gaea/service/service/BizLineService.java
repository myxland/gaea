package com.caitiezhu.gaea.service.service;

import com.caitiezhu.gaea.service.common.Response;
import com.caitiezhu.gaea.service.model.dto.bizline.CreateBizLineDTO;

public interface BizLineService {

    Response create(CreateBizLineDTO createBizLineDTO);
}
