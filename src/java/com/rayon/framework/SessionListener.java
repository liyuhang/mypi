package com.rayon.framework;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:<br/>
 *
 * @author Rayon
 * @version 0.0.1
 * @date 2017/10/30
 * <p>
 * History:2017/10/30 Rayon 初始创建
 */
public class SessionListener implements HttpSessionListener{
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //清除缓存
        String sessionId=httpSessionEvent.getSession().getId();
        String name = PiCache.sessionToName.get(sessionId);
        PiCache.sessionToName.remove(sessionId);
        if(StringUtils.isNotBlank(name)){
            PiCache.nameToSession.remove(name);
        }

        //清除运行程序
        Map<String,ExecThread> execmap =PiCache.sessionToProcess.get(sessionId);
        if(execmap != null){
            Iterator<Map.Entry<String,ExecThread>> it=execmap.entrySet().iterator();
            while(it.hasNext()){
                it.next().getValue().stopExce();
            }
        }
        PiCache.sessionToProcess.remove(sessionId);
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }
}
