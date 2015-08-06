package cap02.top21;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class FornecedorImplementacoes {

	private Map<Class<?>, Class<?>> implementacoes = new HashMap<>();

	public FornecedorImplementacoes(String nomeArquivo) throws IOException,
			ClassNotFoundException {
		
		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		for(Object interf : p.keySet()) {
			Class<?> interfType = Class.forName(interf.toString());
			Class<?> implType = Class.forName(p.get(interf).toString());
			implementacoes.put(interfType, implType);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf) {
		return implementacoes.get(interf);
	}
	
	public static void main(String[] args) {
		try {
			FornecedorImplementacoes f = new FornecedorImplementacoes("implementacao.prop");
			Class<?> impl = f.getImplementacao(DAO.class);
			System.out.println("Implementa��o recupareda: " +
					impl.getName());
		} catch(ClassNotFoundException | IOException e) {
			System.out.println("Problemas ao obter implementa��es: " +
					e.getMessage());
		}
	}
}
