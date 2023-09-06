package postgre.create.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import postgre.create.domain.Board;
import postgre.create.domain.ViewCountDTO;
import postgre.create.repository.BoardRepository;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ReadController {
    private final BoardRepository boardRepository;

    @GetMapping("/qna/read/{id}")
    public String readForm(@PathVariable Long id, Model model){
        Board readId  =boardRepository.selectedBoard(id);
        ViewCountDTO viewCountDTO = new ViewCountDTO(readId.getViewCount()+1);
        boardRepository.viewCountUpdate(viewCountDTO, id);
        readId = boardRepository.selectedBoard(id);
        model.addAttribute("board", readId);
        log.info("리딩"+readId);
        return "bulletin_read";
    }
}
