package com.team.tool.task.service.workflow.impl;

import java.util.List;
import java.util.Map;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.tool.task.service.workflow.WorkflowService;

/**
 * @ClassName: WorkFlowServiceImpl.java
 * @Description: 工作流实现类
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年12月13日 下午3:07:18 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年12月13日     xiahui           v1.0.0           工作流实现类
 */
@Service
public class WorkflowServiceImpl implements WorkflowService{

    @Autowired
    private ProcessEngine processEngine;
    
    @Override
    public void deploy(String processFilePath ,String deployName) {
    	processEngine.getRepositoryService().createDeployment().name(deployName).addClasspathResource(processFilePath).deploy();
	}
    
    @Override
    public ProcessInstance startProcessInstance(String processDefinitionKey, String businessKey, 
            Map<String, Object> variables) {
        return processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
    }
    
    @Override
    public ProcessInstance queryProcessInstance(String processInstanceId){
        return processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
    }
    
    @Override
    public void deleteProcessInstance(String processInstanceId, String message) {
    	processEngine.getRuntimeService().deleteProcessInstance(processInstanceId, message);
    }
    
    @Override
    public Execution queryRunTimeExecutionById(String executionId){
        return processEngine.getRuntimeService().createExecutionQuery().executionId(executionId).singleResult();
    }
    
    @Override
    public List<Execution> queryRunTimeExecutionByProcId(String processInstanceId){
        return processEngine.getRuntimeService().createExecutionQuery().processInstanceId(processInstanceId).list();
    }
    
    @Override
    public List<HistoricTaskInstance> queryHistoryTask(String taskKey){
        return processEngine.getHistoryService().createHistoricTaskInstanceQuery().taskDefinitionKey(taskKey).desc().list();
    }
    
    @Override
    public Object getVariable(String executionId, String key) {
        return processEngine.getRuntimeService().getVariable(executionId, key);
    }
    
    @Override
    public void setVariables(String executionId,  Map<String, Object> variables) {
    	processEngine.getRuntimeService().setVariables(executionId, variables);
    }
    
    @Override
    public List<Task> queryTaskByProcessInstanceId(String processInstanceId) {
       return processEngine.getTaskService().createTaskQuery().processInstanceId(processInstanceId).list();
    }
    
    @Override
    public Task querySingleTaskByProcessInstanceId(String processInstanceId) {
       return processEngine.getTaskService().createTaskQuery().processInstanceId(processInstanceId).singleResult();
    }
    
    @Override
    public List<Task> getTaskListByUserId(String userId){
        return processEngine.getTaskService().createTaskQuery().taskAssignee(userId).list();
    }
    
    @Override
    public Task getTaskByTaskId(String taskId){
        return processEngine.getTaskService().createTaskQuery().taskId(taskId).singleResult();
    }
    
    @Override
    public List<String> getActiveActivityIds(String executionId){
        return processEngine.getRuntimeService().getActiveActivityIds(executionId);   
    }
    
    @Override
    public ProcessEngineConfiguration getProcessEngineConfiguration() {
        return processEngine.getProcessEngineConfiguration();
    }
    
    @Override
    public BpmnModel getBpmnModel(String processInstanceId) {
       return processEngine.getRepositoryService().getBpmnModel(processInstanceId);
    }
    
    @Override
    public void complete(String taskId, Map<String, Object> variables) {
    	processEngine.getTaskService().complete(taskId, variables);
    }
    
    @Override
    public void complete(String taskId, Map<String, Object> variables, boolean localScope) {
    	processEngine.getTaskService().complete(taskId, variables, localScope);
    }
    
}
