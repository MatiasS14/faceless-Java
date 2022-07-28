package faceless.permisos;

import faceless.Usuario;

public class PermisoPublico extends Permiso{
	public Boolean puedeVerPublicacion(Usuario usuario) {
		return true;
	}
}
