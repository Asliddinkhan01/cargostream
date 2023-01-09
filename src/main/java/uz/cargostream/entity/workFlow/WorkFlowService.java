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
        newWorkFlow.setTitle_ru(workFlow.getTitle_ru());
        newWorkFlow.setDescription_ru(workFlow.getDescription_ru());
        newWorkFlow.setTitle_en(workFlow.getTitle_en());
        newWorkFlow.setDescription_en(workFlow.getDescription_en());
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
            editWorkFlow.setTitle_ru(workFlow.getTitle_ru());
            editWorkFlow.setDescription_ru(workFlow.getDescription_ru());
            editWorkFlow.setTitle_en(workFlow.getTitle_en());
            editWorkFlow.setDescription_en(workFlow.getDescription_en());
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

    public HttpEntity<?> getWorkflowById(UUID workFlowId) {
        Optional<WorkFlow> byId = workFlowRepository.findById(workFlowId);
        if (byId.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Error", false), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ApiResponse("Success", true, byId), HttpStatus.OK);
    }
}
