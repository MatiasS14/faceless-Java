package faceless.borrador;
import java.util.HashSet;
import faceless.Faceless;
import faceless.Usuario;

public class BorradorUsuario {
	public Faceless faceless;
	public HashSet<Usuario> amigos;
	
	public BorradorUsuario(Faceless face) {
		this.faceless = face;
		this.amigos = new HashSet<Usuario>();
	}
}
