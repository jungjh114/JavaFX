package pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pos.common.ConnFactory;
import pos.vo.Member;

public class MemberDao implements IDao<Member, Integer> {
	Connection conn = ConnFactory.getConnection("pos.config.oracle");

	@Override
	public void insert(Member vo) {
		String sql = "INSERT INTO MEMBER(MEMBER_NO, MEMBER_NAME, MEMBER_PHONE, MEMBER_POINT) "
				+ "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMember_name());
			pstmt.setString(2, vo.getMember_phone());
			pstmt.setInt(3, vo.getMember_point());

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println("회원을 등록하였습니다");
			} else {
				System.out.println("회원을 등록하지 못했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer primaryKey) {
		String sql = "DELETE FROM MEMBER " + "WHERE MEMBER_NO = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println("회원을 삭제하였습니다");
			} else {
				System.out.println("회원을 삭제하지 못했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Member vo) {
		String sql = "UPDATE MEMBER " + "SET MEMBER_NAME = ?, MEMBER_PHONE = ?, MEMBER_POINT = ? "
				+ "WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMember_name());
			pstmt.setString(2, vo.getMember_phone());
			pstmt.setInt(3, vo.getMember_point());
			pstmt.setInt(4, vo.getMember_no());

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println(vo.getMember_name() + "님의 회원정보가 변경되었습니다.");
			} else {
				System.out.println("변경할 회원이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("UPDATE 질의 점검!");
		}
	}

	@Override
	public Member select(Integer primaryKey) {
		String sql = "SELECT * FROM MEMBER " + "WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Member vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new Member();
				vo.setMember_no(rs.getInt("MEMBER_NO"));
				vo.setMember_name(rs.getString("MEMBER_NAME"));
				vo.setMember_phone(rs.getString("MEMBER_PHONE"));
				vo.setMember_point(rs.getInt("MEMBER_POINT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List selectAll() {
		String sql = "SELECT * FROM MEMBER";
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<Member> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Member vo = new Member();
				vo.setMember_no(rs.getInt("MEMBER_NO"));
				vo.setMember_name(rs.getString("MEMBER_NAME"));
				vo.setMember_phone(rs.getString("MEMBER_PHONE"));
				vo.setMember_point(rs.getInt("MEMBER_POINT"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List select1(String name) {
		String sql = "SELECT * FROM MEMBER " + "WHERE MEMBER_NAME = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Member vo = null;
		List<Member> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new Member();
				vo.setMember_no(rs.getInt("MEMBER_NO"));
				vo.setMember_name(rs.getString("MEMBER_NAME"));
				vo.setMember_phone(rs.getString("MEMBER_PHONE"));
				vo.setMember_point(rs.getInt("MEMBER_POINT"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List select2(String phone) {
		String sql = "SELECT * FROM MEMBER " + "WHERE MEMBER_PHONE LIKE ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Member vo = null;
		List<Member> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new Member();
				vo.setMember_no(rs.getInt("MEMBER_NO"));
				vo.setMember_name(rs.getString("MEMBER_NAME"));
				vo.setMember_phone(rs.getString("MEMBER_PHONE"));
				vo.setMember_point(rs.getInt("MEMBER_POINT"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
