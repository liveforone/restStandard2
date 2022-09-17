package restStandard2.restStandard2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import restStandard2.restStandard2.domain.Board;
import restStandard2.restStandard2.domain.Comment;
import restStandard2.restStandard2.dto.BoardDto;
import restStandard2.restStandard2.repository.BoardRepository;
import restStandard2.restStandard2.repository.CommentRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    //== 전체 게시글 + 페이징 ==//
    @Transactional(readOnly = true)
    public Page<Board> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    //== 전체 게시글 제목으로 검색 + 페이징 ==//
    @Transactional(readOnly = true)
    public Page<Board> getBoardListSearch(String keyword, Pageable pageable) {
        return boardRepository.findByTitleContaining(keyword, pageable);
    }

    //== 파일이 있는 게시글 저장 ==//
    @Transactional
    public void savePostWithFile(
            MultipartFile uploadFile,
            BoardDto boardDto,
            String writer
    ) throws IOException {
        UUID uuid = UUID.randomUUID();
        String saveFileName = uuid + "_" + uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File(saveFileName));

        boardDto.setWriter(writer);
        boardDto.setSaveFileName(saveFileName);
        boardRepository.save(boardDto.toEntity());
    }

    //== 파일없이 게시글 저장 ==//
    public void saveFileWithNoFile(BoardDto boardDto, String writer) {
        boardDto.setWriter(writer);
        boardRepository.save(boardDto.toEntity());
    }

    //== 게시글 상세조회 ==//
    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        return boardRepository.findOneById(id);
    }

    //== 좋아요 업데이트 ==//
    @Transactional
    public void updateGood(Long id) {
        boardRepository.updateGood(id);
    }

    //== 파일 있는 게시글 수정 ==//
    @Transactional
    public void editBoardWithFile(Long id, String saveFileName, BoardDto boardDto, String writer) {
        boardDto.setId(id);
        boardDto.setSaveFileName(saveFileName);
        boardDto.setWriter(writer);
        boardRepository.save(boardDto.toEntity());
    }

    //== 파일 없는 게시글 수정 ==//
    @Transactional
    public void editBoard(Long id, BoardDto boardDto, String writer) {
        boardDto.setId(id);
        boardDto.setWriter(writer);
        boardRepository.save(boardDto.toEntity());
    }

    //== 게시글 삭제 - 자식인 댓글도 모두 삭제 ==//
    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
        List<Comment> commentList = commentRepository.findByBoardId(id);
        for (Comment comment : commentList) {
            commentService.deleteComment(comment.getId());
        }
    }
}
