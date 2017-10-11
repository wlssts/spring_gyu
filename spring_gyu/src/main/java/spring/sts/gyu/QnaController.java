package spring.sts.gyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.model.qna.QnaDAO;

@Controller
public class QnaController {

	@Autowired
	private QnaDAO dao;
}
