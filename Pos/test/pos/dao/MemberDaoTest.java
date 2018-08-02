package pos.dao;

import java.util.List;

import pos.dao.MemberDao;
import pos.vo.Member;

public class MemberDaoTest {
	private MemberDao dao = new MemberDao();

	public static void main(String[] args) {
		new MemberDaoTest().test();

	}

	public void test() {
		// insertTest();
		// selectTest();
		// selectAllTest();
		// updateTest();
		// deleteTest();
		selectTest2();
	}

	public void insertTest() {
		Member vo = new Member();
		vo.setMember_name("정진혁");
		vo.setMember_phone("010-3441-0114");
		vo.setMember_point(0);

		dao.insert(vo);
	}

	public void deleteTest() {
		dao.delete(0);
	}

	public void updateTest() {
		Member vo = dao.select(0);
		vo.setMember_phone("010-3441-1114");
		dao.update(vo);
	}

	public void selectTest() {
		Member vo = dao.select(0);
		System.out.println(vo);
	}

	public void selectAllTest() {
		List<Member> list = dao.selectAll();
		for (Member x : list) {
			System.out.println(x);
		}
	}

	public void selectTest1() {
		List<Member> list = dao.select1("정진혁");
		for (Member x : list) {
			System.out.println(x);
		}
	}

	public void selectTest2() {
		List<Member> list = dao.select2("%" + "0114" + "%");
		for (Member x : list) {
			System.out.println(x);
		}
	}
}
