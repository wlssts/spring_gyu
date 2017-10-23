package spring.model.qna;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class QnaDAO implements IQnaDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	@Override
	public boolean create(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.insert("qna.create", (QnaDTO)dto)>0;
	}

	@Override
	public List<QnaDTO> list(Map map) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectList("qna.list", map);
	}

	@Override
	public QnaDTO read(Object qnano) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("qna.read", (Integer)qnano);
	}

	@Override
	public boolean update(Object dto) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.update("qna.update", (QnaDTO)dto)>0;
	}

	@Override
	public boolean delete(Object qnano) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.delete("qna.delete", (Integer)qnano)>0;
	}

	@Override
	public int total(Map map) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("qna.total", map);
	}

	@Override
	public boolean alldelete(int grpno) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.delete("qna.alldelete", grpno)>0;
	}

	@Override
	public boolean upviewcnt(int qnano) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.update("qna.upviewcnt", qnano)>0;
	}

	@Override
	public boolean passwdCheck(int qnano) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.update("qna.passwdCheck", qnano)>0;
	}

	@Override
	public boolean replyCreate(int qnano) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.insert("qna.replyCreate", qnano)>0;
	}

	@Override
	public boolean getRefno(int qnano) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("qna.getRefno", qnano);
	}

}
