package postgre.create.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import postgre.create.domain.BoardDTO;
import postgre.create.repository.BoardRepository;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CreateController {
    private final BoardRepository boardRepository;

    @GetMapping("/qna/write")
    public String createForm(){
        return "bulletin_write";
    }

    @PostMapping("/qna/write")
    public String createQnA(@ModelAttribute BoardDTO writeDTO){
        log.info("dto 확인"+writeDTO);
        try {
            boardRepository.insert(writeDTO);
        } catch (Exception e){
            e.getMessage();
            return "bulletin_write";
        }
        return "redirect:/";
    }
}
