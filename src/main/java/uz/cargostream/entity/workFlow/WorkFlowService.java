package uz.cargostream.entity.workFlow;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.cargostream.common.ApiResponse;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkFlowService {

    private final WorkFlowRepository workFlowRepository;


    public HttpEntity<?> getWorkFlow(UUID uuid) {
        Optional<WorkFlow> byId = workFlowRepository.findById(uuid);
        if (byId.isPresent()) {
            return new ResponseEntity<>(new ApiResponse("Successfully", true, byId), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("WorkFlow not found", true), HttpStatus.OK);
    }

    public HttpEntity<?> addWorkFlow(WorkFlow workFlow) {
        WorkFlow newWorkFlow = new WorkFlow();
        newWorkFlow.setOrderNumber(workFlow.getOrderNumber());
        newWorkFlow.setTitle(workFlow.getTitle());
        newWorkFlow.setDescription(workFlow.getDescription());
        workFlowRepository.save(newWorkFlow);
        return new ResponseEntity<>(new ApiResponse("Successfully added", true, newWorkFlow), HttpStatus.CREATED);
    }

    public HttpEntity<?> editWorkFlow(UUID id, WorkFlow workFlow) {
        Optional<WorkFlow> byId = workFlowRepository.findById(id);
        if (byId.isPresent()) {
            WorkFlow editWorkFlow = new WorkFlow();
            editWorkFlow.setOrderNumber(workFlow.getOrderNumber());
            editWorkFlow.setTitle(workFlow.getTitle());
            editWorkFlow.setDescription(workFlow.getDescription());
            WorkFlow save = workFlowRepository.save(editWorkFlow);
            return new ResponseEntity<>(new ApiResponse("Successfully edited", true, save), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("Error", false), HttpStatus.OK);
    }

    public HttpEntity<?> deleteById(UUID uuid) {
        try {
            workFlowRepository.deleteById(uuid);
            return new ResponseEntity<>(new ApiResponse("Successfully deleted", true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Error", false), HttpStatus.NOT_FOUND);
        }
    }


}
