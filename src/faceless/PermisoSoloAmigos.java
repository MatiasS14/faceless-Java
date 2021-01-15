package faceless;

public class PermisoSoloAmigos extends Permiso{
	private Usuario usuario ;
	
	public PermisoSoloAmigos(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Boolean puedeVerPublicacion(Usuario usuario) {
		return this.usuario.esAmigoDe(usuario);  
	}
}
