package com.two.lgums.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.two.core.exception.DaoException;
import com.two.lgums.dao.SysUserDAO;
import com.two.lgums.dao.entity.SysUserDO;

/**
 * Created by Tjee on 2018/4/4.
 */
@Component
public class ArtUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserDAO sysUserDAO;

//    @Autowired
//    SysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("用户:[{}]开始登陆认证", username);
        SysUserDO userDO = null;
//        try {
//            userDO = sysUserDAO.getSysUserByLoginName(username);
//        } catch (DaoException e) {
//            throw new UsernameNotFoundException("用户登陆失败", e);
//        }
//        if (Objects.isNull(userBO)) {
//            throw new UsernameNotFoundException(BizErrorCode.BIZ_AUTH_NO_USER.describe,
//                    BizException.wrap(BizErrorCode.BIZ_AUTH_NO_USER));
//        }
//        List<SysRoleBO> roles = new ArrayList<>();//sysRoleService.getRoleByUserId(userBO.getId());
//        userDO.setRoleList(roles);
       // passwordEncoder.setSalt(username);
        return new ArtAuthUser(username, new BCryptPasswordEncoder().encode("123456"));
    }
}
