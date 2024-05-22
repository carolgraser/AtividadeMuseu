import java.io.IOException;

public class Sistema {

    private static void exibirMenu() {

        System.out.println("\nGERENCIADOR DE OBRAS DE ARTE");
        System.out.println("1) Cadastrar Obra");
        System.out.println("2) Buscar simplificada");
        System.out.println("3) Busca avançada");
        System.out.println("4) Listar todas");
        System.out.println("5) Atualizar informações");
        System.out.println("6) Excluir obra do sistema");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");

    }

    private static void verificarOpcao(int op) {

        switch (op) {
            case 1:

                salvarObra();
                break;

            case 2:

                buscarObra();
                break;

            case 3:

                System.out.println("Busca avançada:");
                System.out.println("1) Pintura");
                System.out.println("2) Fotografia");
                System.out.println("3) Escultura");
                System.out.println("0) Sair");
                System.out.println("Sua opção: ");

                break;

            
            case 4:

                listarTodas();
                break;

            case 5:

                alterarObra();
                break;

            case 6:

                apagarJogo();
                break;

            case 0: 
                System.out.println("\nO programa foi finalizado...");
                break;
        
            default:
                System.out.println("\nOpção inválida! Digite novamente:");
                break;
        }

    }

    //CADASTRAR OBRA
    private static void salvarObra(int op) {

        System.out.println("\nCadastro de Obra:");
        
        System.out.print("Título: ");
        int titulo = Console.lerInt();

        System.out.print("Artista ");
        String artista = Console.lerString();

        System.out.print("Ano de criação: ");
        int ano = Console.lerInt();

        System.out.print("Localização no Museu: ");
        String local = Console.lerString();

        System.out.print("Tipo de obra: ");
        System.out.println("1) Pintura");
        System.out.println("2) Fotografia");
        System.out.println("3) Escultura");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");            
        
        switch (op) {

            case 1:
                
                System.out.print("Técnica pintura: ");
                String tecnicaPintura = Console.lerString();
                break;

            case 2:

                System.out.print("Técnica utilizada: ");
                String tecnicaFoto = Console.lerString();
                break;

            case 3:

                System.out.print("Material utilizado: ");
                String materialEscult = Console.lerString();
                break;
        
            default:
            break;
        }


        Obra obra = new Obra(local, artista, ano, local, local);

        try {

            GerenciadorObras.salvarObra(obra);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }


    }

    //BUSCAR OBRA
    private static void buscarObraArt() {

        System.out.println("\nBuscar Obra");
        System.out.print("Informe o nome do artista: ");
        String artista = Console.lerString();

        try {

            Obra obra = GerenciadorObras.buscarObraArt(artista);
            System.out.println("\nObra encontrada: " + obra);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }


    private static void buscarObraAno() {

        System.out.println("\nBuscar Obra");
        System.out.print("Informe o ano de criação: ");
        int ano = Console.lerInt();

        try {

            Obra obra = GerenciadorObras.buscarObraAno(ano);
            System.out.println("\nObra encontrada: " + obra);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void buscarObraTipo() {

        System.out.println("\nBuscar Obra");
        System.out.print("Informe o ano de criação: ");
        int ano = Console.lerInt();

        try {

            Obra obra = GerenciadorObras.buscarObraArt(ano);
            System.out.println("\nObra encontrada: " + obra);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void listarTodos() {

        System.out.println("\nJogos Cadastrados:");

        try {

            for (Jogo tempJogo : GerenciadorJogos.listarJogos())
            {
                System.out.println(tempJogo);
            }
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void apagarJogo() {

        System.out.println("\nApagar Jogo");
        System.out.print("Informe o código do jogo que deseja apagar: ");
        int codigo = Console.lerInt();

        try {

            GerenciadorJogos.apagarJogo(codigo);
            System.out.println("\nJogo excluído com sucesso!");
        
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }

    public static void executar() {

        int op;
        do {
            
            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);

        } while(op != 0);

    }


    
}