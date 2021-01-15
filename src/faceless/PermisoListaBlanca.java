package faceless;
import java.util.Set;

public class PermisoListaBlanca extends Permiso{
	private Set<Usuario> usuarios;
	
	public PermisoListaBlanca(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void incluirAListaBlanca(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public void excluirDeListaBlanca(Usuario usuario) {
		this.usuarios.remove(usuario);
	}
	
	public Boolean puedeVerPublicacion(Usuario usuario) {
		return this.usuarios.contains(usuario);
	}
}
