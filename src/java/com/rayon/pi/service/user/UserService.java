package com.rayon.pi.service.user;

import com.rayon.framework.ExecThread;
import com.rayon.framework.PiCache;
import com.rayon.pi.domain.AppConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

/**
 * Description:<br/>
 *
 * @author Rayon
 * @version 0.0.1
 * @date 2017/10/30
 * <p>
 * History:2017/10/30 Rayon 初始创建
 */
@Service("userService")
public class UserService {
    @Value("${user}")
    String userName;
    @Value("${pswd}")
    String password;

    public boolean loginexec(String user,String pswd,String sessionid){
        if(user.equals(userName) && pswd.equals(password)) {
            PiCache.nameToSession.put("rayon",sessionid);
            PiCache.sessionToName.put(sessionid,"rayon");
            PiCache.sessionToProcess.put(sessionid,new HashMap<String,ExecThread>());
           return true;
        }else{
           return false;
        }
    }

}
