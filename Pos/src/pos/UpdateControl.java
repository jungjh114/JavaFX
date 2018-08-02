package pos;

import java.net.URL;
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
import javafx.stage.Stage;
import pos.dao.GoodsDao;
import pos.vo.Goods;

public class UpdateControl implements Initializable {

	@FXML
	private JFXButton btnClose;

	@FXML
	private JFXButton btnInsert;

	@FXML
	private JFXTextField txtDrinkName;

	@FXML
	private JFXTextField txtPrice;

	@FXML
	private JFXComboBox<String> cmbKind;

	private GoodsDao dao = new GoodsDao();

	ObservableList<String> list = FXCollections.observableArrayList("coffee", "drink", "dessert");

	@FXML
	void insert(ActionEvent event) {
		Goods vo = new Goods();
		String kind = cmbKind.getSelectionModel().getSelectedItem();
		int price = Integer.parseInt(txtPrice.getText());

		vo.setGoods_name(txtDrinkName.getText());
		vo.setGoods_kind(kind);
		vo.setGoods_price(price);

		dao.insert(vo);
		
		JOptionPane.showMessageDialog(null, "상품등록이 완료되었습니다.\n새로고침 버튼을 눌러주세요");

		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
	}

	@FXML
	void close(ActionEvent event) {
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cmbKind.setItems(list);
	}

}