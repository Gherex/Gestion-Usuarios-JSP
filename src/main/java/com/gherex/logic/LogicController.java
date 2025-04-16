package com.gherex.logic;

import com.gherex.persistence.PersistenceController;

import java.util.List;

public class LogicController {

    PersistenceController persisControl = new PersistenceController();

    public void crearUsuario(User user) {
        persisControl.crearUsuario(user);
    }

    public List<User> traerUsuarios() {
        return persisControl.traerUsuarios();
    }

    public void eliminarUsuario(String idSeleccionado) {
        persisControl.eliminarUsuario(idSeleccionado);
    }

    public User traerUsuario(int idSeleccionado) {
        return persisControl.traerUsuario(idSeleccionado);
    }

    public void actualizarUsuario(User usuarioEdit) {
        persisControl.actualizarUsuario(usuarioEdit);
    }
}
