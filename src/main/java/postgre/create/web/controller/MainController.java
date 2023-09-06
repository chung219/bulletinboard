package postgre.create.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import postgre.create.domain.Board;
import postgre.create.domain.Page;
import postgre.create.domain.PageDTO;
import postgre.create.repository.BoardRepository;
import postgre.create.service.BoardService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/")
    public String returnHome(){
       return "redirect:/qna";
   }

    @GetMapping("/qna")
    public String getQnA(Page page, Model model){
        List<Board> allList = boardRepository.findAll();
        int listSize = allList.size();
        List<Board> pagingList = boardRepository.findAllWithPaging(page);

        model.addAttribute("pageMaker", new PageDTO(page, listSize));
        model.addAttribute("board",pagingList);
        return "bulletin";
    }

    @PostMapping("/qna/search")
    public String search(@RequestParam("searchSelect") String select, @RequestParam("searchText") String text,
                         Page page, Model model){
        int size;
        List<Board> pagingResult = new ArrayList<>();
        if (select.equals("title")) {
            List<Board> searchResult = boardRepository.findByTitle(text);
            size = searchResult.size();
            pagingResult = boardRepository.findByTitleWithPaging(text, page);
        } else if (select.equals("writer")) {
            List<Board> searchResult = boardRepository.findByWriter(text);
            size = searchResult.size();
            pagingResult = boardRepository.findByWriterWithPaging(text, page);
        } else {
            List<Board> searchResult = boardRepository.findByTitleContent(text);
            size = searchResult.size();
            pagingResult = boardRepository.findByTitleContentWithPaging(text, page);
        }

        model.addAttribute("pageMaker", new PageDTO(page, size));
        model.addAttribute("board", pagingResult);
        log.info("셀렉트"+select);
        log.info("입력"+text);
        return "bulletin";
    }


    @GetMapping("/qna/kor")
    public String koreaList(Page page, Model model){
        List<Board> koreaList = boardRepository.findByLanguage("Korean");
        int koreaSize = koreaList.size();
        List<Board> pagingKorea = boardRepository.findByLanguageWithPaging("Korean", page);
        model.addAttribute("pageMaker", new PageDTO(page, koreaSize));
        model.addAttribute("board", pagingKorea);
        return "bulletin_kor";
    }

    @GetMapping("/qna/eng")
    public String englishList(Page page, Model model){
        List<Board> englishList = boardRepository.findByLanguage("English");
        int englishSize = englishList.size();
        List<Board> pagingEnglish = boardRepository.findByLanguageWithPaging("English", page);
        model.addAttribute("pageMaker", new PageDTO(page, englishSize));
        model.addAttribute("board", pagingEnglish);
        return "bulletin_eng";
    }

    @GetMapping("/qna/jap")
    public String japanList(Page page, Model model){
        List<Board> japaneseList = boardRepository.findByLanguage("Japanese");
        int japaneseSize = japaneseList.size();
        List<Board> pagingJapanese = boardRepository.findByLanguageWithPaging("Japanese", page);
        model.addAttribute("pageMaker", new PageDTO(page, japaneseSize));
        model.addAttribute("board", pagingJapanese);
        return "bulletin_jap";
    }
}
