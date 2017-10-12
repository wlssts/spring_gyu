package spring.model.member;

import java.util.List;
import java.util.Map;

import spring.inter.DAOinter;

public interface IMemberDAO extends DAOinter {
	
	public String getGrade(String id) throws Exception;
	
	public boolean loginCheck(Map map) throws Exception;
	
	public boolean updatePw(Map map) throws Exception;
	
	public boolean update(MemberDTO dto) throws Exception;
	
	public boolean delete(String id) throws Exception;
	
	public boolean duplicateId(String id) throws Exception;
	
	
}
