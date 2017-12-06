package br.unitins.sac.util;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
 
public class GerarRelatorio {
 
	// Método para realizar a conexão com o banco de dados
//	public Connection getConexao() throws SQLException, ClassNotFoundException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdacademicnet", "root", "teco01");
//		return conexao;
//	}
	
	private Connection getConexao() throws  SQLException, ClassNotFoundException, NamingException {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env/");
			javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/web2");
			return (java.sql.Connection) ds.getConnection();
	}
 
 
	public byte[] gerarPDF() {
		byte[] retorno = null;
//		String relatorio = diretorio + "RelAlunos.jrxml";
//		String imagem = diretorio + "cherry.jpg";
		try {
			// Faz a compilação do relatório
//			JasperReport jasperReport = JasperCompileManager.compileReport(relatorio);
			
			InputStream resourceStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("reports" + File.separator + "AlunoReport" + ".jrxml");
			JasperDesign jasperDesign = JRXmlLoader.load(resourceStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
 
			// Cria o mapa de parâmetros que será enviado ao relatório
			HashMap<String, Object> paramatros = new HashMap<String, Object>();
 
			// Faz o apontamento para a imagem que aparece no top do relatório
//			paramatros.put("logo", imagem);
 
			// Preenche os dados do relatório
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramatros, getConexao());
 
			// Objeto para a ser retornado
			retorno = JasperRunManager.runReportToPdf(jasperReport, paramatros, getConexao());
 
			// Gera o arquivo PDF no caminho especificado
			JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/macinfoboxrecife/rel.pdf");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}