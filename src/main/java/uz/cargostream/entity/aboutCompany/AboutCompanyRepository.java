package uz.cargostream.entity.aboutCompany;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AboutCompanyRepository extends JpaRepository<AboutCompany, UUID> {
}
