package spring.model.notice_board;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Notice_boardDAO implements INotice_boardDAO{

	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public boolean create(Object dto) throws Exception {
		int cnt = mybatis.insert("notice_board.create",dto);
		if(cnt > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List list(Map map) throws Exception {
		List<Notice_boardDTO> list = mybatis.selectList("notice_board.list", map);
		return list;
	}

	@Override
	public Object read(Object noticeno) throws Exception {
		Notice_boardDTO dto = mybatis.selectOne("notice_board.read",noticeno);
		return dto;
	}

	@Override
	public boolean update(Object dto) throws Exception {
		int cnt = mybatis.update("notice_board.update",dto);
		if(cnt > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(Object noticeno) throws Exception {
		int cnt = mybatis.delete("notice_board.delete", noticeno);
		if(cnt > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int total(Map map) throws Exception {
		int total = mybatis.selectOne("notice_board.total", map);
		return total;
	}

	@Override
	public void upViewcnt(int noticeno){
		mybatis.update("notice_board.upViewcnt",noticeno);
		
	}

	@Override
	public boolean fileDel(Map map) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
