package postgre.create.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import postgre.create.repository.BoardMapper;
import postgre.create.repository.BoardRepository;
import postgre.create.service.BoardService;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final BoardMapper boardMapper;

    /* 매퍼와 레파지토리 연결용 빈 생성 */
    @Bean
    public BoardRepository boardRepository() {
        return new BoardRepository(boardMapper);
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }
}
