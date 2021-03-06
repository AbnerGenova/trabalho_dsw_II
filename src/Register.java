

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductDao registerDao = new ProductDao();
		List<Product> products = registerDao.getProduct();
		
		request.setAttribute("productsCollection", products);
		request.getRequestDispatcher(request.getContextPath() + "/merchandise-table.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code=request.getParameter("code");
		String type=request.getParameter("type");
		String name=request.getParameter("name");
		String quantity=request.getParameter("quantity");
		String price=request.getParameter("price");
		
		Product product = new Product(code, type, name, quantity, price);
		
		ProductDao registerDao = new ProductDao();
		String result = registerDao.insert(product);
		
		//response.getWriter().print(result);
		response.sendRedirect(request.getContextPath() + "/merchandise-table.jsp");
	}

}
