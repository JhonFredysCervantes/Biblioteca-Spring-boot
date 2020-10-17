package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Usuario;

public interface IUsuarioService {

	Usuario crearUsuario(Usuario u);
	Usuario actualizarUsuario(Usuario u); 
	void eliminarUsuario(Usuario u);
	
	List<Usuario> listarTodosUsuarios();
	Usuario buscarUsuarioId(Long id);
	Usuario buscarUsuarioCc(Long cc);
}
