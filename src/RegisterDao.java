import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	
	Database database = new Database();
	
	public String insert(Product product) {
		database.loadDriver(database.getDbdriver());
		Connection con = database.getConnection();
		
		String result="Dados cadastrados com sucesso";
		
		String sql = "insert into gerpro.product(code, type, name, quantity, price) values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getCode());
			ps.setString(2, product.getType());
			ps.setString(3, product.getName());
			ps.setString(4, product.getQuantity());
			ps.setString(5, product.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Houve falha na hora de cadastrar o produto";
		}
		
		return result;
	}
}
