package uz.cargostream.entity.workFlow;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.workFlow.dto.AddWorkflowDto;
import uz.cargostream.entity.workFlow.dto.EditWorkflow;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkFlowService {

    private final WorkFlowRepository workFlowRepository;

    public HttpEntity<?> addWorkFlow(AddWorkflowDto workFlow) {
        WorkFlow newWorkFlow = new WorkFlow();
        newWorkFlow.setOrderNumber(workFlow.getOrderNumber());
        newWorkFlow.setTitle(workFlow.getTitle());
        newWorkFlow.setDescription(workFlow.getDescription());
        try {
            workFlowRepository.save(newWorkFlow);
            return new ResponseEntity<>(new ApiResponse("Successfully added", true, newWorkFlow), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }

    public HttpEntity<?> editWorkFlow(UUID id, EditWorkflow workFlow) {
        Optional<WorkFlow> byId = workFlowRepository.findById(id);
        if (byId.isPresent()) {
            WorkFlow editWorkFlow = byId.get();
            editWorkFlow.setOrderNumber(workFlow.getOrderNumber());
            editWorkFlow.setTitle(workFlow.getTitle());
            editWorkFlow.setDescription(workFlow.getDescription());
            try {
                workFlowRepository.save(editWorkFlow);
                return new ResponseEntity<>(new ApiResponse("Successfully edited", true), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(new ApiResponse("Workflow not found", false), HttpStatus.NOT_FOUND);
    }

    public HttpEntity<?> deleteById(UUID uuid) {
        try {
            workFlowRepository.deleteById(uuid);
            return new ResponseEntity<>(new ApiResponse("Successfully deleted", true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Workflow not found", false), HttpStatus.NOT_FOUND);
        }
    }


    public HttpEntity<?> getAllWorkflow() {
        List<WorkFlow> all = workFlowRepository.findAll();
        return new ResponseEntity<>(new ApiResponse("Success", true, all), HttpStatus.OK);
    }
}
