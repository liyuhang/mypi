package com.rayon.pi.domain;

/**
 * Description:<br/>
 *
 * @author Rayon
 * @version 0.0.1
 * @date 2017/10/30
 * <p>
 * History:2017/10/30 Rayon 初始创建
 */
public enum  AppConstant {

    LOGIN_FAIL("code","7000","登录失败"),
    LOGIN_SUCCESS("code","6000","登录成功"),
    AJAX_FAIL("code","7000","执行失败"),
    AJAX_SUCCESS("code","6000","执行成功");

    public String name;
    public String value;
    public String desc;

    AppConstant(String name, String code, String desc) {
        this.name = name;
        this.value = code;
        this.desc = desc;
    }
}
