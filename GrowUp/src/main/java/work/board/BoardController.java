package work.board;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import work.board.BoardVO;
import work.board.Criteria;
import work.board.PageDTO;
import work.board.BoardService;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/board/*")
@Log
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	
	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		
		// board 테이블에서 전체글 리스트로 가져오기
		//List<BoardVO> boardList = boardService.getBoards();
		
		List<BoardVO> boardList = boardService.getList(cri);
		
		int totalCount = boardService.getTotalCount(); // 전체글개수 가져오기
		
		PageDTO pageDTO = new PageDTO(cri, totalCount);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageMaker", pageDTO);
		
		return "board/boardList";
	} // list
	
}
