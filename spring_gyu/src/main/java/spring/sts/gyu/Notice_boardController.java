package spring.sts.gyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.model.notice_board.Notice_boardDAO;

@Controller
public class Notice_boardController {

	@Autowired
	private Notice_boardDAO dao;
}
