package postgre.create.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import postgre.create.domain.Board;
import postgre.create.domain.BoardDTO;
import postgre.create.domain.Page;
import postgre.create.domain.ViewCountDTO;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepository{
    private final BoardMapper boardMapper;

    public List<Board> findAll(){
        return boardMapper.findAll();
    }

    public List<Board> findAllWithPaging(Page page){
        return boardMapper.findAllWithPaging(page);
    }

    /* 새로 삽입 */
    public void insert(BoardDTO writeDTO){
        boardMapper.insert(writeDTO);
    }

    /* 업데이트 */
    public void update(BoardDTO updateDTO, Long id){
        boardMapper.update(updateDTO, id);
    }
    public void viewCountUpdate(ViewCountDTO viewCountDTO, Long id) {
        boardMapper.viewCountUpdate(viewCountDTO, id);
    }

    /* 삭제 */
    public void delete(Long id) {
        boardMapper.delete(id);
    }

    /* index로 검색*/
    public Board selectedBoard(Long id){
        return boardMapper.selectedBoard(id);
    }


    /* 언어별 검색 */
    public List<Board> findByLanguage(String language){
        return boardMapper.findByLanguage(language);
    }
    public List<Board> findByLanguageWithPaging(String language, Page page){
        return boardMapper.findByLanguageWithPaging(language, page);
    }


    /* 제목으로 검색 */
    public List<Board> findByTitle(String searchContent){
        return boardMapper.findByTitle(searchContent);
    }
    public List<Board> findByTitleWithPaging(String searchContent, Page page){
        return boardMapper.findByTitleWithPaging(searchContent, page);
    }


    /* 제목+본문 검색 */
    public List<Board> findByTitleContent(String searchContent){
        return boardMapper.findByTitleContent(searchContent);
    }
    public List<Board> findByTitleContentWithPaging(String searchContent, Page page){
        return boardMapper.findByTitleContentWithPaging(searchContent, page);
    }

    /* 글쓴이로 검색 */
    public List<Board> findByWriter(String writer){
        return boardMapper.findByWriter(writer);
    }
    public List<Board> findByWriterWithPaging(String searchContent, Page page){
        return boardMapper.findByWriterWithPaging(searchContent, page);
    }
}
