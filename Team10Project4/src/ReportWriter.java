package Project4;

public class ReportWriter {

	
	public boolean getMemberSummaryReport(User member) {
		if(member.getClass() == Member.class)
		{
			System.out.print("Member Summary Report: \n");
			System.out.print(member.name + " ");
			System.out.print(member.ID + "\n");
			return true;
		}
		else
		{
			throw new RuntimeException("User Type must be Member");
		}

		//System.out.print(member.address); 
		//System.out.print(member.city);
		//System.out.print(member.state);
		//System.out.print(member.zip);
		
		//for each service provided
		//System.out.print(dateofservice);
		//System.out.print(provider.name);
		//System.out.print(service.name);

		
	}
	
	public boolean getProviderSummaryReport(User provider) {
		if(provider.getClass() == Provider.class)
		{
			System.out.print("Provider Summary Report: \n");
			System.out.print(provider.name + " ");
			System.out.print(provider.ID + "\n");
			//System.out.print(provider.address);
			//System.out.print(provider.city);
			//System.out.print(provider.state);
			//System.out.print(provider.zip);
			return true;
		}
		else
		{
			throw new RuntimeException("User Type must be Provider");
		}
		
		//for each service provided
		//System.out.print(dateOfService);
		//System.out.print(dateAndTimeDataWasRecieved);
		//System.out.print(member.name);
		//System.out.print(member.id);
		//System.out.print(service.code);
		//System.out.print(service.fee);
		
		//System.out.print(totalNumberOfServices);
		//System.out.print(totalFeeForWeek);

	}
	
	
}
