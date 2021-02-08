<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.jee.model.bean.Cliente"%>
<% 
  Cliente clienteUnico = (Cliente)request.getSession().getAttribute("clienteUnico");
%>
<div style="width:580px">
<form name="form" action="acao?metodo=alterarCliente" method="post">
		Alterar Cliente
	<hr>
			Para alterar um Cliente, preencha o formulário abaixo.<br/><br/>			
			Codigo<br/>
			<input type="text" size="06" maxlength="10" name="cliCodigo"  value="<%=clienteUnico.getCliCodigo()%>" readonly="readonly"><br/>            
        	Nome<br/>
			<input type="text" size="50" maxlength="100" name="cliNome"  value="<%=clienteUnico.getCliNome()%>"><br/>				
			<input type="submit" name="salvar" value="Salvar">
</form>
</div>