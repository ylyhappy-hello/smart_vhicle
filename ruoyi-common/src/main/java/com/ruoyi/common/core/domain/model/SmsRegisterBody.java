package com.ruoyi.common.core.domain.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册对象
 *
 * @author Lion Li
 */
@Data
public class SmsRegisterBody {
    /**
     * 手机号
     */
    @NotBlank(message = "{user.phonenumber.not.blank}")
    private String phonenumber;

    /**
     * 用户密码
     */
    @NotBlank(message = "{sms.code.not.blank}")
    private String smsCode;
}
