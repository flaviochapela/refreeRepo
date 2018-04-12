/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import com.dotexperts.enummerators.EnumTipoConvocacao;
import com.dotexperts.hajime.interfaces.iCampeonato;
import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Campeonato;
import com.dotexperts.hajime.model.Campeonatoarbitro;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import relatorio.AreasRel;

/**
 *
 * @author admprodesp
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException, Exception {

        InitialContext ctx = new InitialContext();
        iCampeonato ejb = (iCampeonato) ctx.lookup("com.dotexperts.hajime.interfaces.iCampeonato");
        
        //Campeonato c = ejb.get(1);
        
       // Arbitro a = new Arbitro();
       // a.setId(1);
        
        //Campeonato c = new Campeonato();
       // c.setId(2);
        
//        c.setAreas(6);
//        c.setNome("InterRegional Sub 18/ Sub 21");
//        c.setCidade("Mogi das Cruzes");
//        c.setLocal("Sesi");
//        ejb.insert(c);
        
         //ejb.addConvocacao(2, a, EnumTipoConvocacao.nominal);
        
//        AreasRel r = new AreasRel();
//
//        List<Campeonatoarbitro> ca = new ArrayList<Campeonatoarbitro>();
//
////        System.out.println(String.format("%s", c.getNome() ));
////        List<Arbitro> Arbitros = new ArrayList<Arbitro>();
        
        List<Campeonato> c = new ArrayList<Campeonato>();
        c = ejb.listAll();
        
        c.forEach((a) -> {
            System.out.println(String.format("%s", a.getNome()));
        });//        for (Campeonatoarbitro a : c.getCampeonatoarbitroCollection()) {
//
//            ca.add(a);
//            
//            //a.getIdarbitro()
//            // a.getArbitro().getIdassociacao().getNome()get
//            //       a.getArbitro().getIdarbitro()
//            System.out.println(String.format("%s", a.getIdarbitro().getNome()));
//            
//            //Arbitros.add(a.getArbitro());
////            a.getArbitro().getNome();
//        }
//
//        r.imprimir(ca);

    }

}
