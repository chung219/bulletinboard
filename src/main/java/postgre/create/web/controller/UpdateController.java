package postgre.create.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import postgre.create.domain.Board;
import postgre.create.domain.BoardDTO;
import postgre.create.repository.BoardRepository;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UpdateController {
    private final BoardRepository boardRepository;

    @GetMapping("/qna/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        Board readId  =boardRepository.selectedBoard(id);
        model.addAttribute("board", readId);
        log.info("리딩"+readId);
        return "bulletin_update";
    }

    @PostMapping("/qna/update/{id}")
    public String update(@PathVariable Long id, BoardDTO writeDTO, Model model){
        log.info("업데이트 로그 확인"+writeDTO);
        Board updateId = boardRepository.selectedBoard(id);
        if (writeDTO.getPassword().equals(updateId.getPassword())){
            boardRepository.update(writeDTO, id);
        } else {
            model.addAttribute("board", updateId);
            model.addAttribute("error","에러발생");
            return "bulletin_update";
        }

        return "redirect:/qna/read/{id}";
    }
}
