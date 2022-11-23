package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteMenuTelaHome implements ActionListener {

  private TelaHomeMototaxista tela;

	public OuvinteMenuTelaHome(TelaHomeMototaxista tela) {
		this.tela = tela;
	}

  public void actionPerformed(ActionEvent e) {
    JMenuItem item = (JMenuItem) e.getSource();

    if(item == tela.getItemEditar()) {
      tela.dispose();
      new TelaEdicaoPerfil();
    }else if(item == tela.getItemDeletar()) {
      int opcDeletar = FabricaJOptionPane.criarMsgDeOpcao("Escolha uma opção", "Deseja deletar sua conta?");
			if (opcDeletar == 0)
				System.out.println("Deletar a conta");
    }else {
      int opcSair = FabricaJOptionPane.criarMsgDeOpcao("Escolha uma opção", "Deseja sair?");
      tela.dispose();
      new TelaLogin();
    }
  }
  
}