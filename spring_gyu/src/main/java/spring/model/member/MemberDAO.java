package spring.model.member;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
			
	public void setMybatis(SqlSessionTemplate mybatis) {
		
		this.mybatis = mybatis;
	}
	
	public List<MemberDTO> list(Map map) {
		
		return mybatis.selectList("member.list", map);
	}
	public int total(Map map){
		 
		return mybatis.selectOne("member.total", map);
	}
}
