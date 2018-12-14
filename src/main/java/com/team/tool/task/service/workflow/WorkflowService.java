package com.team.tool.task.service.workflow;

import java.util.List;
import java.util.Map;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;

/**
 * @ClassName: WorkFlowService.java
 * @Description: 工作流service
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月13日 下午3:05:36 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月13日     xiahui           v1.0.0          工作流service
 */
public interface WorkflowService {
    
	/**
	 * 部署流程实例
	 */
	void deploy(String processFilePath ,String deployName);
	
    /**
     * 启动流程实例，根据processDefinitionKey和businessKey，variables可选
     */
    ProcessInstance startProcessInstance(String processDefinitionKey, String businessKey, Map<String, Object> variables);

    /**
     * 根据processInstanceId查询流程实例
     */
    ProcessInstance queryProcessInstance(String processInstanceId);
    
    /**
     * 删除流程实例,根据processInstanceId，message为删除原因
     */
    void deleteProcessInstance(String processInstanceId, String message);
    
    /**
     * 根据id获取运行时流程实例
     */
    Execution queryRunTimeExecutionById(String executionId);
    
    /**
     * 根据流程实例id获取流程实例
     */
    List<Execution> queryRunTimeExecutionByProcId(String processInstanceId);
    
    /**
     * 根据taskId查询task
     */
    List<Task> queryTaskByProcessInstanceId(String processInstanceId);
    
    /**
     * 根据taskId查询单个task
     */
    Task querySingleTaskByProcessInstanceId(String processInstanceId);
    
    /**
     * 获取处理人的任务集合
     */
    List<Task> getTaskListByUserId(String userId);
    
    /**
     * 根据taskId获取任务
     */
    Task getTaskByTaskId(String taskId);
    
    /**
     * 获取历史任务
     */
    List<HistoricTaskInstance> queryHistoryTask(String taskKey);
    
    /**
     * 获取活动节点
     */
    List<String> getActiveActivityIds(String executionId);
    
    /**
     * 获取ProcessEngineConfigurationo 
     */
    ProcessEngineConfiguration getProcessEngineConfiguration();
    
    /**
     * 根据流程实例id获取BpmnModel
     */
    BpmnModel getBpmnModel(String processInstanceId);
    
    /**
     * 完成任务
     */
    void complete(String taskId, Map<String, Object> variables);
    
    /**
     * 完成任务
     */
    void complete(String taskId, Map<String, Object> variables, boolean localScope);
    
    /**
     * 根据运行时流程执行实例id获取变量值
     */
    Object getVariable(String executionId, String key);
    
    /**
     * 根据运行时流程执行实例id设置变量
     */
    void setVariables(String executionId,  Map<String, Object> variables);
    
}
