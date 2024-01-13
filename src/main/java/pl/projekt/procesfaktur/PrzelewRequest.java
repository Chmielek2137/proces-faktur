package pl.projekt.procesfaktur;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PrzelewRequest implements JavaDelegate{
	public void execute(DelegateExecution execution) throws Exception {
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		Map<String, Object> processVariables = new HashMap<String, Object>();
		processVariables.put("parentBussinesKey", execution.getProcessInstanceId());
		processVariables.put("kontrahent", execution.getVariable("kontrahent"));
		processVariables.put("kBrutto", execution.getVariable("kBrutto"));
		runtimeService.startProcessInstanceByMessage("przelewMsg", processVariables);
	}
}
