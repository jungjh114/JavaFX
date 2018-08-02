package pos.dao;

import java.util.List;

import pos.dao.SaleInfoDao;
import pos.vo.SaleInfo;

public class SaleInfoDaoTest {
	private SaleInfoDao dao = new SaleInfoDao();

	public static void main(String[] args) {
		new SaleInfoDaoTest().test();

	}

	public void test() {
		// insertTest();
		// selectTest();
		// selectAllTest();
		// updateTest();
		// deleteTest();
		nameSelectTest();
	}

	public void insertTest() {
		SaleInfo vo = new SaleInfo();
		vo.setMember_no(1);
		;
		vo.setGoods_no(0);
		vo.setSale_quantity(3);
		vo.setSale_price(6000);
		vo.setSale_date("2018-04-16");

		dao.insert(vo);
	}

	public void deleteTest() {
		dao.delete(0);
	}

	public void updateTest() {
		SaleInfo vo = dao.select(0);
		vo.setGoods_no(1);
		dao.update(vo);
	}

	public void selectTest() {
		SaleInfo vo = dao.select(0);
		System.out.println(vo);
	}

	public void selectAllTest() {
		List<SaleInfo> list = dao.selectAll();
		for (SaleInfo x : list) {
			System.out.println(x);
		}
	}

	public void nameSelectTest() {
		List<SaleInfo> list = dao.nameSelect("정진혁");
		for (SaleInfo x : list) {
			System.out.println(x);
		}
	}
}
