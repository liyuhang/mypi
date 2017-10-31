package com.rayon.framework;

/**
 * Description:<br/>
 *
 * @author Rayon
 * @version 0.0.1
 * @date 2017/10/30
 * <p>
 * History:2017/10/30 Rayon 初始创建
 */
public class ExecUtils {
    public static boolean startExecUtils(String sessionid,String exeName,String cmd){
        ExecThread thread = new ExecThread(cmd);
        if(PiCache.sessionToProcess.get(sessionid).get(sessionid) != null){
            return false;
        }
        PiCache.sessionToProcess.get(sessionid).put(exeName,thread);
        return true;
    }
}
