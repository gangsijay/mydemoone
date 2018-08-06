package com.two.oauthserver.security.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 功能描述: 用户
 *
 * @author: 田杰
 * @create: 2018-05-14 10:33
 **/
public class ArtAuthUser  implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
    private String password;

    public ArtAuthUser() {

    }

    public ArtAuthUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        roleList.stream().forEach(role-> authorityList.add(new SimpleGrantedAuthority(StringUtils.upperCase(role.getCode()))));
//        authorityList.add(new SimpleGrantedAuthority(SecurityConstants.BASE_ROLE));
//        return authorityList;
//    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
