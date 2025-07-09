package com.example;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {
    private static TableView<NhanVien> tvNhanVien;
    private static ObservableList<NhanVien> dataNhanVien = FXCollections.observableArrayList(); 

    private static DBConnnection db = new DBConnnection();
    private static Connection connect = db.getConnection();

    @Override
    public void start(Stage stage) {
        BorderPane masterLayout = new BorderPane();
        Button btnCheckCon = new Button("Kiểm tra kết nối");

        masterLayout.setTop(btnCheckCon);
        Alert thongbao = new Alert(Alert.AlertType.INFORMATION);
        thongbao.setTitle("Thông báo");
        btnCheckCon.setOnAction((t) -> {
            if (connect != null) {
                thongbao.setContentText("Kết nối MySQL thành công");
                thongbao.show();
            } else {
                thongbao.setContentText("Kết nối MySQL thất bại");
                thongbao.show();
            }
        });

        masterLayout.setCenter(createTableViewNhanVien());
        var scene = new Scene(masterLayout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static StackPane createTableViewNhanVien() {
        StackPane layout = new StackPane();

        tvNhanVien = new TableView<>();
        TableColumn<NhanVien, String> colMa = new TableColumn<>("Mã nhân viên");
        colMa.setCellValueFactory(new PropertyValueFactory<>("ma"));

        TableColumn<NhanVien, String> colTen = new TableColumn<>("Tên nhân viên");
        colTen.setCellValueFactory(new PropertyValueFactory<>("ten"));

        TableColumn<NhanVien, String> colNamsinh = new TableColumn<>("Năm sinh");
        colNamsinh.setCellValueFactory(new PropertyValueFactory<>("namsinh"));

        TableColumn<NhanVien, String> colSongayLV = new TableColumn<>("Số ngày làm việc");
        colSongayLV.setCellValueFactory(new PropertyValueFactory<>("songayLV"));

        TableColumn<NhanVien, Float> colLuongCB = new TableColumn<>("Lương cơ bản");
        colLuongCB.setCellValueFactory(new PropertyValueFactory<>("luongCB"));

        tvNhanVien.getColumns().addAll(colMa, colTen, colNamsinh, colSongayLV, colLuongCB);
        
        loadDataNhanVien();
        layout.getChildren().add(tvNhanVien);
        return layout;
    }
    
    public static void loadDataNhanVien() {
        try {
            if(connect != null) {
                String sql = "select * from nhanvien";
                Statement stm = connect.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    dataNhanVien.add(new NhanVien(
                        rs.getString("ma"),
                        rs.getString("ten"),
                        rs.getString("namsinh"),
                        rs.getString("songayLV"),
                        rs.getFloat("luongCB")
                    ));
                }
                tvNhanVien.setItems(dataNhanVien);
            }
        }
        catch (Exception ex){

        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}