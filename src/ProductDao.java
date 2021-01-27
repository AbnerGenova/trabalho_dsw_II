import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
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
	
	public List<Product> getProduct() {
		database.loadDriver(database.getDbdriver());
		Connection con = database.getConnection();
		String sql = "select * from gerpro.product";
		ResultSet result = null;
		List<Product> products = new ArrayList<Product>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeQuery();
			
			while(result.next()) {
				String id = result.getString("id");
				String code = result.getString("code");
				String type = result.getString("type");
				String name = result.getString("name");
				String quantity = result.getString("quantity");
				String price = result.getString("price");
				
				Product product = new Product(code, type, name, quantity, price);
				product.setId(id);
				
				products.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}
	
	public void delete(String id) {
		database.loadDriver(database.getDbdriver());
		Connection con = database.getConnection();
		String sql = "delete from gerpro.product WHERE ID = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
