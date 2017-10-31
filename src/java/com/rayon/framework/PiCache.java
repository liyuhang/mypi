package com.rayon.framework;

import java.util.HashMap;
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
public class PiCache {
    //session to name
    public static  Map<String,String> sessionToName = new HashMap<String,String>();
    //name to session
    public static  Map<String,String> nameToSession = new HashMap<String,String>();

    //session to cmd
    public static Map<String,Map<String,ExecThread>> sessionToProcess= new HashMap<String,Map<String,ExecThread>>();

}
