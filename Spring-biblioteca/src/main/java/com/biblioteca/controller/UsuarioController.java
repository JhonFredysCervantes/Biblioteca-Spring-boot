package com.biblioteca.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.services.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired 
	IUsuarioService uService;
	
	/*http://localhost:8080/usuario/...*/
	
	//CREAR UN USUARIO
	@PostMapping
	public Usuario crear(@RequestBody Usuario u) {
		return uService.crearUsuario(u);
	}
	
	//EDITAR UN USUARIO
	@PutMapping("/{id}")
	public Usuario editar(@RequestBody Usuario u, @PathVariable("id") Long id) {
		
		if(id!=null) {
			Optional<Usuario> resultado = uService.buscarUsuarioId(id);
			
			if(resultado.isPresent()) {
				String cadena;
				Usuario oldUsuario = resultado.get();
						
				cadena = u.getCc();
				oldUsuario.setCc(cadena);
				
				cadena = u.getEmail();
				oldUsuario.setEmail(cadena);
				
				cadena = u.getContrasena();
				oldUsuario.setContrasena(cadena);
				
				cadena = u.getPrimerNombre();
				oldUsuario.setPrimerNombre(cadena);
				
				cadena = u.getSegundoNombre();
				oldUsuario.setSegundoNombre(cadena);
				
				cadena = u.getPrimerApellido();
				oldUsuario.setPrimerApellido(cadena);
				
				cadena = u.getSegundoApellido();
				oldUsuario.setSegundoApellido(cadena);
				
				Character genero = u.getGenero();
				oldUsuario.setGenero(genero);
				
				Long telefono = u.getTelefono();
				oldUsuario.setTelefono(telefono);
				
				Date nacimiento = u.getNacimiento();
				oldUsuario.setNacimiento(nacimiento);
				
				cadena = u.getDireccionResidencia();
				oldUsuario.setDireccionResidencia(cadena);
				
				Set<Prestamo> prestamo = u.getPrestamo();
				oldUsuario.setPrestamo(prestamo);
				
				return uService.actualizarUsuario(oldUsuario);
			}
		}
		return null;
	}
	
	//ELIMINAR UN USUARIO
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		uService.eliminarUsuario(id);
	}
	
	// BUSCAR POR CC
	@GetMapping("/identificacion/{cc}")
	public Usuario buscarPorCedula(@PathVariable("cc")String cc){
		return uService.buscarUsuarioCc(cc);
	}
	
	// BUSCAR POR EMAIL
		@GetMapping("/email/{e}")
		public Usuario buscarPorEmail(@PathVariable("e")String email){
			return uService.buscarUsuarioCc(email);
		}
	
	//LISTANDO TODOS LOS USUARIOS
	@GetMapping
	public List<Usuario> listarUsuarios(){
		return uService.listarTodosUsuarios();
	}

}
