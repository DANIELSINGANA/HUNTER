/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cicte.espe.edu.ec.servicios;

import cicte.espe.edu.ec.dao.UsuarioDAO;
import cicte.espe.edu.ec.modelo.Usuario;
import com.mongo.persistance.MongoPersistence;
import java.util.List;

/**
 *
 * @author esteb
 */
public class UsuarioServicio extends MongoPersistence {

    MongoPersistence mongo;

    UsuarioDAO usuarioDAO;

    public UsuarioServicio() {
        this.mongo = new MongoPersistence();
        this.usuarioDAO = new UsuarioDAO(mongo.context());
    }

    public String Insert(Usuario usuario) {
        return this.usuarioDAO.insert(usuario);
    }

    public Boolean UpdateNombre(Usuario usuario) {
        return this.usuarioDAO.updateNombreUsuario(usuario);
    }

    public void Delete(Usuario usuario) {
        this.usuarioDAO.deleteUsuario(usuario);
    }

    public List<Usuario> ObtenerLista() {
        return this.usuarioDAO.getUsuarios();
    }

}
