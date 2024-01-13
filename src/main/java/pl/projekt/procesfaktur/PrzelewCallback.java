package pl.projekt.procesfaktur;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PrzelewCallback implements JavaDelegate{
	public void execute(DelegateExecution execution) throws Exception {
		RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
		runtimeService.createMessageCorrelation("potwierdzeniePrzelewuMsg")
				.processInstanceId(execution.getVariable("parentBussinesKey").toString())
				.setVariable("czyPrzelano", execution.getVariable("czyPrzelano"))
				.correlateWithResult();
	}
}
