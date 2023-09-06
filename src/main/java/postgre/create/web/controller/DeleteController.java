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
public class DeleteController {
    private final BoardRepository boardRepository;

    @GetMapping("/qna/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model){
        Board readId  =boardRepository.selectedBoard(id);
        model.addAttribute("board", readId);
        log.info("리딩"+readId);
        return "bulletin_delete";
    }

    @PostMapping("/qna/delete/{id}")
    public String delete(@PathVariable Long id, BoardDTO writeDTO, Model model){
        log.info("업데이트 로그 확인"+writeDTO);
        Board deleteId = boardRepository.selectedBoard(id);
        if (writeDTO.getPassword().equals(deleteId.getPassword())){
            boardRepository.delete(id);
        } else {
            model.addAttribute("board", deleteId);
            model.addAttribute("error","에러발생");
            return "bulletin_delete";
        }

        return "redirect:/qna";
    }
}
