package com.rayon.pi.controller.operation;

import com.rayon.pi.domain.AppConstant;
import com.rayon.pi.domain.BackResult;
import com.rayon.pi.service.operation.EtterCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
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
@Controller
public class EtterCapController {

    @Autowired
    EtterCapService etterCapService;


    //model 1:arp_spoof 2:arp_spoof and catch password 3:dns_spoof and inject js

    @RequestMapping(value="ettercap/start")
    @ResponseBody
    public BackResult<Object> startEtterCap(HttpServletRequest request , HttpServletResponse response){
        BackResult<Object> backResult = new BackResult<>();
        String model = request.getParameter("model");
        String jsText="";
        if(model.equals("3")) {
            jsText = new String(Base64.getDecoder().decode(request.getParameter("jsText")));
        }

        Map<String,String> params = new HashMap<>();
        params.put("model",model);
        params.put("jsText",jsText);
        if(etterCapService.startEtterCap(params)){
            backResult.setCode(AppConstant.AJAX_SUCCESS.value);
            backResult.setDesc(AppConstant.LOGIN_SUCCESS.desc);
        }
        else {
            backResult.setCode(AppConstant.AJAX_FAIL.value);
            backResult.setDesc(AppConstant.AJAX_FAIL.desc);
        }
        return backResult;

    }
}
