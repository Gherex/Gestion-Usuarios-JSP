package com.gherex.persistence;

import com.gherex.logic.User;

import java.util.List;

public class PersistenceController {

    UserJpaController userJpa = new UserJpaController();

    public void crearUsuario(User user) {
        userJpa.crearUsuario(user);
    }

    public List<User> traerUsuarios() {
        return userJpa.obtenerUsuarios();
    }

    public void eliminarUsuario(String idSeleccionado) {
        int id = Integer.parseInt(idSeleccionado);
        userJpa.eliminarUsuario(id);
    }

    public User traerUsuario(int idSeleccionado) {
        return userJpa.buscarUsuarioPorId(idSeleccionado);
    }

    public void actualizarUsuario(User usuarioEdit) {
        userJpa.actualizarUsuario(usuarioEdit);
    }
}