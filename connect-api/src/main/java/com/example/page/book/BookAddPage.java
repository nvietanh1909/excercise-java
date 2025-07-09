package com.example.page.book;

import com.example.api.BookAPI;
import com.example.model.BookModel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class BookAddPage {
    private final String token;
    private final BookAPI bookAPI;

    public BookAddPage(String token) {
        this.token = token;
        this.bookAPI = new BookAPI(token);
    }

    public void show(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        int row = 0;
        TextField titleField = new TextField();
        TextField authorsField = new TextField();
        TextField descField = new TextField();
        TextField categoryField = new TextField();
        TextField quantityField = new TextField();
        TextField publisherField = new TextField();
        TextField priceField = new TextField();
        TextField publishedDateField = new TextField();
        TextField languageField = new TextField();
        TextField isbnField = new TextField();
        TextField pageField = new TextField();
        Label imageLabel = new Label("Chưa chọn ảnh");
        Button btnChooseImage = new Button("Chọn ảnh");
        FileChooser fileChooser = new FileChooser();
        final File[] imageFile = {null};
        btnChooseImage.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                imageFile[0] = file;
                imageLabel.setText(file.getName());
            }
        });
        grid.add(new Label("Tiêu đề:"), 0, row); grid.add(titleField, 1, row++);
        grid.add(new Label("Tác giả (phân cách dấu phẩy):"), 0, row); grid.add(authorsField, 1, row++);
        grid.add(new Label("Mô tả:"), 0, row); grid.add(descField, 1, row++);
        grid.add(new Label("Thể loại:"), 0, row); grid.add(categoryField, 1, row++);
        grid.add(new Label("Số lượng:"), 0, row); grid.add(quantityField, 1, row++);
        grid.add(new Label("Nhà xuất bản:"), 0, row); grid.add(publisherField, 1, row++);
        grid.add(new Label("Giá:"), 0, row); grid.add(priceField, 1, row++);
        grid.add(new Label("Ngày xuất bản:"), 0, row); grid.add(publishedDateField, 1, row++);
        grid.add(new Label("Ngôn ngữ:"), 0, row); grid.add(languageField, 1, row++);
        grid.add(new Label("ISBN:"), 0, row); grid.add(isbnField, 1, row++);
        grid.add(new Label("Số trang:"), 0, row); grid.add(pageField, 1, row++);
        grid.add(new Label("Ảnh bìa:"), 0, row); grid.add(imageLabel, 1, row); grid.add(btnChooseImage, 2, row++);
        Button btnSave = new Button("Lưu");
        Button btnBack = new Button("Quay lại");
        Label messageLabel = new Label();
        grid.add(btnSave, 1, row); grid.add(btnBack, 2, row); grid.add(messageLabel, 1, row + 1);

        btnSave.setOnAction(e -> {
            try {
                int quantity;
                double price;
                try {
                    quantity = Integer.parseInt(quantityField.getText());
                    price = Double.parseDouble(priceField.getText());
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Số lượng và giá phải là số!");
                    return;
                }
                BookModel book = new BookModel();
                book.setTitle(titleField.getText());
                book.setAuthors(Arrays.asList(authorsField.getText().split(",")));
                book.setDescription(descField.getText());
                book.setCategory(categoryField.getText());
                book.setQuantity(quantity);
                book.setPublisher(publisherField.getText());
                book.setPrice(price);
                book.setPublishedDate(publishedDateField.getText());
                book.setLanguage(languageField.getText());
                book.setIsbn(isbnField.getText());
                book.setPage(pageField.getText());
                if (imageFile[0] != null) {
                    boolean ok = bookAPI.addBook(book, imageFile[0].toPath());
                    if (ok) {
                        messageLabel.setText("Thêm sách thành công!");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        btnBack.setOnAction(e -> stage.close());
        stage.setScene(new Scene(grid, 600, 600));
        stage.setTitle("Thêm sách mới");
        stage.show();
    }
} 