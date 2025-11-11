package Project4;

import java.util.Objects;

public class ManagerVerifier {
	ManagerDatabase md = new ManagerDatabase();

	public Boolean VerifyManager(User manager) {


		if (md.search(manager) != null) {
			return true;
		}

		System.out.print("This manager does not exist.");
		return false;
	}

	public boolean LoginManager(Manager operator) {
		User op2 = md.search(operator);
		if (op2 != null) {
			if (Objects.equals(op2.name, operator.name) && op2.ID == operator.ID && Objects.equals(op2.pwd, operator.pwd)) {
				return true;
			}
			System.out.print("Invalid Login Info.");
			return false;
		} else {
			System.out.print("This Manager does not exist.");
			return false;
		}


	}
}