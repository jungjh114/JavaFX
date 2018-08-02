package pos.vo;

public class Goods {
	private int goods_no;
	private String goods_name;
	private String goods_kind;
	private int goods_price;
	private int quantity;
	private int sumPrice;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_kind() {
		return goods_kind;
	}

	public void setGoods_kind(String goods_kind) {
		this.goods_kind = goods_kind;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

	@Override
	public String toString() {
		return goods_no + "\t" + goods_name + "\t" + goods_price + "\t" + quantity + "\t" + sumPrice + "\t"
				+ goods_kind;
	}
}
