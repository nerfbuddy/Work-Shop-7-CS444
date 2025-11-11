package Project4;

public class MemberVerifier {
	MemberDatabase md = new MemberDatabase();
	//member verifier
public Boolean VerifyMember(User member) {
		
		
	
			if (md.search(member) != null)
			{
				return true;
			}
			else
			{
				System.out.print("This member does not exist. ");
				return false;
			}

			

	}
	

}
