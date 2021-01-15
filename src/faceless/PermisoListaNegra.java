package faceless;
import java.util.Set;

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
