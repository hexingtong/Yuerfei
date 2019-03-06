package com.util.shrio;

import com.springmvc.pojo.ActiveUser;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.impl.kn_adminserviceimpl;
import com.springmvc.service.kn_adminservice;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName CustomRealm
 * @Description:配置自定义的Realm，重写认证的方法
 * @Author by
 * @Date: 2019/3/1 17:30
 **/
public class CustomRealm extends AuthorizingRealm {
    final Logger logger = LoggerFactory.getLogger(CustomRealm.class);
    //注入service
    @Autowired
    private kn_adminservice sysService;
    // 设置realm的名称
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

// token是用户输入的用户名和密码
        // 第一步从token中取出用户名
//        String userCode = (String) token.getPrincipal();
//
//        // 第二步：根据用户输入的userCode从数据库查询用户信息
//        kn_admin knAdmin;
//        try {
//
//            knAdmin = sysService.
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//        // 如果查询不到返回null
//        if(sysUser==null){
//            return null;
//        }
//
//        // 从数据库查询到密码
//        String password = sysUser.getPassword();
//        //盐
//        String salt = sysUser.getSalt();
//
//        // 如果查询到,返回认证信息AuthenticationInfo
//        //activeUser就是用户身份信息
//
//        ActiveUser activeUser = new ActiveUser();
//        activeUser.setRoleId(sysUser.getId());
//        activeUser.setAccount(sysUser.getUsercode());
//        activeUser.setRoleName(sysUser.getUsername());
//        //..
//
//        //根据用户id取出菜单
//        List<SysPermission> menus  = null;
//        try {
//            //通过service取出菜单
//            menus = sysService.findMenuListByUserId(sysUser.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //将用户菜单,设置到activeUser
//        activeUser.setMenus(menus);

        //将activeUser设置simpleAuthenticationInfo

//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(

        String username = (String) token.getPrincipal();

        kn_admin knAdmin=null;
        String password=null;
        try {

            knAdmin = sysService.queryByPhone(username);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // 如果查询不到返回null
        if(knAdmin.getPwd()==null){
            logger.info("差寻不到phone"+knAdmin.getPwd());

            return null;
        }else {
             password = knAdmin.getPwd();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());

        return simpleAuthenticationInfo;

    }
}
