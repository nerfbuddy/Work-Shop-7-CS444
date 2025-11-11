package Project4;

public class Report {
	String memberName;
	int memberNumber;
	String memberAddress;
	String memberCity;
	String memberState;
	int memberZIP;
	String serviceDate;
	String providerName;
	String serviceName;
	int providerNumber;
	String providerAddress;
	String providerCity;
	String providerState;
	int providerZIP;
	String dataDateTime;
	int serviceCode;
	int fee;
	int consultations;
	int weekFee;
	String currDateTime;
	String comment;
	
	public void getInfo() {
		System.out.println(memberName);
		System.out.println(memberNumber);
		System.out.println(memberAddress);
		System.out.println(memberCity);
		System.out.println(memberState);
		System.out.println(memberZIP);
		System.out.println(serviceDate);
		System.out.println(providerName);
		System.out.println(serviceName);
		System.out.println(providerNumber);
		System.out.println(providerAddress);
		System.out.println(providerCity);
		System.out.println(providerState);
		System.out.println(providerZIP);
		System.out.println(dataDateTime);
		System.out.println(serviceCode);
		System.out.println(fee);
		System.out.println(consultations);
		System.out.println(weekFee);
		System.out.println(currDateTime);
		System.out.println(comment);
	}
	public String getMemberName() {
		return memberName;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public String getMemberCity() {
		return memberCity;
	}
	public String getMemberState() {
		return memberState;
	}
	public int getMemberZIP() {
		return memberZIP;
	}
	public String getServiceDate() {
		return serviceDate;
	}
	public String getProviderName() {
		return providerName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public int getProviderNumber() {
		return providerNumber;
	}
	public String getProviderAddress() {
		return providerAddress;
	}
	public String getProviderCity() {
		return providerCity;
	}
	public String getProviderState() {
		return providerState;
	}
	public int getProviderZIP() {
		return providerZIP;
	}
	public String getDataDateTime() {
		return dataDateTime;
	}
	public int getServiceCode() {
		return serviceCode;
	}
	public int getFee() {
		return fee;
	}
	public int getConsultations() {
		return consultations;
	}
	public int getWeekFee() {
		return weekFee;
	}
	public String getCurrDateTime() {
		return currDateTime;
	}
	public String getComment() {
		return comment;
	}
}
	
class MemberReport extends Report {
	String memberName;
	int memberNumber;
	String memberAddress;
	String memberCity;
	String memberState;
	int memberZIP;
	
	// For each service provided:
	String serviceDate;
	String providerName;
	String serviceName;
	}

class ProviderReport extends Report {
    String providerName;
	int providerNumber;
	String providerAddress;
	String providerCity;
	String providerState;
	int providerZIP;
	
	// For each service provided:
	String serviceDate;
	String dataDateTime;
	String memberName;
	int memberNumber;
	int serviceCode;
	int fee;
	int consultations;
	int weekFee;
}

class Record extends Report {
	String currDateTime;
	String serviceDate;
	int providerNumber;
	int memberNumber;
	int serviceCode;
	String comment;
}
	
	
	
	
	

