package br.com.yurilemes.mysqlbackup.demo;

import java.io.IOException;

import br.com.yurilemes.mysqlbackup.MySQLBackup;

public class TesteMySqlBackup {

	public static void main(String[] args) throws IOException {
		String database = "teste";
		String user = "root";
		String pass = "123";
		
		MySQLBackup backup = new MySQLBackup("5.7", "C://Backup");
		
		backup.iniciar(database, user, pass);
		
	}
}
