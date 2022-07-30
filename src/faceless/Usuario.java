package faceless;
import java.util.Set;

import faceless.borrador.BorradorUsuario;

import java.util.HashSet;

public class Usuario {
	private Faceless faceless;
	private MeGusta meGusta;
	private Set<Usuario> amigos ;
	
	//CAMBIAR EL USUARIO??
	public Usuario(BorradorUsuario usuario) {
		this.faceless = usuario.faceless;
		this.meGusta= new MeGusta(this);
		this.amigos = usuario.amigos;
		this.faceless.nuevoUsuario(this);
	}
	
	public void realizarPublicacion(Publicacion pub) {
		this.faceless.recibirPublicacion(pub);
	}
	
	public void darMeGusta(Publicacion pub) {
		if(pub.dejarVerPublicacion(this)) {
		pub.recibirMeGusta(this.meGusta);
		}else {
			throw new RuntimeException("No tienes permiso para acceder a esta publicacion");
		}
	}
	public Integer cantidadAmigos() {
		return this.amigos.size();
	}
	
	public Boolean esMasAmistosoQue(Usuario usuario) {
		return this.cantidadAmigos() > usuario.cantidadAmigos();
	}
	
	public void agregarAmigo(Usuario usuario) {
		this.amigos.add(usuario);
	}
	
	public void eliminarAmigo(Usuario usuario) {
		this.amigos.remove(usuario);
	}
	
	public Set<Publicacion> publicacionesHechas(){
		return this.faceless.publicacionesUsuario(this);
	}
	
	public Integer pesoPublicaciones() {
		Integer ret = 0;
		for(Publicacion pub : this.publicacionesHechas()) {
			ret+= pub.peso();
		}
		return ret;
	}
	
	public Integer meGustaRecibidos() {
		Integer ret = 0;
		for(Publicacion pub : this.publicacionesHechas()) {
			ret += pub.cantidadMeGusta();
		}
		return ret;
	}
	
	public Usuario amigoMasPopular() {
		Usuario ret = null;
		for(Usuario amigo : this.amigos) {
			if(ret==null) {
				ret=amigo;
					}
			if(amigo.meGustaRecibidos() > ret.meGustaRecibidos()) {
				ret = amigo; 
			}
		}
	  return ret;
	}
	
	public Boolean esAmigoDe(Usuario usuario) {
		return this.amigos.contains(usuario);
	}
	
	public Boolean puedeVerPublicacion(Publicacion pub) {
		return pub.dejarVerPublicacion(this);
	}
	
	public Boolean veTodasLasPublicaciones(Usuario usuario) {
		Boolean ret = true;
		
		for(Publicacion pub : this.publicacionesHechas()) {
			ret = ret && usuario.puedeVerPublicacion(pub); 
		}
	  return ret;
	}
	
	public Set<Usuario> mejoresAmigos(){
		Set<Usuario> mejoresAmigos = new HashSet<Usuario>();
		for(Usuario amigo : this.amigos) {
			if(this.veTodasLasPublicaciones(amigo)) {
				mejoresAmigos.add(amigo);
			}
		}
	 return mejoresAmigos;
	}
	
	public Boolean dioMeGustaA(Publicacion pub) {
		return pub.recibioMeGustaDe(this);
	}
	
	public Boolean stalkeaA(Usuario usuario) {
		return usuario.cantidadDeMeGustaRecibidoDe(this) > this.meGustaRecibidos() * 0.9;
	}	
	
	public Integer cantidadDeMeGustaRecibidoDe(Usuario usuario) {
		return this.meGustaRecibidoDe(usuario).size();
	}
	
	public Set<Publicacion> meGustaRecibidoDe(Usuario usuario){
		Set<Publicacion> publics = new HashSet<Publicacion>();
		for(Publicacion pub : this.publicacionesHechas()) {
			if(usuario.dioMeGustaA(pub)) {
				publics.add(pub);
			}
		}
	 return publics;
	}
		
}
