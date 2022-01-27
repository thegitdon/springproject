package co.com.toject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.toject.model.PTest;

public interface PTestRepository extends JpaRepository<PTest, Integer> {

	// custom finder methods, estudiar;

	List<PTest> findByPublished(boolean x);

	List<PTest> findByEmailContaining(String x);

	// The implementation is plugged in by Spring Data JPA automatically.
}
