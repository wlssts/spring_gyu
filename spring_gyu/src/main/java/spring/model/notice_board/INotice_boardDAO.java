package spring.model.notice_board;

import java.util.Map;

import spring.inter.DAOinter;

public interface INotice_boardDAO extends DAOinter {
	public void upViewcnt(int no);
	public boolean fileDel(Map map) throws Exception ;
}
