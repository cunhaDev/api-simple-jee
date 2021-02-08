<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.jee.model.bean.Cliente,java.util.*" %>
<%
	List<Cliente> lista = (List<Cliente>)request.getSession().getAttribute("listaDeClientes");
%>
	<table border="2">
		<tr>
			<th >Nome</th>
			<th colspan="2">Ações</th>
		</tr>
		<%for(Cliente cliente: lista){%>
			<tr>		
				<td><%=cliente.getCliNome()%></td>
				<td>
				  <a href="acao?metodo=editarCliente&cliCodigo=<%=cliente.getCliCodigo()%>">
					<img src="icones/icoAlterar.png" border="0" title="Editar"/>&nbsp; Alterar
				  </a>
			   </td>
				<td>
				   <a href="acao?metodo=nada&cliCodigo=<%=cliente.getCliCodigo()%>" onclick="return confirmacao();">
					<img src="icones/icoExcluir.png" border="0" title="Excluir" />&nbsp; Excluir
				  </a>
				</td>
			</tr>
		<%}%>
	</table><br>
	<a href="acao?metodo=voltar">&nbsp; Voltar