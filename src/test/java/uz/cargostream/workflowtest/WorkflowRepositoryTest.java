package uz.cargostream.workflowtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uz.cargostream.entity.workFlow.WorkFlowRepository;

@DataJpaTest
public class WorkflowRepositoryTest {

    @Autowired
    private WorkFlowRepository workFlowRepository;


}
