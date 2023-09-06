package postgre.create.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import postgre.create.domain.Board;
import postgre.create.domain.BoardDTO;
import postgre.create.domain.Page;
import postgre.create.domain.ViewCountDTO;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    /* 전체 검색 */
    List<Board> findAll();

    /* 전체 검색 페이징 처리*/
    List<Board> findAllWithPaging(@Param("page") Page page);

    /* 새로 삽입 */
    void insert(@Param("writeDTO") BoardDTO writeDTO);

    /* 업데이트 */
    void update(@Param("updateDTO") BoardDTO updateDTO, @Param("id") Long id);

    void viewCountUpdate(@Param("viewCount")ViewCountDTO viewCountDTO, @Param("id") Long id);

    /* 삭제 */

    void delete(Long id);


    /* index로 검색*/
    Board selectedBoard(Long id);




    /* 언어별 검색 */
    List<Board> findByLanguage(String language);
    List<Board> findByLanguageWithPaging(@Param("language") String language, @Param("page") Page page);

    /* 제목으로 검색 */
    List<Board> findByTitle(String searchContent);
    List<Board> findByTitleWithPaging(@Param("searchContent") String searchContent, @Param("page") Page page);

    /* 제목+본문 검색 */
    List<Board> findByTitleContent(String searchContent);
    List<Board> findByTitleContentWithPaging(@Param("searchContent") String searchContent, @Param("page") Page page);

    /* 글쓴이로 검색 */
    List<Board> findByWriter(String writer);
    List<Board> findByWriterWithPaging(@Param("searchContent") String searchContent, @Param("page") Page page);

}
