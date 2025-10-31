import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Agenda agenda = new Agenda();
    int opcao;

    do {
      System.out.println("\n=== 📖 AGENDA DE CONTATOS ===");
      System.out.println("1 - Adicionar contato");
      System.out.println("2 - Listar contatos");
      System.out.println("3 - Buscar contato");
      System.out.println("4 - Atualizar contato");
      System.out.println("5 - Excluir contato");
      System.out.println("0 - Sair");
      System.out.print("Escolha uma opção: ");
      opcao = sc.nextInt();
      sc.nextLine(); // Limpar buffer

      switch (opcao) {
        case 1:
          System.out.print("Nome: ");
          String nome = sc.nextLine();
          System.out.print("Telefone: ");
          String telefone = sc.nextLine();
          System.out.print("Email: ");
          String email = sc.nextLine();
          agenda.adicionarContato(nome, telefone, email);
          break;

        case 2:
          agenda.listarContatos();
          break;

        case 3:
          System.out.print("Digite o nome do contato: ");
          String nomeBusca = sc.nextLine();
          Contato encontrado = agenda.buscarContato(nomeBusca);
          if (encontrado != null) {
            System.out.println("🔎 Contato encontrado: " + encontrado);
          } else {
            System.out.println("Contato não encontrado.");
          }
          break;

        case 4:
          System.out.print("Digite o nome do contato para atualizar: ");
          String nomeAtualizar = sc.nextLine();
          System.out.print("Novo telefone (ou Enter para manter): ");
          String novoTel = sc.nextLine();
          System.out.print("Novo email (ou Enter para manter): ");
          String novoEmail = sc.nextLine();
          agenda.atualizarContato(nomeAtualizar, novoTel, novoEmail);
          break;

        case 5:
          System.out.print("Digite o nome do contato para excluir: ");
          String nomeExcluir = sc.nextLine();
          agenda.excluirContato(nomeExcluir);
          break;

        case 0:
          System.out.println("Encerrando a agenda... 👋");
          break;

        default:
          System.out.println("Opção inválida! Tente novamente.");
      }

    } while (opcao != 0);

    sc.close();
  }
}
