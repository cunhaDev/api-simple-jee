package br.jee.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.jee.model.DAO.ClienteDAO;
import br.jee.model.bean.Cliente;

@WebServlet("/acao")
public class ServletControllerCliente extends HttpServlet {	
	private static final long serialVersionUID = 1L;	
	
	ClienteDAO clienteDAO = new ClienteDAO();
		//<form name="form" action="acao?metodo=salvarCliente" method="post">
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String metodo = request.getParameter("metodo");
		String pagina = "";		
		if (metodo.equals("salvarCliente")) {
			salvarCliente(request);
			listarCliente(request);
			pagina = "listar.jsp";
		}	
		if (metodo.equals("nada")) {
			pagina = "listar.jsp";
		}	
		if (metodo.equals("voltar")) {
			pagina = "index.jsp";
		}	
		if (metodo.equals("editarCliente")) {
			if(editarCliente(request)!=null){
				pagina = "alterar.jsp";
			}
		}
		if (metodo.equals("alterarCliente")) {
			if(alterarCliente(request)!=null){
				listarCliente(request);			
				pagina = "listar.jsp";
			}
		}	
		RequestDispatcher dispatcher =request.getRequestDispatcher("/"+ pagina);
		dispatcher.forward(request, response);
	}
	private void salvarCliente(HttpServletRequest request) {
		Cliente cliente = new Cliente();
		cliente.setCliCodigo(Integer.parseInt(request.getParameter("cliCodigo")));
		cliente.setCliNome(request.getParameter("cliNome"));				
		if (cliente.getCliCodigo()>0) {
			clienteDAO.salvarCliente(cliente);
		}	
	}	
	private void listarCliente(HttpServletRequest request) {
		request.getSession().setAttribute
		("listaDeClientes", clienteDAO.listarCliente());
	}
	private Cliente editarCliente(HttpServletRequest request) {
		try{
			String cliCodigo = request.getParameter("cliCodigo");
			Cliente cliente = new Cliente();
			cliente.setCliCodigo(Integer.parseInt(cliCodigo));	
			Cliente clienteRetorno=clienteDAO.editarCliente(cliente);
			if(clienteRetorno!=null){
				request.getSession().setAttribute("clienteUnico",clienteRetorno);
			}
			return clienteRetorno;
		}catch (Exception e) {
			System.out.println("editatCliente:"+e.getMessage());
			request.setAttribute("mensagem", "Não foi possível editar!");
		}
		return null;
	}	
	private Cliente alterarCliente(HttpServletRequest request) {
		try{
			Cliente cliente = new Cliente();
			cliente.setCliCodigo(Integer.parseInt(request.getParameter("cliCodigo")));
			cliente.setCliNome(request.getParameter("cliNome"));
			Cliente clienteRetorno=clienteDAO.alterarCliente(cliente);
			if(clienteRetorno!=null){
				request.getSession().setAttribute("clienteUnico",clienteRetorno);
			}
			return clienteRetorno;	
		}catch (Exception e) {
			System.out.println("alterarCliente:"+e.getMessage());
			request.setAttribute("mensagem", "Não foi possível alterar!");
		}
		return null;
	}
}