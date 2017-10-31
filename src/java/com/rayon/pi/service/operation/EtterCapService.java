package com.rayon.pi.service.operation;

import com.rayon.pi.domain.BackResult;
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
@Service("etterCapService")
public class EtterCapService {

    private String model_1_cmd="";
    private String model_2_cmd="";
    private String model_3_cmd="";

    private final static String exeName = "ettercap";

    public boolean startEtterCap(Map params){
        String model = (String)params.get("model");
        String jsText = (String)params.get("jsText");

        return true;
    }

}
