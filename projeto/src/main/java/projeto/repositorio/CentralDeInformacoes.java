package projeto.repositorio;

import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import projeto.excecoes.usuario.UsuarioJaExisteException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Corrida;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.servico.ServicoCorrida;
import projeto.servico.ServicoPassageiro;
import projeto.servico.ServicoUsuario;
import utilidades.fabricas.FabricaJOptionPane;

public class CentralDeInformacoes {

	private ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
	private ArrayList<Corrida> corridas = new ArrayList<Corrida>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	private ServicoPassageiro servicoPassageiro = new ServicoPassageiro(this);
	private ServicoCorrida servicoCorrida = new ServicoCorrida(this, servicoPassageiro);
	private ServicoUsuario servicoUsuario = new ServicoUsuario(this);

	public CentralDeInformacoes() {
		XStream xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
	}
	
	public boolean adicionarUsuario(Usuario usuario) {
		try {
			return servicoUsuario.adicionarUsuario(usuario);			
		} catch (UsuarioJaExisteException e) {
			FabricaJOptionPane.criarMsgErro(e.getMessage());
			return false;
		}
	}
	
	public Usuario recuperarUsuarioPeloEmail(String email) {
		try {
			return servicoUsuario.recuperarUsuarioPeloEmail(email);
		} catch (UsuarioNaoExisteException e) {
			FabricaJOptionPane.criarMsgErro(e.getMessage());
			return null;
		}
	}
	
	public boolean adicionarPassageiro(Passageiro passageiro) {
		return servicoPassageiro.adicionarPassageiro(passageiro);
	}

	public Passageiro recuperarPassageiroPeloEmail(String email) {
		return servicoPassageiro.recuperarPassageiroPeloEmail(email);
	}

	public boolean adicionarCorrida(Corrida corrida) {
		return servicoCorrida.adicionarCorrida(corrida);
	}

	public Corrida recuperarCorridaPeloId(long id) {
		return servicoCorrida.recuperarCorridaPeloId(id);
	}

	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email) {
		return servicoCorrida.recuperarCorridasDeUmPassageiro(email);
	}

	public int recuperarNumeroCorridasDeUmPassageiro(String email) {
	    return servicoCorrida.recuperarCorridasDeUmPassageiro(email).size();
	  }

	public ArrayList<Passageiro> getPassageiros() {
		return passageiros;
	}

	public ArrayList<Corrida> getCorridas() {
		return corridas;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

}
