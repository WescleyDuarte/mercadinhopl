package br.edu.ufersa.mercadoGpp.view;

import javax.swing.JOptionPane;

import br.edu.ufersa.mercadoGpp.exception.AuthException;
import br.edu.ufersa.mercadoGpp.model.BO.GerenteBO;
import br.edu.ufersa.mercadoGpp.model.BO.ItemVendaBO;
import br.edu.ufersa.mercadoGpp.model.BO.TipoBO;
import br.edu.ufersa.mercadoGpp.model.BO.VendaBO;
import br.edu.ufersa.mercadoGpp.model.DAO.ProdutoDAO;
import br.edu.ufersa.mercadoGpp.model.DAO.TipoDAO;
import br.edu.ufersa.mercadoGpp.model.VO.CaixaVO;
import br.edu.ufersa.mercadoGpp.model.VO.GerenteVO;
import br.edu.ufersa.mercadoGpp.model.VO.ItemVendaVO;
import br.edu.ufersa.mercadoGpp.model.VO.ProdutoVO;
import br.edu.ufersa.mercadoGpp.model.VO.TipoVO;
import br.edu.ufersa.mercadoGpp.model.VO.UsuarioVO;
import br.edu.ufersa.mercadoGpp.model.VO.VendaVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controleps2 {

    VendaVO vendaVO = new VendaVO();
    // VendaBO vendaBO = new VendaBO();
    ItemVendaVO itemVO = new ItemVendaVO();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    GerenteBO gerenteBO = new GerenteBO();

    TipoVO tipoVO = new TipoVO();
    TipoBO tipoBO = new TipoBO();
    TipoDAO tipoDAO = new TipoDAO();
    ProdutoVO produtoVO = new ProdutoVO();


    //Login
    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    //criar um label não visível para a mensagem de erro de login

    @FXML
    public void entrar(ActionEvent event) throws Exception {

        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setLogin(login.getText());
        usuarioVO.setSenha(senha.getText());

        try {
            UsuarioVO usuOk = new UsuarioVO();
            if(usuOk instanceof CaixaVO) {
                Telas.telaVendaCaixa();
            }
            else {
                Telas.telaVendaGer();
            }
        } catch (AuthException e) {
            //passa a mensagem de erro de login e torna o label visível
        }
    }

    //Cadastro
    @FXML
    private TextField loginCadastro;

    @FXML
    private TextField nomeCadastro;

    @FXML
    private TextField sexoCadastro;

    @FXML
    private TextField idadeCadastro;

    @FXML
    private TextField salarioCadastro;

    @FXML
    private TextField cargoCadastro;

    @FXML
    private TextField idUsuarioCadastro;

    @FXML
    private PasswordField senhaCadastro;

    @FXML
    void Voltar(ActionEvent event) throws Exception {
        Telas.telaVendaGer();
    }

    @FXML
    void alterarU(ActionEvent event) {

    }

    @FXML
    void cadastrarU(ActionEvent event) {
        if(cargoCadastro.getText().equalsIgnoreCase("Gerente")) {
            GerenteVO gerente = new GerenteVO();
            gerente.setLogin(loginCadastro.getText());
            gerente.setSenha(senhaCadastro.getText());
            gerente.setNome(nomeCadastro.getText());
            gerente.setSexo(sexoCadastro.getText());
            gerente.setIdade(Integer.parseInt(idadeCadastro.getText()));
            gerenteBO.cadastrarGerente(gerente);
        }
        else {

        }
    }

    @FXML
    void deletarU(ActionEvent event) {

    }

    //Vender Gerente kekw
    @FXML
    private TextField codigoProdutoParaVenda;

    @FXML
    private TextField quantidadeDoProdutoParaVenda;

    @FXML
    private Label verValorTotal;

    @FXML
    private TableColumn<ItemVendaVO, Integer> codigoPV;

    @FXML
    private TableColumn<ItemVendaVO, String> nomePV;

    @FXML
    private TableColumn<ItemVendaVO, String> descricaoPV;

    @FXML
    private TableColumn<ItemVendaVO, TipoVO> tipoPV;

    @FXML
    private TableColumn<ItemVendaVO, Integer> quantidadePV;

    @FXML
    private TableColumn<ItemVendaVO, Float> valorUnidadePV;

    @FXML
    void adicionarAVenda(ActionEvent event) {

        ItemVendaVO itemVO = new ItemVendaVO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        itemVO.setProduto(produtoDAO.buscarProdutoPorCodigo(Integer.parseInt(codigoProdutoParaVenda.getText())));
        

        try {

            itemVO.setQuantidade(Integer.parseInt(quantidadeDoProdutoParaVenda.getText()));
            ItemVendaBO itemBO = new ItemVendaBO();
            vendaVO.setItemVenda(itemBO.adicionarItemVenda(itemVO));
            vendaVO.setValorTotal(itemVO.getProduto().getValor() * itemVO.getQuantidade());

            codigoPV.setCellValueFactory(new PropertyValueFactory<>("codigoPT"));
            nomePV.setCellValueFactory(new PropertyValueFactory<>("nomePT"));
            descricaoPV.setCellValueFactory(new PropertyValueFactory<>("descricaoPT"));
            tipoPV.setCellValueFactory(new PropertyValueFactory<>("tipoPT"));
            quantidadePV.setCellValueFactory(new PropertyValueFactory<>("quantidadePT"));
            valorUnidadePV.setCellValueFactory(new PropertyValueFactory<>("valorUniPT"));
            verValorTotal.setText(String.valueOf(vendaVO.getValorTotal()));


        } catch (Exception e) {
            
        }
    }

    @FXML
    void removerDaVenda(ActionEvent event) {

    }

    @FXML
    void tabelaVenda(ActionEvent event) {

    }

    @FXML
    void vender(ActionEvent event) {

        vendaVO.setCodigo(vendaBO.gerarCodigo());
        vendaBO.cadastrar(vendaVO);

    }

    
    @FXML
    void adicionarPVendaG(ActionEvent event) {

    }

    @FXML
    void removerPVenderG(ActionEvent event) {

    }

    //Historico Gerente

    @FXML
    private MenuBar menuBarGerente;

    @FXML
    private Menu venderMenuG;

    @FXML
    private Menu produtosMenuG;

    @FXML
    private Menu historicoMenuG;

    @FXML
    private Menu comprarMenuG;

    @FXML
    private Menu cadastrarMenuG;

    @FXML
    private TableView<?> tabelaPdaNFHG;

    @FXML
    private TableColumn<?, ?> codigoPTHG;

    @FXML
    private TableColumn<?, ?> nomePHG;

    @FXML
    private TableColumn<?, ?> descricaoPHG;

    @FXML
    private TableColumn<?, ?> quantidadePTHG;

    @FXML
    private TableColumn<?, ?> valorUnidadePHG;

    @FXML
    private TableView<?> tabelanNFG;

    @FXML
    private TableColumn<?, ?> nNFG;

    @FXML
    private TextField pesquisarNNFHG;

    @FXML
    private TextField nNFHG;

    @FXML
    private TextField codigoPHG;

    @FXML
    private TextField quantidadePHG;

    @FXML
    void adicionarPHG(ActionEvent event) {

    }

    @FXML
    void cancelarNFHG(ActionEvent event) {

    }

    @FXML
    void gerarNNFHG(ActionEvent event) {

    }

    @FXML
    void retirarPHG(ActionEvent event) {

    }



    
	//Pesquisar produtos (cadastrar tipo e produto)

    @FXML
    private TableView<?> tabelaProdutosG;

    @FXML
    private TableColumn<?, ?> codigoPTG;

    @FXML
    private TableColumn<?, ?> nomePTG;

    @FXML
    private TableColumn<?, ?> descricaoPTG;

    @FXML
    private TableColumn<?, ?> tipoPTG;

    @FXML
    private TableColumn<?, ?> quantidadePTG;

    @FXML
    private TableColumn<?, ?> valorUnidadePTG;

    @FXML
    private TextField pesquisarPorProdutoG;

    @FXML
    private TextField nomeDoTipo;

    @FXML
    private TextField formaDeVenda;

    @FXML
    private TextField codigoDoTipo;

    @FXML
    private TextField descricaoProduto;

    @FXML
    private TextField marcaDoProduto;

    @FXML
    private TextField quantidadeDoProduto;

    @FXML
    private TextField valorUnidadeDoProduto;

    @FXML
    private TextField setorDoProduto;

    @FXML
    private TextField tipoDoProduto;

    @FXML
    private TextField codigoDoProduto;

    
        // Area do Tipo
    @FXML
    void alterarTipo(ActionEvent event) {

        int i=(Integer.parseInt(codigoDoTipo.getText()));
        if(tipoDAO.buscarTipoPorCod(i)!=null){
            tipoVO.setCodigo(i);
            tipoVO.setFormaDeVenda(formaDeVenda.getText());
            tipoVO.setNome(nomeDoTipo.getText());

            tipoBO.alterar(tipoDAO.buscarTipoPorCod(i));
        }else{
            JOptionPane.showMessageDialog(null, "Codigo do Tipo não encontrado");          
        }   
  
    }
            
    @FXML
    void deletarTipo(ActionEvent event) {

        tipoBO.deletar(Integer.parseInt(codigoDoTipo.getText()));
    }

    @FXML
    void cadastrarTipo(ActionEvent event) {

        tipoVO.setNome(nomeDoTipo.getText());
        tipoVO.setFormaDeVenda(formaDeVenda.getText());

        tipoVO.setCodigo(tipoBO.gerarCodigo());

        tipoBO.cadastrarTipo(tipoVO);
    }


            // Area do Produto
    @FXML
    void cadastarProduto(ActionEvent event) {

        produtoVO.setDescricao(descricaoProduto.getText());
        produtoVO.setMarca(marcaDoProduto.getText());
        produtoVO.setQuantidade(Integer.parseInt(quantidadeDoProduto.getText()));
        produtoVO.setSetor(setorDoProduto.getText());
        produtoVO.setTipo(tipoDAO.buscarTipo(tipoDoProduto.getText()));
        produtoVO.setValor(Float.parseFloat(valorUnidadeDoProduto.getText()));

    }

    @FXML
    void deletarProduto(ActionEvent event) {


    }

    @FXML
    void alterarProduto(ActionEvent event) {

    }


    //Comprar Gerente
    @FXML
    private TextField codigoPComprarG;

    @FXML
    private TextField quantidadePComprarG;

    @FXML
    private TableView<?> tabelaCompraG;

    @FXML
    private TableColumn<?, ?> codigoPCompraG;

    @FXML
    private TableColumn<?, ?> nomePCompraG;

    @FXML
    private TableColumn<?, ?> descricaoPCompraG;

    @FXML
    private TableColumn<?, ?> tipoPCompraG;

    @FXML
    private TableColumn<?, ?> quantidadePCompraG;

    @FXML
    private TableColumn<?, ?> valorUniCompraG;

    @FXML
    void adicionarPCompraG(ActionEvent event) {

    }

    @FXML
    void comprar(ActionEvent event) {

    }

    @FXML
    void removerPCompraG(ActionEvent event) {

    }

    //Vender Caixa
    @FXML
    private TextField codigoVC;

    @FXML
    private TextField quantidadeVC;

    @FXML
    private TableView<?> tabelaVC;

    @FXML
    private TableColumn<?, ?> codigoTV;

    @FXML
    private TableColumn<?, ?> nomeTV;

    @FXML
    private TableColumn<?, ?> descricaoTV;

    @FXML
    private TableColumn<?, ?> tipoTV;

    @FXML
    private TableColumn<?, ?> quantidadeTV;

    @FXML
    private TableColumn<?, ?> valoruniTV;

    @FXML
    void adicionarVC(ActionEvent event) {

        itemVO.setProduto(produtoDAO.buscarProdutoPorCodigo(Integer.parseInt(codigoProdutoParaVenda.getText())));
        

        try {

            itemVO.setQuantidade(Float.parseFloat(quantidadeDoProdutoParaVenda.getText()));
            ItemVendaBO itemBO = new ItemVendaBO();
            vendaVO.setItemVenda(itemBO.adicionarItemVenda(itemVO));
            vendaVO.setValorTotal(itemVO.getProduto().getValor() * itemVO.getQuantidade());

            codigoPV.setCellValueFactory(new PropertyValueFactory<>("codigoPT"));
            nomePV.setCellValueFactory(new PropertyValueFactory<>("nomePT"));
            descricaoPV.setCellValueFactory(new PropertyValueFactory<>("descricaoPT"));
            tipoPV.setCellValueFactory(new PropertyValueFactory<>("tipoPT"));
            quantidadePV.setCellValueFactory(new PropertyValueFactory<>("quantidadePT"));
            valorUnidadePV.setCellValueFactory(new PropertyValueFactory<>("valorUniPT"));
            verValorTotal.setText(String.valueOf(vendaVO.getValorTotal()));


        } catch (Exception e) {
            
        }
    }

    @FXML
    void removerVC(ActionEvent event) {
        itemVO.setProduto(produtoDAO.buscarProdutoPorCodigo(Integer.parseInt(codigoVC.getText())));
        itemVO.setQuantidade(Float.parseFloat(quantidadeVC.getText()));

        vendaVO.setItemVenda(vendaBO.removerItem(vendaVO.getItemVenda(), itemVO));
    }

    @FXML
    void venderC(ActionEvent event) {

    }

    //Historico Caixa
    @FXML
    private TableView<?> tabelaNFC;

    @FXML
    private TableColumn<?, ?> codigoPnaNFC;

    @FXML
    private TableColumn<?, ?> nomePnaNFC;

    @FXML
    private TableColumn<?, ?> descricaoPnaNFC;

    @FXML
    private TableColumn<?, ?> quantidadePnaNFC;

    @FXML
    private TableColumn<?, ?> valorunidadePnaNFC;

    @FXML
    private TableView<?> tabelaNNFC;

    @FXML
    private TableColumn<?, ?> nNFC;

    @FXML
    private TextField pesquisarNFHC;

    @FXML
    private TextField nNFHC;

    @FXML
    private TextField codigoPHC;

    @FXML
    private TextField quantidadePHC;

    @FXML
    private PasswordField senhaGerenteHC;

    @FXML
    void adicionarPnaNFC(ActionEvent event) {

    }

    @FXML
    void cancelarNFC(ActionEvent event) {

    }

    @FXML
    void gerarNFC(ActionEvent event) {

    }

    @FXML
    void retirarPnaNFC(ActionEvent event) {

    }


    // MUDEI AQUI R


    //Produtos Caixa...(ver as opções de menu) .:OBS produtos caixa é pesquisarCaixafxml
    @FXML
    private TextField pesquisarProdutoPorNomeOuCodC;

    @FXML
    private TableColumn<ProdutoVO,Integer> codPC;

    @FXML
    private TableColumn<ProdutoVO, String> nomePC;

    @FXML
    private TableColumn<ProdutoVO, String> descricaoPC;

    @FXML
    private TableColumn<ProdutoVO, String> tipoPC;

    @FXML
    private TableColumn<ProdutoVO, Float> quantidadePC;

    @FXML
    private TableColumn<ProdutoVO, Float> valorUniPC;

    

    //Telas Caixa
    @FXML
    void historicoCaixaMenu(ActionEvent event) throws Exception {
        Telas.telaHistoricoCaixa();
    }

    @FXML
    void produtosCaixaMenu(ActionEvent event) throws Exception {
        Telas.telaPesquisaCaixa();
    }

    @FXML
    void venderCaixaMenu(ActionEvent event) throws Exception {
        Telas.telaVendaCaixa();
    }

    //Telas Gerente
    @FXML
    void telaCadastrarFuncionario(ActionEvent event) throws Exception {
        Telas.telaCadastro();
    }

    @FXML
    void telaComprarG(ActionEvent event) throws Exception {
        Telas.telaCompra();
    }

    @FXML
    void telaProdutosG(ActionEvent event) throws Exception {
        Telas.telaPesquisaGer();
    }

    @FXML
    void telaVenderG(ActionEvent event) throws Exception {
        Telas.telaVendaGer();
    }

    @FXML
    void telasHistoricoG(ActionEvent event) throws Exception {
        Telas.telaHistoricoGer();
    }

    //Logout
    @FXML
    void sair(ActionEvent event) throws Exception {
        Telas.telaLogin();
    }
    
}