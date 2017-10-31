package com.rayon.pi.service.operation;

import org.springframework.stereotype.Service;

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
@Service("driffnetService")
public class DriffnetService {

    private final static String exeName = "driffnet";

    public boolean startDriffnet(Map<String,String> params){

        return true;
    }
}
