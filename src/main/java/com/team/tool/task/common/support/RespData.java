package com.team.tool.task.common.support;

/**
 * @ClassName: RespData.java
 * @Description: 请求返回封装
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月12日 下午5:43:54 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月12日     xiahui           v1.0.0             返回值封装
 */
public class RespData {
    
    private boolean success;
    
    private Object datas;

    private String message;
    
    // 分页时的记录总数
    private long totalCount;

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * dataCount：分页时使用，不分页时，该数值返回默认值0
     */
    public static RespData getRespData(boolean success ,Object datas, String message, long... dataCount){
        RespData respData = new RespData();
        respData.setSuccess(success);
        respData.setDatas(datas);
        if(dataCount.length > 0) {
            respData.setTotalCount(dataCount[0]);
        }
        respData.setMessage(message);
        return respData;
    }
}
