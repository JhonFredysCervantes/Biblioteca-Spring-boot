package com.biblioteca.services;

import java.util.List;

import com.biblioteca.model.Usuario;

public interface IUsuarioService {

	Usuario crearUsuario(Usuario u);
	Usuario actualizarUsuario(Usuario u); 
	boolean eliminarUsuario(Usuario u);
	List<Usuario> listarTodosUsuarios();
}