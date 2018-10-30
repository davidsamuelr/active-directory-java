/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

import conn.Connection;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 *
 * @author David Samuel
 */
public class Dap {

    private DirContext ctx = null;
    private final String base = "OU=USERS_SEF,DC=domain,DC=com";

    public Dap() throws Exception {
        ctx = new Connection().conecta();
    }

    public SearchResult busca(Employee servidor) throws Exception {

        String filtro = "(&(objectClass=person)(sAMAccountName=" + servidor.getCpf() + "))";

        SearchControls sCtrl = new SearchControls();
        sCtrl.setSearchScope(SearchControls.ONELEVEL_SCOPE);

        NamingEnumeration<SearchResult> resposta = ctx.search(base, filtro, sCtrl);

        if (resposta.hasMoreElements()) {
            return resposta.next();
        } else {
            return null;
        }

    }

    public void altera(SearchResult sr, Employee servidor) throws NamingException, Exception {

        String destingueshedName = sr.getName() + ((!"".equals(base)) ? "," + base : "");

        ActiveDirectory ad = new ActiveDirectory();

        ctx.getAttributes(destingueshedName, ad.getAtributos());

        ModificationItem[] item = new ModificationItem[ad.getQtdAtributos()];

        item[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("displayName", servidor.getNome()));

        item[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("title", servidor.getOrgao()));

        item[2] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("department", servidor.getLotacao()));

        item[3] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("mail", servidor.getEmail()));

        item[4] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("l", servidor.getMunicipioDeLotacao()));

        item[5] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("statusUser", servidor.getSituacao()));

        ctx.modifyAttributes(destingueshedName, item);

        ctx.close();

    }

}
