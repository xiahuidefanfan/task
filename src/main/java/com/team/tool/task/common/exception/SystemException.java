package com.team.tool.task.common.exception;

import com.team.tool.task.common.enums.ErrorCodeEnum;
import com.team.tool.task.common.util.StringUtil;

/**
 * @ClassName: SystemException.java
 * @Description: 系统错误
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月15日 下午1:57:24 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月15日     xiahui           v1.0.0            系统错误
 */
public class SystemException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
    /**
     * 异常码
     */
    private int code;
    
    public SystemException(ErrorCodeEnum codeEnum, Object... args) {
        super(StringUtil.parseString(codeEnum.msg(), args));
        this.code = codeEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
