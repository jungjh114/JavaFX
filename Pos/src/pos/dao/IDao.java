package pos.dao;

import java.util.List;

// 우리가 만드는 모든 Dao에 공통적으로 활용할 메소드를 추상화
public interface IDao<T, K> {
	//
	public void insert(T vo);

	public void delete(K primaryKey);

	public void update(T vo);

	//
	public T select(K primaryKey);

	public List selectAll(); // select * from tableName
}
