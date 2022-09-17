package restStandard2.restStandard2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restStandard2.restStandard2.domain.Comment;
import restStandard2.restStandard2.dto.CommentDto;
import restStandard2.restStandard2.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //== 전체 댓글 ==//
    @Transactional(readOnly = true)
    public List<Comment> getCommentList(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    //== 댓글 저장 ==//
    @Transactional
    public void saveComment(Long id, CommentDto commentDto, String user) {
        commentDto.setBoardId(id);
        commentDto.setUser(user);
        commentRepository.save(commentDto.toEntity());
    }

    //== 댓글 삭제 - 게시글 삭제시 사용됨 ==//
    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
