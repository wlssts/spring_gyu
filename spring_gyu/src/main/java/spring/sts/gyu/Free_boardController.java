package spring.sts.gyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.model.free_board.Free_boardDAO;


@Controller
public class Free_boardController {

	@Autowired
	private Free_boardDAO dao;
}
