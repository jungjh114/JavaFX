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
import pos.vo.SaleInfo;

public class SaleInfoDao implements IDao<SaleInfo, Integer> {
	Connection conn = ConnFactory.getConnection("pos.config.oracle");

	@Override
	public void insert(SaleInfo vo) {
		String sql = "INSERT INTO SALEINFO(SALE_NO, MEMBER_NO, GOODS_NO, SALE_QUANTITY, SALE_PRICE, SALE_DATE) "
				+ "VALUES (SEQ_SALE.NEXTVAL, ?, ?, ?, ?, to_date( ? , ? ))";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMember_no());
			pstmt.setInt(2, vo.getGoods_no());
			pstmt.setInt(3, vo.getSale_quantity());
			pstmt.setInt(4, vo.getSale_price());
			pstmt.setString(5, vo.getSale_date());
			pstmt.setString(6, "YYYY-MM-dd HH24:mi:ss");

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println("판매목록을 등록하였습니다");
			} else {
				System.out.println("판매목록을 등록하지 못했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer primaryKey) {
		String sql = "DELETE FROM SALEINFO " + "WHERE SALE_NO = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println("판매정보를 삭제하였습니다");
			} else {
				System.out.println("판매정보를 삭제하지 못했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(SaleInfo vo) {
		String sql = "UPDATE SALEINFO "
				+ "SET MEMBER_NO = ?, GOODS_NO = ?, SALE_QUANTITY = ?, SALE_PRICE = ?, SALE_DATE = TO_DATE(?, 'YYYY-MM-DD') "
				+ "WHERE SALE_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMember_no());
			pstmt.setInt(2, vo.getGoods_no());
			pstmt.setInt(3, vo.getSale_quantity());
			pstmt.setInt(4, vo.getSale_price());
			pstmt.setString(5, vo.getSale_date().substring(0, 10));
			pstmt.setInt(6, vo.getSale_no());

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println(vo.getSale_no() + "번 판매정보가 변경되었습니다.");
			} else {
				System.out.println("변경할 판매정보가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("UPDATE 질의 점검!");
		}
	}

	@Override
	public SaleInfo select(Integer primaryKey) {
		String sql = "SELECT * FROM SALEINFO " + "WHERE SALE_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		SaleInfo vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new SaleInfo();
				vo.setSale_no(rs.getInt("SALE_NO"));
				vo.setMember_no(rs.getInt("MEMBER_NO"));
				vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setSale_quantity(rs.getInt("SALE_QUANTITY"));
				vo.setSale_price(rs.getInt("SALE_PRICE"));
				vo.setSale_date(rs.getString("SALE_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List selectAll() {
		String sql = "SELECT * FROM SALEINFO";
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<SaleInfo> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SaleInfo vo = new SaleInfo();
				vo.setSale_no(rs.getInt("SALE_NO"));
				vo.setMember_no(rs.getInt("MEMBER_NO"));
				vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setSale_quantity(rs.getInt("SALE_QUANTITY"));
				vo.setSale_price(rs.getInt("SALE_PRICE"));
				vo.setSale_date(rs.getString("SALE_DATE"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List nameSelect(String name) {
		String sql = "SELECT S.SALE_NO, S.MEMBER_NO, S.GOODS_NO, S.SALE_QUANTITY, S.SALE_PRICE, S.SALE_DATE "
				+ "FROM SALEINFO S, MEMBER M " + "WHERE S.MEMBER_NO = M.MEMBER_NO AND M.MEMBER_NAME = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<SaleInfo> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SaleInfo vo = new SaleInfo();
				vo.setSale_no(rs.getInt("SALE_NO"));
				vo.setMember_no(rs.getInt("MEMBER_NO"));
				vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setSale_quantity(rs.getInt("SALE_QUANTITY"));
				vo.setSale_price(rs.getInt("SALE_PRICE"));
				vo.setSale_date(rs.getString("SALE_DATE"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List dateSelect(String fDate, String eDate) {
		String sql = "SELECT * " + "FROM SALEINFO " + "WHERE SALE_DATE BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<SaleInfo> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fDate);
			pstmt.setString(2, eDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SaleInfo vo = new SaleInfo();
				vo.setSale_no(rs.getInt("SALE_NO"));
				vo.setMember_no(rs.getInt("MEMBER_NO"));
				vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setSale_quantity(rs.getInt("SALE_QUANTITY"));
				vo.setSale_price(rs.getInt("SALE_PRICE"));
				vo.setSale_date(rs.getString("SALE_DATE"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
