/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author David Samuel
 */
public class Connection {
    
    private final String CONTEXTO = "com.sun.jndi.ldap.LdapCtxFactory";
    private final String URL = "ldap://0.0.0.0";
    private final String USUARIO = "user@domain.com";
    private final String SENHA = "password";

    public DirContext conecta() throws Exception {

        Hashtable<String, Object> env = new Hashtable<>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, CONTEXTO);
        env.put(Context.PROVIDER_URL, URL);

        // user authentication and password
        env.put(Context.SECURITY_PRINCIPAL, USUARIO);
        env.put(Context.SECURITY_CREDENTIALS, SENHA);

        return new InitialDirContext(env);

    }
}
