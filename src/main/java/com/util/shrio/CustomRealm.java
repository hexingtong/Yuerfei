package com.util.shrio;

import com.springmvc.pojo.ActiveUser;
import com.springmvc.pojo.kn_admin;
import com.springmvc.service.impl.kn_adminserviceimpl;
import com.springmvc.service.kn_adminservice;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CustomRealm
 * @Description:配置自定义的Realm，重写认证的方法
 * @Author by
 * @Date: 2019/3/1 17:30
 **/
@Service
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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException,UnknownAccountException {
        if (token == null|| StringUtils.isBlank((String) token.getPrincipal())) {
            throw new UnknownAccountException();
        }
        logger.info("token.getPrincipal()"+token.getPrincipal());
        //根据token中的用户名查库，获得user对象
        kn_admin user = sysService.queryByPhone(((String) token.getPrincipal()));
        if (user != null) {
            SecurityUtils.getSubject().getSession().setAttribute("user", user);//把当前用户存到session中
            logger.info("user.getPhone()"+user.getPhone()+"user.getPwd()"+user.getPwd()+"ByteSource.Util.bytes(user.getPhone())"+ByteSource.Util.bytes(user.getPhone()));
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getPhone(), user.getPwd(), ByteSource.Util.bytes(user.getPhone()), this.getName());

            return simpleAuthenticationInfo;
        }else {
            throw new UnknownAccountException();
        }
        //SimpleAuthenticationInfo代表该用户的认证信息，其实就是数据库中的用户名、密码、加密密码使用的盐
        //存在数据库中的密码是对用户真是密码通过md5加盐加密得到的，保证安全，及时数据泄露，也得不到真正的用户密码
        //getName()返回该realm的名字，代表该认证信息的来源是该realm，作用不大，一般都是单realm
        //该方法返回后，上层会对token和SimpleAuthenticationInfo进行比较，首先比较Principal()，然后将token的Credentials
        //进行md5加上SimpleAuthenticationInfo中的盐加密，加密结果和SimpleAuthenticationInfo的Credentials比较


//        if (user == null) {
//            return null;
//        }
//
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
//        String username = usernamePasswordToken.getUsername();
//
//
//        kn_admin knAdmin=null;
//        String password=null;
//        try {
//            knAdmin = sysService.queryByPhone(username);
//        } catch (Exception e1) {
//            logger.info("用户不存在！");
//            e1.printStackTrace();
//        }
//        // 如果查询不到返回null
//        if(knAdmin.getPwd()==null){
//            logger.info("差寻不到phone"+knAdmin.getPwd());
//
//            return null;
//        }else {
//             password = knAdmin.getPwd();
//        }


    }
}
