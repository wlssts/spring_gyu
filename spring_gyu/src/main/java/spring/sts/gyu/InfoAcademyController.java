package spring.sts.gyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.model.infoAcademy.InfoAcademyDAO;

@Controller
public class InfoAcademyController {

	@Autowired
	private InfoAcademyDAO dao;
}
