package co.com.toject.x;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.toject.model.PTest;

public interface IPTestRepo extends JpaRepository<PTest, Integer> {

}
