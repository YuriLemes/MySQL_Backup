package br.com.yurilemes.mysqlbackup;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.yurilemes.mysqlbackup.util.Util;

/**
 *  
 * @author Yuri Lemes <yurilemes2@gmail.com>
 * 
 */
public class MySQLBackup {

	private final String VERSAO = "1.0";
	private final String SEPARATOR = File.separator;
	private String mySqlVersao = "";
	private String destinoDoBackup = null;
	private String MYSQL_PATH = "";
	private long momentoInicial, momentoFinal, tempoTotal;
	
	private final String APRESENTACAO = "MySQLBackup - Versão " + VERSAO + " - Yuri Lemes - yurilemes2@gmai.com";
	
	/**
	 * 
	 * @param mySqlVersao
	 * @param destinoDoBackup
	 * @throws IllegalArgumentException Se a versão do MySQL ou o destino do backup forem vazios ou nulos.
	 */
	public MySQLBackup(String mySqlVersao, String destinoDoBackup){
		
		if(Util.isEmpty(mySqlVersao)){
			throw new IllegalArgumentException("ERRO: Versão do banco deve ser informada.");
		}
		
		if(Util.isEmpty(destinoDoBackup)){
			throw new IllegalArgumentException("ERRO: Destino do backup deve ser informado.");
		}
	
		this.mySqlVersao = mySqlVersao;
		this.destinoDoBackup = destinoDoBackup;
		MYSQL_PATH = "C:" + SEPARATOR + "Program Files" + SEPARATOR + "MySQL" + SEPARATOR + "MySQL Server "
		+ this.mySqlVersao.trim() + SEPARATOR + "bin" + SEPARATOR;
	}
	
	/**
	 * Exporta o dump sql do banco argumento.
	 * @param nomeDoBanco
	 * @param usuario
	 * @param senha
	 * @throws IOException 
	 */
	public void iniciar(String nomeDoBanco, String usuario, String senha) throws IOException {
		
		String dataHoraAtual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH.mm"));
		
		usuario = "--user=" + usuario;
		senha = "--password=" + senha;
		String resultFile = "--result-file=" + destinoDoBackup + SEPARATOR + nomeDoBanco.toUpperCase() + "_" + dataHoraAtual + ".sql";
		
		String comando = MYSQL_PATH + "mysqldump.exe";
		
		System.out.println(APRESENTACAO);
		System.out.println("Realizando Backup de " + nomeDoBanco + "...");
		
		momentoInicial = System.currentTimeMillis();
		
		ProcessBuilder builder = new ProcessBuilder(comando, usuario, senha, nomeDoBanco, resultFile);
		builder.start();
		
		momentoFinal = System.currentTimeMillis();
		tempoTotal = momentoFinal - momentoInicial;
		
		System.out.println("Backup efetuado com sucesso!");
		System.out.println("Tempo total gasto: " + tempoTotal + "ms\n");
		System.exit(0);
	}
	
}