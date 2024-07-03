package com.example;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class LDAPInjectionExample {
    public void run(String userInput) {
        String base = "ou=people,dc=example,dc=com";
        String filter = "(&(uid=" + userInput + "))";

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");

        try {
            DirContext ctx = new InitialDirContext(env);
            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
            NamingEnumeration<SearchResult> results = ctx.search(base, filter, sc);

            while (results.hasMore()) {
                SearchResult sr = results.next();
                System.out.println("Found: " + sr.getNameInNamespace());
            }
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
