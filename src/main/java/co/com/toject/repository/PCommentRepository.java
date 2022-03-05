package co.com.toject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.toject.model.PComment;

public interface PCommentRepository extends JpaRepository<PComment, Integer> { // without implementing

	List<PComment> findByTutorialId(int x); // returns all Comments of a Tutorial specified by tutorialId

	@Transactional
	void deleteByTutorialId(int x); // deletes all Comments of a Tutorial specified by tutorialId

}
