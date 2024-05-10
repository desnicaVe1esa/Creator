package app.back.repository;

import app.back.entity.HomePractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomePracticeRepository extends JpaRepository<HomePractice, Long> {
}
