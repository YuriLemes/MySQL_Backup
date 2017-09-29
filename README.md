# MySQL_Backup
Aplicação para efetuar backup de banco de dados MySQL.

Exemplo de uso:

public class TesteMySqlBackup {

	public static void main(String[] args) throws IOException {
		String database = "teste";
		String user = "root";
		String pass = "123";
		
		MySQLBackup backup = new MySQLBackup("5.7", "C://Backup");
		
		backup.iniciar(database, user, pass);
		
	}
  
}
