package uz.cargostream.entity.workFlow;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.cargostream.entity.workFlow.dto.AddWorkflowDto;
import uz.cargostream.entity.workFlow.dto.EditWorkflow;
import uz.cargostream.entity.workFlow.dto.WorkflowDto;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("${app.domain}/workflow")
@RequiredArgsConstructor
public class WorkFlowController {

    private final WorkFlowService workFlowService;

    @GetMapping
    public HttpEntity<?> getAllWorkflow() {
        return workFlowService.getAllWorkflow();
    }

    @PostMapping
    public HttpEntity<?> addWorkFlow(@Valid @RequestBody AddWorkflowDto addWorkflowDto) {
        return workFlowService.addWorkFlow(addWorkflowDto);
    }

    @DeleteMapping("/{uuid}")
    public HttpEntity<?> delete(@PathVariable UUID uuid) {
        return workFlowService.deleteById(uuid);
    }

    @PutMapping
    public HttpEntity<?> editWorkFlow(@Valid @RequestBody EditWorkflow editWorkflow) {
        return workFlowService.editWorkFlow(editWorkflow.getWorkflowId(), editWorkflow);
    }

    @GetMapping("/{workFlowId}")
    private HttpEntity<?> getWorkFlow(@PathVariable UUID workFlowId){
        return workFlowService.getWorkflowById(workFlowId);
    }
}
