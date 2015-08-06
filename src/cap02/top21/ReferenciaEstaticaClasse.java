package cap02.top21;

public class ReferenciaEstaticaClasse {

	public static void main(String[] args) {
		Class<String> classe = String.class;
		System.out.println(classe.getName());
		imprimeNomeClasse(classe);
	}
	
	public static void imprimeNomeClasse(Class<?> classe) {
		System.out.println("Chamado o m�todo com " +
				classe.getName());
	}

}
