package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.passageiro.TelaDeCadastrarCorrida;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.passageiro.TelaListarCorridas;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteTelaHomePassageiro implements ActionListener {

	private TelaHomePassageiro tela;

	public OuvinteTelaHomePassageiro(TelaHomePassageiro tela) {
		this.tela = tela;

	}
	public void actionPerformed(ActionEvent evento) {
		JButton item = (JButton) evento.getSource();
		
		if(item == tela.getBtnCadastrarCorrida()){
			tela.dispose();
			new TelaDeCadastrarCorrida();
			System.out.println("clicado");
		}else if(item == tela.getBtnListarCorrida()){
			tela.dispose();
			new TelaListarCorridas();
		}
	}
}
