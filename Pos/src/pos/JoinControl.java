package pos;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import pos.dao.MemberDao;
import pos.vo.Member;

public class JoinControl {

    @FXML
    private JFXTextField txtPhone;

    @FXML
    private JFXButton btnJoin;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXTextField txtUserName;

    private MemberDao dao;

    @FXML
    void Join(ActionEvent event) {
    	dao = new MemberDao();
    	Member vo = new Member();
    	vo.setMember_name(txtUserName.getText());
    	vo.setMember_phone(txtPhone.getText());
    	vo.setMember_point(0);
    	dao.insert(vo);
    	
    	JOptionPane.showMessageDialog(null, "회원등록이 완료되었습니다.");
    	
    	Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
    }

    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) btnClose.getScene().getWindow();
		stage.close();
    }

}
