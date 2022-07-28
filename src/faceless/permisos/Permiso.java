package faceless.permisos;

import faceless.Usuario;

public abstract class Permiso {
	public abstract Boolean puedeVerPublicacion(Usuario usuario) ;
}
