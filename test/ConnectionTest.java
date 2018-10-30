/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conn.Connection;
import javax.naming.directory.DirContext;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author David Samuel
 */
public class ConnectionTest {
    
    @Test
    public void ConectarAd() throws Exception{
        
        DirContext ctx = new Connection().conecta();
        
        assertEquals(ctx.equals(ctx), true);
        
    }
}
