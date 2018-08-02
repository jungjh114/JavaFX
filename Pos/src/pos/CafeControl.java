package pos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pos.dao.GoodsDao;
import pos.vo.Goods;

public class CafeControl implements Initializable {
	@FXML
	private JFXButton btnRefresh;

	@FXML
	private Button btnMin;

	@FXML
	private Button btnSum;

	@FXML
	private TableColumn<Goods, Integer> colSumPrice;

	@FXML
	private TableColumn<Goods, String> colName;

	@FXML
	private TableColumn<Goods, Integer> colQua;

	@FXML
	private Button btnCoffee9;

	@FXML
	private Button btnCoffee8;

	@FXML
	private Button btnCoffee1;

	@FXML
	private Button btnCoffee11;

	@FXML
	private Button btnDrink5;

	@FXML
	private Button btnDrink11;

	@FXML
	private Button btnCoffee12;

	@FXML
	private Button btnDrink4;

	@FXML
	private Button btnDrink12;

	@FXML
	private Button btnCoffee3;

	@FXML
	private Button btnDrink7;

	@FXML
	private Button btnCoffee2;

	@FXML
	private Button btnDrink6;

	@FXML
	private Button btnCoffee5;

	@FXML
	private Button btnDrink9;

	@FXML
	private Button btnCoffee4;

	@FXML
	private Button btnDrink8;

	@FXML
	private Button btnCoffee7;

	@FXML
	private Button btnCoffee6;

	@FXML
	private Button btnDrink10;

	@FXML
	private Label lblPrice;

	@FXML
	private Button btnDrink1;

	@FXML
	private Button btnDrink3;

	@FXML
	private Button btnCoffee10;

	@FXML
	private Button btnDrink2;

	@FXML
	private Button btnNumber9;

	@FXML
	private Button btnNumber5;

	@FXML
	private Button btnNumber6;

	@FXML
	private Button btnNumber7;

	@FXML
	private JFXButton btnCard;

	@FXML
	private Button btnNumber8;

	@FXML
	private Button btnNumber1;

	@FXML
	private Button btnNumber2;

	@FXML
	private Button btnNumber3;

	@FXML
	private Button btnSelectAll;

	@FXML
	private Button btnNumber4;

	@FXML
	private JFXButton btnUpdate;

	@FXML
	private Button btnNumber0;

	@FXML
	private TableView<Goods> table;

	@FXML
	private JFXButton btnClose;

	@FXML
	private Button btnDessert1;

	@FXML
	private Button btnDessert4;

	@FXML
	private Button btnDessert12;

	@FXML
	private Button btnDessert5;

	@FXML
	private Button btnDessert11;

	@FXML
	private Button btnDessert2;

	@FXML
	private Button btnDessert10;

	@FXML
	private Button btnDessert3;

	@FXML
	private Button btnDessert8;

	@FXML
	private Button btnDessert9;

	@FXML
	private JFXButton btnCash;

	@FXML
	private Button btnDessert6;

	@FXML
	private Button btnDessert7;

	@FXML
	private Button btnSelect;

	@FXML
	private TableColumn<Goods, Integer> colPrice;

	@FXML
	private JFXButton btnSaleList;

	private GoodsDao dao;

	private int sum;

	public static int x = 0;

	public static List<Goods> saleList = new ArrayList<>();

	private Goods selectVo = new Goods();

	private Goods quanVo;

	@FXML
	void select(ActionEvent event) {
		Goods vo = table.getSelectionModel().getSelectedItem();
		if (table.getItems().contains(vo)) {
			table.getItems().remove(vo);
		}
		setLabel();
	}

	@FXML
	void selectAll(ActionEvent event) {
		table.getItems().clear();
		setLabel();
	}

	@FXML
	void number7(ActionEvent event) {
		setQuan(7);
	}

	@FXML
	void number4(ActionEvent event) {
		setQuan(4);
	}

	@FXML
	void number1(ActionEvent event) {
		setQuan(1);
	}

	@FXML
	void number0(ActionEvent event) {
		setQuan(0);
	}

	@FXML
	void number8(ActionEvent event) {
		setQuan(8);
	}

	@FXML
	void number5(ActionEvent event) {
		setQuan(5);
	}

	@FXML
	void number2(ActionEvent event) {
		setQuan(2);
	}

	@FXML
	void min(ActionEvent event) {
		Goods vo = table.getSelectionModel().getSelectedItem();
		vo.setQuantity(vo.getQuantity() - 1);
		if (vo.getQuantity() == 0) {
			table.getItems().remove(vo);
		}
		vo.setSumPrice(vo.getGoods_price() * vo.getQuantity());
		table.refresh();
		setLabel();
	}

	@FXML
	void number9(ActionEvent event) {
		setQuan(9);
	}

	@FXML
	void number6(ActionEvent event) {
		setQuan(6);
	}

	@FXML
	void number3(ActionEvent event) {
		setQuan(3);
	}

	@FXML
	void sum(ActionEvent event) {
		Goods vo = table.getSelectionModel().getSelectedItem();
		vo.setQuantity(vo.getQuantity() + 1);
		vo.setSumPrice(vo.getGoods_price() * vo.getQuantity());
		table.refresh();
		setLabel();
	}

	@FXML
	void coffee2(ActionEvent event) {
		getButtonCoffee(1);
	}

	@FXML
	void coffee3(ActionEvent event) {
		getButtonCoffee(2);
	}

	@FXML
	void coffee5(ActionEvent event) {
		getButtonCoffee(4);
	}

	@FXML
	void coffee1(ActionEvent event) {
		getButtonCoffee(0);
	}

	@FXML
	void coffee4(ActionEvent event) {
		getButtonCoffee(3);
	}

	@FXML
	void coffee6(ActionEvent event) {
		getButtonCoffee(5);
	}

	@FXML
	void coffee7(ActionEvent event) {
		getButtonCoffee(6);
	}

	@FXML
	void coffee10(ActionEvent event) {
		getButtonCoffee(9);
	}

	@FXML
	void coffee9(ActionEvent event) {
		getButtonCoffee(8);
	}

	@FXML
	void coffee8(ActionEvent event) {
		getButtonCoffee(7);
	}

	@FXML
	void coffee12(ActionEvent event) {
		getButtonCoffee(11);
	}

	@FXML
	void coffee11(ActionEvent event) {
		getButtonCoffee(10);
	}

	@FXML
	void drink1(ActionEvent event) {
		getButtonDrink(0);
	}

	@FXML
	void drink2(ActionEvent event) {
		getButtonDrink(1);
	}

	@FXML
	void drink4(ActionEvent event) {
		getButtonDrink(3);
	}

	@FXML
	void drink3(ActionEvent event) {
		getButtonDrink(2);
	}

	@FXML
	void drink5(ActionEvent event) {
		getButtonDrink(4);
	}

	@FXML
	void drink7(ActionEvent event) {
		getButtonDrink(6);
	}

	@FXML
	void drink6(ActionEvent event) {
		getButtonDrink(5);
	}

	@FXML
	void drink8(ActionEvent event) {
		getButtonDrink(7);
	}

	@FXML
	void drink9(ActionEvent event) {
		getButtonDrink(8);
	}

	@FXML
	void drink12(ActionEvent event) {
		getButtonDrink(11);
	}

	@FXML
	void drink11(ActionEvent event) {
		getButtonDrink(10);
	}

	@FXML
	void drink10(ActionEvent event) {
		getButtonDrink(9);
	}

	@FXML
	void dessert1(ActionEvent event) {
		getButtonDessert(0);
	}

	@FXML
	void dessert2(ActionEvent event) {
		getButtonDessert(1);
	}

	@FXML
	void dessert7(ActionEvent event) {
		getButtonDessert(6);
	}

	@FXML
	void dessert6(ActionEvent event) {
		getButtonDessert(5);
	}

	@FXML
	void dessert5(ActionEvent event) {
		getButtonDessert(4);
	}

	@FXML
	void dessert4(ActionEvent event) {
		getButtonDessert(3);
	}

	@FXML
	void dessert3(ActionEvent event) {
		getButtonDessert(2);
	}

	@FXML
	void dessert9(ActionEvent event) {
		getButtonDessert(8);
	}

	@FXML
	void dessert8(ActionEvent event) {
		getButtonDessert(7);
	}

	@FXML
	void dessert12(ActionEvent event) {
		getButtonDessert(11);
	}

	@FXML
	void dessert11(ActionEvent event) {
		getButtonDessert(10);
	}

	@FXML
	void dessert10(ActionEvent event) {
		getButtonDessert(9);
	}

	@FXML
	void cash(ActionEvent event) {
		fxmlContinue("finalPayment.fxml");

		saleList.addAll(table.getItems());
	}

	@FXML
	void card(ActionEvent event) {
		fxmlContinue("finalPayment.fxml");

		saleList.addAll(table.getItems());
	}

	@FXML
	void saleList(ActionEvent event) {
		fxmlContinue("saleImformation.fxml");
	}

	@FXML
	void update(ActionEvent event) {
		fxmlContinue("delete.fxml");
	}

	@FXML
	void close(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void refresh(ActionEvent event) {
		Stage stage = (Stage) btnUpdate.getScene().getWindow();
		stage.close();
		fxmlContinue("cafe.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dao = new GoodsDao();
		colName.setCellValueFactory(new PropertyValueFactory("goods_name"));
		colPrice.setCellValueFactory(new PropertyValueFactory("goods_price"));
		colQua.setCellValueFactory(new PropertyValueFactory("quantity"));
		colSumPrice.setCellValueFactory(new PropertyValueFactory("sumPrice"));

		Button[] btnCoffee = { btnCoffee1, btnCoffee2, btnCoffee3, btnCoffee4, btnCoffee5, btnCoffee6, btnCoffee7,
				btnCoffee8, btnCoffee9, btnCoffee10, btnCoffee11, btnCoffee12 };
		Button[] btnDrink = { btnDrink1, btnDrink2, btnDrink3, btnDrink4, btnDrink5, btnDrink6, btnDrink7, btnDrink8,
				btnDrink9, btnDrink10, btnDrink11, btnDrink12 };
		Button[] btnDessert = { btnDessert1, btnDessert2, btnDessert3, btnDessert4, btnDessert5, btnDessert6,
				btnDessert7, btnDessert8, btnDessert9, btnDessert10, btnDessert11, btnDessert12 };

		menuInsert("coffee", btnCoffee);
		menuInsert("drink", btnDrink);
		menuInsert("dessert", btnDessert);
	}

	public void setLabel() {
		sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < table.getItems().size(); i++) {
			list.add(colSumPrice.getCellData(i));
		}
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		lblPrice.setText(sum + "");
		x = sum; // 총액을 다른클래스로 전달하는 변수 x
	}

	public void getButtonCoffee(Integer num) {
		List<Goods> list = dao.select1("coffee");

		if (num >= list.size()) {
			fxmlContinue("update.fxml");
		} else {
			String goodsName = list.get(num).getGoods_name();
			for (int i = 0; i < table.getItems().size(); i++) {
				String menuName = colName.getCellData(i);
				if (menuName.equals(goodsName)) {
					Goods menuVo = table.getItems().get(i);
					menuVo.setQuantity(menuVo.getQuantity() + 1);
					menuVo.setSumPrice(menuVo.getGoods_price() * menuVo.getQuantity());
					table.refresh();
					setLabel();
					return;
				}
			}
			Goods vo = list.get(num);
			table.getItems().add(vo);
			setLabel();
		}

		int index = table.getItems().size();
		table.getSelectionModel().clearSelection();
		quanVo = null;
		if (num < list.size()) {
			selectVo = table.getItems().get(index - 1);
		}
	}

	public void getButtonDrink(Integer num) {
		List<Goods> list = dao.select1("drink");
		if (num >= list.size()) {
			fxmlContinue("update.fxml");
		} else {
			String goodsName = list.get(num).getGoods_name();
			for (int i = 0; i < table.getItems().size(); i++) {
				String menuName = colName.getCellData(i);
				if (menuName.equals(goodsName)) {
					Goods menuVo = table.getItems().get(i);
					menuVo.setQuantity(menuVo.getQuantity() + 1);
					menuVo.setSumPrice(menuVo.getGoods_price() * menuVo.getQuantity());
					table.refresh();
					setLabel();
					return;
				}
			}
			Goods vo = list.get(num);
			table.getItems().add(vo);
			setLabel();
		}

		int index = table.getItems().size();
		table.getSelectionModel().clearSelection();
		quanVo = null;
		if (num < list.size()) {
			selectVo = table.getItems().get(index - 1);
		}
	}

	public void getButtonDessert(Integer num) {
		List<Goods> list = dao.select1("dessert");
		if (num >= list.size()) {
			fxmlContinue("update.fxml");
		} else {
			String goodsName = list.get(num).getGoods_name();
			for (int i = 0; i < table.getItems().size(); i++) {
				String menuName = colName.getCellData(i);
				if (menuName.equals(goodsName)) {
					Goods menuVo = table.getItems().get(i);
					menuVo.setQuantity(menuVo.getQuantity() + 1);
					menuVo.setSumPrice(menuVo.getGoods_price() * menuVo.getQuantity());
					table.refresh();
					setLabel();
					return;
				}
			}
			Goods vo = list.get(num);
			table.getItems().add(vo);
			setLabel();
		}

		int index = table.getItems().size();
		table.getSelectionModel().clearSelection();
		quanVo = null;
		if (num < list.size()) {
			selectVo = table.getItems().get(index - 1);
		}
	}

	public void setQuan(Integer num) {
		quanVo = table.getSelectionModel().getSelectedItem();
		if (quanVo != null) {
			quanVo.setQuantity(num);
			quanVo.setSumPrice(quanVo.getGoods_price() * quanVo.getQuantity());
			table.refresh();
			setLabel();
		} else {
			selectVo.setQuantity(num);
			selectVo.setSumPrice(selectVo.getGoods_price() * selectVo.getQuantity());
			table.refresh();
			setLabel();
		}
	}

	public void fxmlContinue(String str) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource(str));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void menuInsert(String str, Button[] btnArray) {
		List<Goods> list = dao.select1(str);
		for (int i = 0; i < list.size(); i++) {
			btnArray[i].setText(list.get(i).getGoods_name());
		}
	}
}