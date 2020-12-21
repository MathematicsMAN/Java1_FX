package sample;

import javafx.fxml.FXML;
        import javafx.scene.control.*;

public class Controller {
    final private int numberTries = 3;
    GuessTheNumber guess = new GuessTheNumber(numberTries);

    @FXML
    private TextField numberInputField;

    @FXML
    private Label randomNumberLabel;

    @FXML
    private Label compareNumber;

    @FXML
    public void initialize(){
        compareNumber.setVisible(false);
        randomNumberLabel.setText("0");
        numberInputField.setText("");
    }

    @FXML
    void doRandomAction() {
        String tryNumber = numberInputField.getText();
        numberInputField.clear();

        if (!tryNumber.isBlank()) {
            try {
                if(guess.getAttempts() != 0){
                    int number = Integer.parseInt(tryNumber);
                    randomNumberLabel.setText(String.valueOf(number));
                    switch (guess.guess(number)) {
                        case -1 -> compareNumber.setText("меньше загаданного");
                        case 0 -> compareNumber.setText("правильное. Вы угадали!");
                        case 1 -> compareNumber.setText("больше загаданного");
                    }
                    guess.decreaseAttempts();
                    compareNumber.setVisible(true);
                }else{
                    var alert = new Alert(Alert.AlertType.INFORMATION,"Попытки исчерпаны!");
                    alert.setTitle("Конец игры");
                    alert.show();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                var alert = new Alert(Alert.AlertType.ERROR,"Введите число!");
                alert.setTitle("Ошибка ввода данных");
                alert.show();
            }
        }
    }

    @FXML
    void doReloadGame() {
        initialize();
        guess.reload(numberTries);
    }

}
