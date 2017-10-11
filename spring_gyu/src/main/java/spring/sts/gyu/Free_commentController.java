package spring.sts.gyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.model.free_comment.Free_commentDAO;


@Controller
public class Free_commentController {

	@Autowired
	private Free_commentDAO dao;
}
