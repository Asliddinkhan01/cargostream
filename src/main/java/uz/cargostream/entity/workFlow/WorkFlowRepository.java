package uz.cargostream.entity.workFlow;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkFlowRepository extends JpaRepository<WorkFlow, UUID> {
}
