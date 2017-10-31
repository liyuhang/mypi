package com.rayon.pi.controller.operation;

import com.rayon.pi.domain.BackResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class DriffnetController {

    @RequestMapping(value="driffnet/start")
    public BackResult<Object> startDriffnet(HttpServletRequest request, HttpServletResponse response){
        BackResult<Object> backResult = new BackResult<>();

        return backResult;
    }
}
