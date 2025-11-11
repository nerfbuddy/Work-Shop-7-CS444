package Project4;

import java.util.Objects;

public class OperatorVerifier {
	 OperatorDatabase od = new OperatorDatabase();
	 public boolean VerifyOperator(User operator) {
		
		
		
		if (od.search(operator) != null)
		{return true;}
		
	System.out.print("This operator does not exist.");
	return false;
}
	public boolean LoginOperator(Operator operator)
	{
		User op2 = od.search(operator);
		if (op2 != null)
		{
			if(Objects.equals(op2.name, operator.name) && op2.ID == operator.ID && Objects.equals(op2.pwd, operator.pwd))
			{
				return true;
			}
			System.out.print("Invalid Login Info.");
			return false;
		}
		else
		{
			System.out.print("This operator does not exist.");
			return false;
		}

	}


}

