package com.biblioteca.controller;

import java.util.Date;
import java.util.List;
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
	
	//CREAR UN AUTOR
	@PostMapping("/crear")
	public Usuario crear(@RequestBody Usuario u) {
		return uService.crearUsuario(u);
	}
	
	//EDITAR UN AUTOR
	@PutMapping("/editar/{id}")
	public Usuario editar(@RequestBody Usuario u, @PathVariable("id") Long id) {
		Usuario oldUsuario = uService.buscarUsuarioId(id);
		
		String cc = u.getCc();
		oldUsuario.setCc(cc);
		
		String email = u.getEmail();
		oldUsuario.setEmail(email);
		
		String contrasena = u.getContrasena();
		oldUsuario.setContrasena(contrasena);
		
		String primer_nombre = u.getPrimerNombre();
		oldUsuario.setPrimerNombre(primer_nombre);
		
		String segundo_nombre = u.getSegundoNombre();
		oldUsuario.setSegundoNombre(segundo_nombre);
		
		String primer_apellido = u.getPrimerApellido();
		oldUsuario.setPrimerApellido(primer_apellido);
		
		String segundo_apellido = u.getSegundoApellido();
		oldUsuario.setSegundoApellido(segundo_apellido);
		
		Character genero = u.getGenero();
		oldUsuario.setGenero(genero);
		
		Long telefono = u.getTelefono();
		oldUsuario.setTelefono(telefono);
		
		Date nacimiento = u.getNacimiento();
		oldUsuario.setNacimiento(nacimiento);
		
		String direccion = u.getDireccionResidencia();
		oldUsuario.setDireccionResidencia(direccion);
		
		Set<Prestamo> prestamo = u.getPrestamo();
		oldUsuario.setPrestamo(prestamo);
		
		return uService.actualizarUsuario(oldUsuario);
	}
	
	//ELIMINAR UN USUARIO
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		Usuario u = uService.buscarUsuarioId(id);
		uService.eliminarUsuario(u);
	}
	
	//LISTANDO TODOS LOS USUARIOS
	@GetMapping("/listarusuarios")
	public List<Usuario> listarUsuarios(){
		return uService.listarTodosUsuarios();
	}

}
