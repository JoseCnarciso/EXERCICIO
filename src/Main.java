import Models.*;
import db.EstoqueDB;
import db.PedidosDeVendasDB;
import db.ProdutosDB;
import db.UsuariosDB;
import Validadores.ValidadorPedidoVenda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Cria-se os objetos do banco de dados
    static ProdutosDB produtosDB = new ProdutosDB();
    static UsuariosDB usuariosDB = new UsuariosDB();
    static EstoqueDB estoqueDB = new EstoqueDB();
    static PedidosDeVendasDB pedidosDeVendasDB = new PedidosDeVendasDB();

    public static void main( String[] args ) throws Exception {

        System.out.println("-----------PEDIDO DE VENDAS------------");
        int option;
        do {
            System.out.println(" ");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos cadastrados");
            System.out.println("3 - Cadastrar  usuário ADMINISTRADOR ");
            System.out.println("4 - Cadastrar usuário CLIENTE");
            System.out.println("5 - Listar todos os usuários cadastrados");
            System.out.println("6 - cadastrar no estoque de produtos");
            System.out.println("7 - Listar d produtos cadastrados no estoque");
            System.out.println("8 - Criar pedido de venda");
            System.out.println("9 - Listar pedidos de venda");
            System.out.println("0 - Sair");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Qual operação deseja executar");
            option = scanner.nextInt();
            process(option);

        } while (option != 0);
    }

    public static void process( int option )throws Exception {
        switch (option){
            case 1 : {
                Scanner scanner = new Scanner(System.in);

                System.out.println("qual a descrição deseja cadastrar ao novo produto");
                String descricao = scanner.nextLine();

                System.out.println("Qual a ID deseja dar ao novo produto");
                int id = scanner.nextInt();

                System.out.println("Qual o preço:");
                double preco = scanner.nextDouble();

                System.out.println("Qual a data de validade");
                String dataString = scanner.next();

                Date dataValidade = new SimpleDateFormat("dd/MM/YYYY").parse(dataString);


                Produto novoProduto = new Produto(id, descricao, preco, dataValidade);
                produtosDB.addNovoProduto(novoProduto);
                break;

            }
            case 2 :{
                //Cria-se um objeto da classe Produto chamada "listaDeProdutos".
                List<Produto>listaDeProdutos = produtosDB.getProdutosList();

                // faz o laço de repetição onde os dados são armazenados na "listaDeProdutos"
                for (Produto produto: listaDeProdutos){

                    System.out.println("----------------------------------- ");
                    System.out.println("- ID: " + produto.getId());
                    System.out.println("- DESCRIÇÃO: " + produto.getDescrição());
                    System.out.println("- PREÇO: " + produto.getPreco());
                    System.out.println("- DATA DE VALIDADE: " + produto.getDataValidade());
                    System.out.println(" ---------------------------------------");

                }break;
            }
            case 3 :{
                Scanner scanner = new Scanner(System.in);
                System.out.print("Qual o nome do usuário ADMINISTRADOR: ");
                String nome = scanner.nextLine();

                Admin admin = new Admin(nome);
                // Anexo o novo Admim na lista.
                usuariosDB.addNovoUsuario(admin);

            }break;
            case 4:{
                Scanner scanner = new Scanner(System.in);
                System.out.print("Qual o nome do CLIENTE: ");
                String nome = scanner.nextLine();

                Cliente cliente = new Cliente(nome);
                // Anexo o novo cliente na lista.
                usuariosDB.addNovoUsuario(cliente);

            }break;
            case 5 : {
                // Chama todas as listas de usuários criadas, tanto de gerentes como de clientes.
                for (Usuario usuario: usuariosDB.getUsuarioList()){
                    System.out.println("----------------------------------------------");
                    System.out.println("===========LISTA DE USUÁRIOS CADASTRADOS================");
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("NOME " + usuario.getNome());
                    System.out.println("TIPO DE USUÁRIO: " + usuario.getTipoUsuario());
                    System.out.println("________________________________________________");
                    System.out.println("________________________________________________");
                    }break;
                }
                case 6 :{
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("---------------------------------------------------------");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("_____________CADASTRANDO ESTOQUE DE PRODUTO______________");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("---------------------------------------------------------");

                    System.out.println("Qual o identificador do estoque:");
                    String id = scanner.next();

                    System.out.println("Qual o produto que será adicionado ao estoque (informe a ID): ");
                    int produtoId = scanner.nextInt();

                    Produto produto = produtosDB.getProdutoPorID(produtoId);
                    System.out.println("PRODUTO ID: " + produto.getId());
                    System.out.println("PRODUTO DESCRIÇÃO: " + produto.getDescrição());
                    System.out.println("pRODUTO VALIDADE: " + produto.getDataValidade());

                    System.out.println("Qual a quantidade de produtos a ser adicionada ao estoque");
                    int quantidade = scanner.nextInt();
                    // cria-se o novo objeto "novoEstoque" para receber a entrada de quantidade de produtos.
                    Estoque novoEstoque = new Estoque(id,produto, quantidade);
                    //adiciono o objeto "novoEstoque" dentro do banco de dados  estoqueDB
                    estoqueDB.addNovoEstoque(novoEstoque);
                    break;
                }
            case 7: {
                for (Estoque estoque : estoqueDB.getEstoques()) {

                    System.out.println("----------------------------------- ");
                    System.out.println("-------------------LISTANDO ESTOQUE CADASTRADOS----------------");
                    // mostra em tela o ID do PRODUTO
                    System.out.println("- ID: " + estoque.getId());
                    // mostra em tela a descrição do produto(primeiro chama na lista do estoque e depois chama a desdrição)
                    System.out.println("- PRODUTO: " + estoque.getProduto().getDescrição());
                    // chama a lista do estoque e depois mostra o preço
                    System.out.println("- PREÇO: " + estoque.getProduto().getPreco());
                    // mostra a quantidade cadastrada no estoque
                    System.out.println("- QUANTIDADE: " + estoque.getQuantidade());
                    System.out.println(" ---------------------------------------");
                }break;

            }
            case 8: {
                System.out.println("---------------------------");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Informe o ID do cliente: ");
                int idCliente = scanner.nextInt();
                // instancia se a classe clinte e faz um casting chamando apenas os usuarios tipo cliente da lista
                Cliente cliente = (Cliente) usuariosDB.getUsuariosPorId(idCliente);
                System.out.println("ID: " + cliente.getId());
                System.out.println("NOME: " + cliente.getNome());
                System.out.println("TIPO: " + cliente.getTipoUsuario());
                System.out.println("----------------------------------");
                System.out.println("----------------------------------");
                System.out.println("----------------------------------");

                System.out.println("Informe o identificador do estoque: ");
                String idEstoque = scanner.next();
                Estoque estoque = estoqueDB.getEstoqueById(idEstoque);
                System.out.println("Estoque ID" + estoque.getId());
                System.out.println("Produto descrição: " + estoque.getProduto().getDescrição());
                System.out.println("Validade do produto: " + estoque.getProduto().getDataValidade());
                System.out.println("----------------------------------------------------------------");

                System.out.println("Informe a quantidade de venda: ");
                int quantidade = scanner.nextInt();

                PedidoVenda novoPedido = new PedidoVenda(cliente,estoque,quantidade);
                ValidadorPedidoVenda validadorPedidoVenda = new ValidadorPedidoVenda(novoPedido);
                if (validadorPedidoVenda.ehValido()) {
                pedidosDeVendasDB.addNovoPedido(novoPedido);
                }else {
                    System.out.println(validadorPedidoVenda.getErros());
                }
            }break;

            case 9: {
                System.out.println("-----------Listando pedidos de vendas------------");
                System.out.println("==================================================");
                for(PedidoVenda pedidoVenda: pedidosDeVendasDB.getPedidosDeVendas()){
                    System.out.println("ID: " + pedidoVenda.getId());
                    System.out.println("CLIENTE: " + pedidoVenda.getCliente());
                    System.out.println("PRODUTO: " + pedidoVenda.getEstoque().getProduto().getDescrição());
                    System.out.println("QUANTIDADE: " + pedidoVenda.getQuantidade());
                    System.out.println("======================================");
                }
            }break;
        }
    }
}



