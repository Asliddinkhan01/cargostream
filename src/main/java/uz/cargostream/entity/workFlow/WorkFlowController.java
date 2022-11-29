package uz.cargostream.entity.workFlow;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.cargostream.entity.workFlow.dto.AddWorkflowDto;
import uz.cargostream.entity.workFlow.dto.EditWorkflow;
import uz.cargostream.entity.workFlow.dto.WorkflowDto;

@RestController
@RequestMapping("/workflow")
@RequiredArgsConstructor
public class WorkFlowController {

    private final WorkFlowService workFlowService;

    @GetMapping("/get")
    public HttpEntity<?> getAllWorkflow() {
        return workFlowService.getAllWorkflow();
    }

    @PostMapping("/get")
    public HttpEntity<?> getWorkFlowById(@RequestBody WorkflowDto workflowDto) {
        return workFlowService.getWorkFlow(workflowDto.getWorkflowId());
    }

    @PostMapping("/add")
    public HttpEntity<?> addWorkFlow(@RequestBody AddWorkflowDto addWorkflowDto) {
        return workFlowService.addWorkFlow(addWorkflowDto);
    }

    @DeleteMapping("/delete")
    public HttpEntity<?> delete(@RequestBody WorkflowDto workflowDto) {
        return workFlowService.deleteById(workflowDto.getWorkflowId());
    }

    @PutMapping("/edit")
    public HttpEntity<?> editWorkFlow(@RequestBody EditWorkflow editWorkflow) {
        return workFlowService.editWorkFlow(editWorkflow.getWorkflowId(), editWorkflow);
    }
}
