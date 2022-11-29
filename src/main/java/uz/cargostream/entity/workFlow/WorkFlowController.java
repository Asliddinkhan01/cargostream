package uz.cargostream.entity.workFlow;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class WorkFlowController {

    private final WorkFlowService workFlowService;

    @GetMapping("/{uuid}")
    public HttpEntity<?> getWorkFlowById(@PathVariable UUID uuid) {
        return workFlowService.getWorkFlow(uuid);
    }

    @PostMapping
    public HttpEntity<?> addWorkFlow(@RequestBody WorkFlow workFlow) {
        return workFlowService.addWorkFlow(workFlow);
    }

    @DeleteMapping("/{uuid}")
    public HttpEntity<?> delete(@PathVariable UUID uuid) {
        return workFlowService.deleteById(uuid);
    }

    @PutMapping("/{uuid}")
    public HttpEntity<?> editWorkFlow(@PathVariable UUID uuid, @RequestBody WorkFlow workFlow) {
        return workFlowService.editWorkFlow(uuid, workFlow);
    }
}
