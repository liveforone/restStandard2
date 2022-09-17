package restStandard2.restStandard2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restStandard2.restStandard2.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBoardId(Long boardId);
}
