package br.jee.model.DAO;
import java.util.ArrayList;
import java.util.List;
import br.jee.model.bean.Cliente;

public class ClienteDAO {

	ArrayList<Cliente> lista = new ArrayList<Cliente>();

	public boolean salvarCliente(Cliente cliente) {		
		return lista.add(cliente);	
	}	
	public List<Cliente> listarCliente() {
		return lista;
	}	
	public Cliente editarCliente(Cliente cliente) {		
		for (int i=0;i<lista.size();i++) {
			if(cliente.getCliCodigo()==
					lista.get(i).getCliCodigo().intValue()){				
				return lista.get(i);
			}				
		}
		return null;
	}	
	public Cliente alterarCliente(Cliente cliente) {			
		for (int i=0;i<lista.size();i++) {
			if(cliente.getCliCodigo()==
					lista.get(i).getCliCodigo().intValue()){
				lista.set(i,cliente);
				return lista.get(i);
			}				
		}	
		return null;
	}

}