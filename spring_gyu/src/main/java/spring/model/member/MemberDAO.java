package spring.model.member;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MemberDAO implements IMemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
			
	public void setMybatis(SqlSessionTemplate mybatis) {
		
		this.mybatis = mybatis;
	}

	@Override
	public boolean create(Object dto) throws Exception {
		// TODO Auto-generated method stub
		
		return (Integer)mybatis.insert("member.create", (MemberDTO)dto)>0;
	}

	@Override
	public List<MemberDTO> list(Map map) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectList("member.list", map);
	}

	@Override
	public MemberDTO read(Object id) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("member.read", (String)id);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.update("member.update", (MemberDTO)dto)>0;
	}

	@Override
	public boolean delete(Object id) throws Exception {
		// TODO Auto-generated method stub
		return (Integer)mybatis.delete("member.delete", (String)id)>0;
	}

	@Override
	public int total(Map map) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("member.total", map);
	}

	@Override
	public String getGrade(String id) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("member.getGrade", id);
	}

	@Override
	public boolean loginCheck(Map map) throws Exception {
		// TODO Auto-generated method stub
		return (Integer)mybatis.selectOne("member.loginCheck", map)>0;
	}

	@Override
	public boolean duplicateId(String id) throws Exception {
		// TODO Auto-generated method stub
		return (Integer)mybatis.selectOne("member.duplicateId", id)>0;
	}

	@Override
	public boolean idCheck(String id) throws Exception {
		// TODO Auto-generated method stub
		return (Integer)mybatis.selectOne("member.idCheck", id)>0;
	}

}
