package pos;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pos.dao.GoodsDao;
import pos.dao.SaleInfoDao;
import pos.vo.Goods;
import pos.vo.SaleInfo;

public class deleteControl implements Initializable {

	private GoodsDao dao = new GoodsDao();

	@FXML
	private JFXButton btnBack;

	@FXML
	private TableColumn<Goods, String> colName;

	@FXML
	private TableView<Goods> table;

	@FXML
	private JFXButton btnRevise;

	@FXML
	private JFXTextField txtProductName;

	@FXML
	private JFXButton btnSelectAll;

	@FXML
	private JFXButton btnDelete;

	@FXML
	private JFXTextField txtNum;

	@FXML
	private JFXButton btnNameSelect;

	@FXML
	private TableColumn<Goods, Integer> colNum;

	@FXML
	private TableColumn<Goods, Integer> colPrice;

	@FXML
	private JFXTextField txtPrice;

	@FXML
	private TableColumn<Goods, String> colKind;

	@FXML
	private JFXTextField txtKind;

	@FXML
	void revise(ActionEvent event) {

		Goods vo = new Goods();
		vo.setGoods_no(Integer.parseInt(txtNum.getText()));
		vo.setGoods_name(txtProductName.getText());
		vo.setGoods_kind(txtKind.getText());
		vo.setGoods_price(Integer.parseInt(txtPrice.getText()));

		dao.update(vo);
		JOptionPane.showMessageDialog(null, "상품이 변경되었습니다.");
		table.getItems().clear();
		table.getItems().add(vo);
	}

	@FXML
	void selectAll(ActionEvent event) {
		List<Goods> list = dao.selectAll();
		table.getItems().clear();
		table.getItems().addAll(list);
	}

	@FXML
	void delete(ActionEvent event) {

		dao.delete(Integer.parseInt(txtNum.getText()));

		List<Goods> list = dao.selectAll();
		JOptionPane.showMessageDialog(null, "상품이 삭제되었습니다.");
		table.getItems().clear();
		table.getItems().addAll(list);

	}

	@FXML
	void back(ActionEvent event) {
		Stage stage = (Stage) btnBack.getScene().getWindow();
		stage.close();
	}

	@FXML
	void nameSelect(ActionEvent event) {
		List<Goods> list = dao.nameSelect1("%" + txtProductName.getText() + "%");
		table.getItems().clear();
		table.getItems().addAll(list);
	}

	@FXML
	void released(MouseEvent event) {
		int index = table.getSelectionModel().getSelectedIndex();
		Goods vo = table.getItems().get(index);
		txtNum.setText(vo.getGoods_no() + "");
		txtProductName.setText(vo.getGoods_name());
		txtKind.setText(vo.getGoods_kind());
		txtPrice.setText(vo.getGoods_price() + "");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dao = new GoodsDao();
		colNum.setCellValueFactory(new PropertyValueFactory("goods_no"));
		colName.setCellValueFactory(new PropertyValueFactory("goods_name"));
		colKind.setCellValueFactory(new PropertyValueFactory("goods_kind"));
		colPrice.setCellValueFactory(new PropertyValueFactory("goods_price"));
	}

}
