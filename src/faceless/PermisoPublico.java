package faceless;

public class PermisoPublico extends Permiso{
	public Boolean puedeVerPublicacion(Usuario usuario) {
		return true;
	}
}
