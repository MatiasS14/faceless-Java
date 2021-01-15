package faceless;
import java.util.Set;
import java.util.HashSet;


public class Faceless {
	private Set<Publicacion> publicaciones;
	private Set<Usuario>     usuarios     ;
	
	public Faceless() {
		this.publicaciones = new HashSet<Publicacion>();
		this.usuarios      = new HashSet<Usuario>()    ;
	}
	
	public Set<Usuario> usuarios(){
		return this.usuarios;
	}
	
	public void recibirPublicacion(Publicacion pub) {
		this.publicaciones.add(pub);
	}
	
	public void nuevoUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void bajaDeUsuario(Usuario usuario) {
		this.usuarios.remove(usuario);
	}
	
	public Set<Publicacion> publicacionesUsuario(Usuario usuario){
		Set<Publicacion> ret = new HashSet<Publicacion>();
		for(Publicacion pub : this.publicaciones) {
			if(pub.usuario() == usuario) {
				ret.add(pub);
			}
		}
		
		return ret;
	}
	
	public Boolean usuarioMasAmistosoQueUsuario2(Usuario us1, Usuario us2) {
		return us1.esMasAmistosoQue(us2);
	}
}
