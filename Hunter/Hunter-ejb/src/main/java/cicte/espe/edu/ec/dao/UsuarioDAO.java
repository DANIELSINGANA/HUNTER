/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cicte.espe.edu.ec.dao;

import cicte.espe.edu.ec.modelo.Usuario;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;
import java.util.List;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
/**
 *
 * @author esteb
 */
public class UsuarioDAO extends BasicDAO<Usuario, ObjectId> 
{
    private Datastore ds;

    public UsuarioDAO(Datastore ds) 
    {
        super(Usuario.class, ds);
        this.ds = ds;
    }

 
    public String insert(Usuario usuario) 
    {
        Key<Usuario> key = this.save(usuario);
        return key.toString();
    }

    public List<Usuario> getUsuarios() 
    {
        List<Usuario> usuarios = this.find().asList();
        return usuarios;
    }

    public void deleteUsuario(Usuario usuario) 
    {
        Query<Usuario> query = this.createQuery();
        query.and(
                query.criteria("contrasena").equal(usuario.getContrasena())
        );
        this.deleteByQuery(query);
    }
    
    public Boolean updateNombreUsuario(Usuario usuario) 
    {
        Query<Usuario> query = this.createQuery();
        query.and(
                query.criteria("contrasena").equal(usuario.getContrasena())
        );
        UpdateOperations<Usuario> updateNombre = this.createUpdateOperations();
        updateNombre.set("nombre", usuario.getNombre()).set("estado",usuario.getEstado());
        UpdateResults results = this.update(query, updateNombre);
        return results.getUpdatedExisting();
    }

}
