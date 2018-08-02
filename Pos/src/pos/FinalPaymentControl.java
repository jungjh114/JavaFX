package pos;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oracle.sql.DATE;
import pos.dao.GoodsDao;
import pos.dao.MemberDao;
import pos.dao.SaleInfoDao;
import pos.vo.Goods;
import pos.vo.Member;
import pos.vo.SaleInfo;

import static pos.CafeControl.x;
import static pos.CafeControl.saleList;

public class FinalPaymentControl implements Initializable {

	@FXML
	public static JFXButton btnJoin;

	@FXML
	private JFXTextField txtPhone;

	@FXML
	private JFXButton btnClose;

	@FXML
	private Label lblPoint;

	@FXML
	private TextField txtusePoint;

	@FXML
	private JFXTextField txtUserName;

	@FXML
	private JFXButton btnUsePoint;

	@FXML
	private JFXButton btnNameSelect;

	@FXML
	private Label lblCurrentAmount;

	@FXML
	private Label lblFinalPayment;

	@FXML
	private Label lblName;

	@FXML
	private JFXButton btnNumSelect;

	@FXML
	private JFXButton btnFinal;

	@FXML
	private TableColumn<Member, String> colPhone;

	@FXML
	private TableView<Member> tableMember;

	@FXML
	private TableColumn<Member, String> colMemName;

	@FXML
	private TableColumn<Member, Integer> colMemNo;

	@FXML
	private TableColumn<Member, Integer> colPoint;

	@FXML
	private JFXButton btnConn;

	private MemberDao dao;

	private GoodsDao goodsDao = new GoodsDao();

	private SaleInfoDao saleDao = new SaleInfoDao();

	@FXML
	void Join(ActionEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("join.fxml"));

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void close(ActionEvent event) {
		saleList.clear();
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
	}

	@FXML
	void finalpayment(ActionEvent event) {
		if (tableMember.getSelectionModel().getSelectedItem() != null) {
			int point = Integer.parseInt(txtusePoint.getText());
			int sumPoint = (int) (x * 0.05);
			Member vo = tableMember.getSelectionModel().getSelectedItem();
			vo.setMember_point(vo.getMember_point() - point + sumPoint);
			dao.update(vo);

			date(vo.getMember_no());
		} else {
			date(0);
		}
	}

	@FXML
	void numselect(ActionEvent event) {
		String str = txtPhone.getText();
		List<Member> list = dao.select2("%" + str + "%");
		tableMember.getItems().clear();
		tableMember.getItems().addAll(list);
	}

	@FXML
	void nameselect(ActionEvent event) {
		String str = txtUserName.getText();
		List<Member> list = dao.select1(str);
		tableMember.getItems().clear();
		tableMember.getItems().addAll(list);
	}

	@FXML
	void usePoint(ActionEvent event) {
		int total = x;
		Member vo = tableMember.getSelectionModel().getSelectedItem();
		if (vo != null) {
			int usePoint = Integer.parseInt(txtusePoint.getText());
			lblFinalPayment.setText(String.valueOf(total - usePoint));
		} else {
			JOptionPane.showMessageDialog(null, "회원이 정해지지 않았습니다.");
			txtusePoint.setText(0 + "");
		}
	}

	@FXML
	void conn(ActionEvent event) {
		Member vo = tableMember.getSelectionModel().getSelectedItem();
		lblName.setText(vo.getMember_name());
		lblPoint.setText(vo.getMember_point() + "");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblCurrentAmount.setText(x + "");
		lblFinalPayment.setText(x + "");
		dao = new MemberDao();
		colMemNo.setCellValueFactory(new PropertyValueFactory("member_no"));
		colMemName.setCellValueFactory(new PropertyValueFactory("member_name"));
		colPhone.setCellValueFactory(new PropertyValueFactory("member_phone"));
		colPoint.setCellValueFactory(new PropertyValueFactory("member_point"));
	}

	public void insertSale() {
		SaleInfo vo = new SaleInfo();
	}

	public void date(Integer num) {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String today = (new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date));

		for (int i = 0; i < saleList.size(); i++) {
			SaleInfo saleVo = new SaleInfo();
			String str = saleList.get(0).getGoods_name();
			Goods goodsVo = goodsDao.nameSelect(str);
			saleVo.setMember_no(num);
			saleVo.setGoods_no(goodsVo.getGoods_no());
			saleVo.setSale_quantity(saleList.get(i).getQuantity());
			saleVo.setSale_price(saleList.get(i).getSumPrice());
			saleVo.setSale_date(today);
			saleDao.insert(saleVo);
		}
		JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
		saleList.clear();
		Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
	}
}
