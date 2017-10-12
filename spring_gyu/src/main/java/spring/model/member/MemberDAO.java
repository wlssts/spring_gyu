package spring.model.member;

import java.util.List;
import java.util.Map;

public class MemberDAO implements IMemberDAO {

	@Override
	public boolean create(Object dto) throws Exception {
		// TODO Auto-generated method stub
		

		
		return false;
	}

	@Override
	public List list(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object read(Object pk) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object pk) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int total(Map map) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getGrade(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginCheck(Map map) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePw(Map map) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean duplicateId(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
