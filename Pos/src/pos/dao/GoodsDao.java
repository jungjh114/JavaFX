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
import pos.vo.Goods;

public class GoodsDao implements IDao<Goods, Integer> {
	private Connection conn = ConnFactory.getConnection("pos.config.oracle");

	@Override
	public void insert(Goods vo) {
		String sql = "INSERT INTO GOODS (GOODS_NO, GOODS_NAME, GOODS_KIND, GOODS_PRICE) "
				+ "VALUES (SEQ_GOODS.NEXTVAL, ?, ?, ?) ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGoods_name());
			pstmt.setString(2, vo.getGoods_kind());
			pstmt.setInt(3, vo.getGoods_price());

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println("상품을 등록하였습니다");
			} else {
				System.out.println("상품을 등록하지 못했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer primaryKey) {
		String sql = "DELETE FROM GOODS " + "WHERE GOODS_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println(primaryKey + " 상품을 삭제하였습니다.");
			} else {
				System.out.println("지울 자료가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DELETE 질의 점검!");
		}
	}

	@Override
	public void update(Goods vo) {
		String sql = "UPDATE GOODS " + "SET GOODS_NAME = ?, GOODS_KIND = ?, GOODS_PRICE = ? " + "WHERE GOODS_No = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getGoods_name());
			pstmt.setString(2, vo.getGoods_kind());
			pstmt.setInt(3, vo.getGoods_price());
			pstmt.setInt(4, vo.getGoods_no());

			int res = pstmt.executeUpdate();

			if (res > 0) {
				System.out.println(vo.getGoods_name() + " 상품내용이 변경되었습니다.");
			} else {
				System.out.println("변경할 상품이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("UPDATE 질의 점검!");
		}
	}

	@Override
	public Goods select(Integer primaryKey) {
		String sql = "SELECT * FROM GOODS " + "WHERE GOODS_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Goods vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, primaryKey);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new Goods();
				// vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setGoods_name(rs.getString("GOODS_NAME"));
				// vo.setGoods_kind(rs.getString("GOODS_KIND"));
				vo.setGoods_price(rs.getInt("GOODS_PRICE"));
				vo.setQuantity(1);
				vo.setSumPrice(vo.getGoods_price() * vo.getQuantity());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List selectAll() {
		String sql = "SELECT * FROM GOODS";
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<Goods> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Goods vo = new Goods();
				vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setGoods_name(rs.getString("GOODS_NAME"));
				vo.setGoods_kind(rs.getString("GOODS_KIND"));
				vo.setGoods_price(rs.getInt("GOODS_PRICE"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List select1(String goods) {
		String sql = "SELECT * FROM GOODS " + "WHERE GOODS_KIND = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Goods vo = null;
		List<Goods> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new Goods();
				// vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setGoods_name(rs.getString("GOODS_NAME"));
				// vo.setGoods_kind(rs.getString("GOODS_KIND"));
				vo.setGoods_price(rs.getInt("GOODS_PRICE"));
				vo.setQuantity(1);
				vo.setSumPrice(vo.getGoods_price() * vo.getQuantity());
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Goods nameSelect(String name) {
		String sql = "SELECT * FROM GOODS " + "WHERE GOODS_NAME = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Goods vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new Goods();
				vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setGoods_name(rs.getString("GOODS_NAME"));
				vo.setGoods_kind(rs.getString("GOODS_KIND"));
				vo.setGoods_price(rs.getInt("GOODS_PRICE"));
				vo.setQuantity(1);
				vo.setSumPrice(vo.getGoods_price() * vo.getQuantity());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public List nameSelect1(String name) {
		String sql = "SELECT * FROM GOODS " + "WHERE GOODS_NAME LIKE ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		Goods vo = null;
		List<Goods> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new Goods();
				vo.setGoods_no(rs.getInt("GOODS_NO"));
				vo.setGoods_name(rs.getString("GOODS_NAME"));
				vo.setGoods_kind(rs.getString("GOODS_KIND"));
				vo.setGoods_price(rs.getInt("GOODS_PRICE"));
				vo.setQuantity(1);
				vo.setSumPrice(vo.getGoods_price() * vo.getQuantity());
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
