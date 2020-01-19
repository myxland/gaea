package com.caitiezhu.gaea.service.model.vo;

import com.caitiezhu.gaea.service.model.po.User;
import lombok.Data;

@Data
public class UserVO {
    private Long id;
    private String email;
    private String username;
    private String nameZh;
    private String aboutMe;

    public UserVO toVO(User user) {
        UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setEmail(user.getEmail());
        vo.setUsername(user.getUsername());
        vo.setNameZh(user.getNameZh());
        vo.setAboutMe(user.getAboutMe());
        return vo;
    }
}
