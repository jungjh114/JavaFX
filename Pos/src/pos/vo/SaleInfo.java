package pos.vo;

public class SaleInfo {
	private int sale_no;
	private int member_no;
	private int goods_no;
	private int sale_quantity;
	private int sale_price;
	private String sale_date;

	public int getSale_no() {
		return sale_no;
	}

	public void setSale_no(int sale_no) {
		this.sale_no = sale_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public Integer getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(Integer goods_no) {
		this.goods_no = goods_no;
	}

	public int getSale_quantity() {
		return sale_quantity;
	}

	public void setSale_quantity(int sale_quantity) {
		this.sale_quantity = sale_quantity;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

	public String getSale_date() {
		return sale_date;
	}

	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	@Override
	public String toString() {
		return "SaleInfo [sale_no=" + sale_no + ", member_no=" + member_no + ", goods_no=" + goods_no
				+ ", sale_quantity=" + sale_quantity + ", sale_price=" + sale_price + ", sale_date=" + sale_date + "]";
	}
}
