package Project4;

import java.util.Objects;

public class ProviderVerifier {
	ProviderDatabase pd = new ProviderDatabase();
public Boolean VerifyProvider(User provider) {
		
		
		
		if (pd.search(provider) != null)
		{
			return true;
		}
		else
		{
			System.out.print("This provider does not exist.");
			return false;
		}
		

}

	public boolean LoginProvider(User operator) {
		if(operator.getClass() == Provider.class)
		{

		}
		else
		{
			throw new RuntimeException("Requires type Provider");
		}
		User op2 = pd.search(operator);
		if (op2 != null) {
			if (Objects.equals(op2.name, operator.name) && op2.ID == operator.ID && Objects.equals(op2.pwd, operator.pwd)) {
				return true;
			}
			System.out.print("Invalid Login Info.");
			return false;
		} else {
			System.out.print("This Provider does not exist.");
			return false;
		}
	}
}

