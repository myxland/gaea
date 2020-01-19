package com.caitiezhu.gaea.service.dao;

import com.caitiezhu.gaea.service.model.dto.bizline.CreateBizLineDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BizLineDAO {

    int insert(CreateBizLineDTO createBizLineDTO);
}
