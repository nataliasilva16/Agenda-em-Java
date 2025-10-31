import java.util.ArrayList;
import java.util.List;

public class Agenda {
  private List<Contato> contatos;

  public Agenda() {
    this.contatos = new ArrayList<>();
  }

  public void adicionarContato(String nome, String telefone, String email) {
    Contato novo = new Contato(nome, telefone, email);
    contatos.add(novo);
    System.out.println("✅ Contato adicionado com sucesso!");
  }

  public void listarContatos() {
    if (contatos.isEmpty()) {
      System.out.println("Nenhum contato cadastrado.");
    } else {
      System.out.println("📒 Lista de Contatos:");
      for (Contato c : contatos) {
        System.out.println(c);
      }
    }
  }

  public Contato buscarContato(String nome) {
    for (Contato c : contatos) {
      if (c.getNome().equalsIgnoreCase(nome)) {
        return c;
      }
    }
    return null;
  }

  public void atualizarContato(String nome, String novoTelefone, String novoEmail) {
    Contato contato = buscarContato(nome);
    if (contato != null) {
      if (novoTelefone != null && !novoTelefone.isEmpty()) {
        contato.setTelefone(novoTelefone);
      }
      if (novoEmail != null && !novoEmail.isEmpty()) {
        contato.setEmail(novoEmail);
      }
      System.out.println("✏️ Contato atualizado com sucesso!");
    } else {
      System.out.println("Contato não encontrado!");
    }
  }

  public void excluirContato(String nome) {
    Contato contato = buscarContato(nome);
    if (contato != null) {
      contatos.remove(contato);
      System.out.println("🗑️ Contato removido com sucesso!");
    } else {
      System.out.println("Contato não encontrado!");
    }
  }
}
