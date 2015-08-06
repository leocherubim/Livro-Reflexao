package cap02.top22;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UsoConstrutor {

	public UsoConstrutor(String s) {
		System.out.println("Contrutor invocado com: " + s);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		Class<UsoConstrutor> c = UsoConstrutor.class;
		Constructor<UsoConstrutor> constr = c.getConstructor(String.class);
		
		try {
			UsoConstrutor obj = constr.newInstance("teste");
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch(InvocationTargetException e) {
			System.out.println(
					"Exceção lançada pelo construtor: "
					+ e.getTargetException());
		}

	}

}
