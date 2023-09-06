package postgre.create.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import postgre.create.domain.Board;
import postgre.create.domain.BoardDTO;
import postgre.create.domain.Page;
import postgre.create.repository.BoardRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void makeTest(){
        BoardDTO boardDTO1 = new BoardDTO("야호","야호","야호","1234","Korean");
        BoardDTO boardDTO2 = new BoardDTO("yaho","yaho","hoya","1234","English");
        BoardDTO boardDTO3 = new BoardDTO("タイトル","作成者","タイトル ","1234","Japanese");
        for (int i=0; i<10000; i++) {
            Random random = new Random();
            int ranInt = random.nextInt(1,4);
            switch (ranInt){
                case 1:
                    boardRepository.insert(boardDTO1);
                    break;
                case 2:
                    boardRepository.insert(boardDTO2);
                    break;
                case 3:
                    boardRepository.insert(boardDTO3);
                    break;
            }
        }
    }
}
