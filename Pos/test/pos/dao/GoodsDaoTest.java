package pos.dao;

import java.util.List;

import pos.dao.GoodsDao;
import pos.vo.Goods;

public class GoodsDaoTest {
	private GoodsDao dao = new GoodsDao();

	public static void main(String[] args) {
		new GoodsDaoTest().test();
	}

	public void test() {
		// insertTest();
		// selectTest();
		// selectAllTest();
		// updateTest();
		// deleteTest();
		// select1Test();
		// nameSelectTest();
	}

	public void insertTest() {
		Goods vo = new Goods();
		vo.setGoods_name("룰루랄라");
		vo.setGoods_kind("잡잡잡");
		vo.setGoods_price(5000);

		dao.insert(vo);
	}

	public void deleteTest() {
		dao.delete(1);
	}

	public void updateTest() {
		Goods vo = dao.select(1);
		vo.setGoods_price(10000);
		dao.update(vo);
	}

	public void selectTest() {
		Goods vo = dao.select(1);
		System.out.println(vo);
	}

	public void selectAllTest() {
		List<Goods> list = dao.selectAll();
		for (Goods x : list) {
			System.out.println(x);
		}
	}

	public void select1Test() {
		List<Goods> list = dao.select1("dessert");
		for (Goods x : list) {
			System.out.println(x);
		}
	}

	public void nameSelectTest() {
		Goods vo = dao.nameSelect("아메리카노");
		System.out.println(vo);
	}
}
