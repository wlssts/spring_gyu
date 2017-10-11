package spring.inter;

import java.util.List;
import java.util.Map;

public interface DAOinter {
	public boolean create(Object dto) throws Exception;

	public List list(Map map) throws Exception;

	public Object read(Object pk) throws Exception;

	public boolean update(Object dto) throws Exception;

	public boolean delete(Object pk) throws Exception;

	public int total(Map map) throws Exception;
}
