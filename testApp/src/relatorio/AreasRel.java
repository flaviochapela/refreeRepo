/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import com.dotexperts.hajime.model.Arbitro;
import com.dotexperts.hajime.model.Campeonatoarbitro;
import java.util.Collection;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author admprodesp
 */
public class AreasRel {

    private String path;
    private String pathToReportPackage;

    //Recupera os caminhos para que a classe possa encontrar os relatórios
    public AreasRel() {
        this.path = this.getClass().getClassLoader().getResource("").getPath();
        this.pathToReportPackage = this.path + "relatorio/";
        System.out.println(path);
    }

    //Imprime/gera uma lista de Clientes
    public void imprimir(List<Campeonatoarbitro> arbitros) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Areas.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(arbitros));
        JasperExportManager.exportReportToPdfFile(print, "Relatorio_de_Areas.pdf");
    }

    public String getPathToReportPackage() {
        return this.pathToReportPackage;
    }

    public String getPath() {
        return this.path;
    }
}
