package faceless.permisos;
import java.util.Set;

import faceless.Usuario;

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
