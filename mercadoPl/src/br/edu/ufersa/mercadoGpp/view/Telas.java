package br.edu.ufersa.mercadoGpp.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {

    public static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void setPrimaryStage(Stage primaryStage) {
        Telas.primaryStage = primaryStage;
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        setPrimaryStage(primaryStage);
        primaryStage.setTitle("Mercadinho P&L");
        primaryStage.show();
        Telas.telaLogin();

    }

    public static void telaLogin() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("loginOficial.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaCadastro() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("cadastro.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaVendaGer() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VenderGerente.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaVendaCaixa() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("venderCaixa.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaPesquisaGer() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("pesquisaGerente.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaPesquisaCaixa() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("pesquisaCaixa.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);    
    }

    public static void telaHistoricoGer() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("historicoGerente.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaHistoricoCaixa() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("historicoCaixa.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }

    public static void telaCompra() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("comprarGerente.fxml"));

        Scene cena = new Scene(root);

        primaryStage.setScene(cena);
    }
}