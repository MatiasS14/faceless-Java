package faceless.permisos;
import java.util.Set;

import faceless.Usuario;

public class PermisoListaNegra extends Permiso{
	private Set<Usuario> listaNegra;
	
	public PermisoListaNegra(Set<Usuario> listaNegra) {
		this.listaNegra = listaNegra;
	}
	public void incluirAListaNegra(Usuario usuario) {
		this.listaNegra.add(usuario);
	}

	public void excluirDeListaNegra(Usuario usuario) {
		this.listaNegra.remove(usuario);
	}
	
	public Boolean puedeVerPublicacion(Usuario usuario) {
		return ! this.listaNegra.contains(usuario);
	}
}
