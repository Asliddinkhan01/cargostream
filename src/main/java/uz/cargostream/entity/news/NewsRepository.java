package uz.cargostream.entity.news;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface NewsRepository extends JpaRepository<News, UUID> {

}
