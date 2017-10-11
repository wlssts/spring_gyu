package spring.sts.gyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.model.table.TableDAO;

@Controller
public class TableController {

	@Autowired
	private TableDAO dao;
}
