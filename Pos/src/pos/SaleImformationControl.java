package pos;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pos.dao.SaleInfoDao;
import pos.vo.SaleInfo;

public class SaleImformationControl implements Initializable {

	@FXML
	private JFXButton btnClose;

	@FXML
	private TableView<SaleInfo> tableSale;

	@FXML
	private JFXTextField txtName;

	@FXML
	private DatePicker endDate;

	@FXML
	private TableColumn<SaleInfo, Integer> colSalequa;

	@FXML
	private TableColumn<SaleInfo, Integer> colMemberno;

	@FXML
	private TableColumn<SaleInfo, Integer> colSaleno;

	@FXML
	private JFXButton btnAll;

	@FXML
	private TableColumn<SaleInfo, Integer> colGoodsno;

	@FXML
	private JFXButton btnNameSelect;

	@FXML
	private DatePicker firstDate;

	@FXML
	private JFXButton btnDateSelect;

	@FXML
	private TableColumn<SaleInfo, Integer> colSalprice;

	@FXML
	private TableColumn<SaleInfo, String> colSaledate;

	private SaleInfoDao dao;

	@FXML
	void nameSelect(ActionEvent event) {
		List<SaleInfo> list = dao.nameSelect(txtName.getText());
		tableSale.getItems().clear();
		tableSale.getItems().addAll(list);
	}

	@FXML
	void close(ActionEvent event) {
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
	}

	@FXML
	void dateSelect(ActionEvent event) {
		String fDate = setDate(firstDate);
		String eDate = setDate(endDate);
		List<SaleInfo> list = dao.dateSelect(fDate, eDate);
		tableSale.getItems().clear();
		tableSale.getItems().addAll(list);
	}

	@FXML
	void all(ActionEvent event) {
		List<SaleInfo> list = dao.selectAll();
		tableSale.getItems().clear();
		tableSale.getItems().addAll(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dao = new SaleInfoDao();
		colSaleno.setCellValueFactory(new PropertyValueFactory("sale_no"));
		colMemberno.setCellValueFactory(new PropertyValueFactory("member_no"));
		colGoodsno.setCellValueFactory(new PropertyValueFactory("goods_no"));
		colSalequa.setCellValueFactory(new PropertyValueFactory("sale_quantity"));
		colSalprice.setCellValueFactory(new PropertyValueFactory("sale_price"));
		colSaledate.setCellValueFactory(new PropertyValueFactory("sale_date"));
	}

	public String setDate(DatePicker date) {
		String dateStr = date.getEditor().getText();
		String[] tokens = dateStr.split(". ");
		int year = Integer.parseInt(tokens[0].trim());
		int month = Integer.parseInt(tokens[1].trim());
		int day = Integer.parseInt(tokens[2].trim());
		if (month < 10) {
			tokens[1] = "0" + tokens[1];
		}
		if (day < 10) {
			tokens[2] = "0" + tokens[2];
		}
		String finishDate = year + "-" + month + "-" + day;

		return finishDate;
	}

}
