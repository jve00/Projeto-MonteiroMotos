package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteTelaDadosDosUsuarios;
import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaDadosDosUsuarios extends TelaPadrao{


	private JTable tabelaUsuarios;
	private JButton btnSeta;
	private ImagemDeFundo imagem;
	private JButton btnDetalhes;
	private JComboBox<String> box;
	
	public TelaDadosDosUsuarios() {
		super("Dados dos Usuarios");
		setVisible(true);
		
	}
	public void configurarComponentes() {
		configImagemDeFundo();
		configBotoes();
		configTabela();
	}
	private void configImagemDeFundo() {
		imagem = super.configImagemDeFundo("background_2.jpg");
		add(imagem);
	}
	
	private void configBotoes() {
		OuvinteTelaDadosDosUsuarios ouvinte = new OuvinteTelaDadosDosUsuarios(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 600, 620, 200, 40, Color.white, Color.black,
				28);
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		
		
		box = new JComboBox<String>(new String[] {"Mototaxista","Passageiro"});
		box.setBounds(520, 100, 300, 40);
		box.setFont(new Font("Arial", 1, 20));
		box.setForeground(Color.black);
		box.setBackground(Color.white);
		
		btnDetalhes.addActionListener(ouvinte);
		btnSeta.addActionListener(ouvinte);
		
		btnDetalhes.addMouseListener(mouse);
		btnSeta.addMouseListener(mouse);
		
		imagem.add(btnDetalhes);
		imagem.add(box);
		imagem.add(btnSeta);
	}

	
	private void configTabela() {

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "E-MAil", "Nome Completo", "Perfil Do Usuario" });
		tabelaUsuarios = new JTable(modelo);
		tabelaUsuarios.setFont(new Font("Arial", 1, 15));


		JScrollPane scrol = new JScrollPane(tabelaUsuarios);
		scrol.getViewport().setBackground(Color.orange);
		scrol.setBounds(2, 200, 885, 400);

		imagem.add(scrol);
	}
	
	

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public JButton getBtnDetalhes() {
		return btnDetalhes;
	}

	public static void main(String[] args) {
		new TelaDadosDosUsuarios();
	}
}
