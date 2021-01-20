package com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import com.biblioteca.model.Usuario;

public interface IUsuarioService {

	Usuario crearUsuario(Usuario u);
	Usuario actualizarUsuario(Usuario u); 
	Optional<Usuario> buscarUsuarioId(Long id);
	Usuario buscarUsuarioCc(String cc);
	Usuario buscarUsuarioEmail(String email);
	List<Usuario> listarTodosUsuarios();
	void eliminarUsuario(Long id);
}
