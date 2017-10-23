package spring.model.qna;

import spring.inter.DAOinter;

public interface IQnaDAO extends DAOinter {
	
	public boolean alldelete(int grpno) throws Exception;
	
	public boolean upviewcnt (int qnano) throws Exception;
	
	public boolean passwdCheck (int qnano) throws Exception;
	
	public boolean replyCreate (int qnano) throws Exception;
	
	public boolean getRefno (int qnano) throws Exception;
}
