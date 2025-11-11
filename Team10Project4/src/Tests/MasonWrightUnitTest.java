package Project4.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project4.Member;
import Project4.Provider;
import Project4.MemberVerifier;
import Project4.ProviderVerifier;




class MasonWrightUnitTest {

	
	@BeforeEach
	void setUp() throws Exception {

	}
	
	@Test // success
	void VerifyMemberSuccess() {
		MemberVerifier memver = new MemberVerifier();
		Member memb = new Member("Joe bad", 69, "nice");
		assertEquals(memver.VerifyMember(memb), true);
		
	}
	
	
	
	
	@Test // fail
	void VerifyMemberFail() {
		MemberVerifier memver = new MemberVerifier();
		Provider prov = new Provider("Joe blow", 123, "123");
		assertEquals(memver.VerifyMember(prov), false);
	}
	
	
	@Test // success
	void VerifyProviderSuccess() {
		ProviderVerifier prover = new ProviderVerifier();
		Provider prov = new Provider("Joe blow", 123, "123");
		assertEquals(prover.VerifyProvider(prov), true);
	}
	
	
	
	
	@Test // fail
	void VerifyProviderFail() {
		ProviderVerifier prover = new ProviderVerifier();
		Member memb = new Member("Joe bad", 69, "nice");
		assertEquals(prover.VerifyProvider(memb), false);
	}
	
	
	@Test // success
	void GetUserInfoFunctionsSuccess() {
		
		Member memb = new Member("Joe bad", 69, "nice");
		Boolean InfoCheck = false;
		if(memb.getName() == "Joe bad" && memb.getID() == 69 && memb.getPwd() == "nice") {
			InfoCheck = true;
		}
		
		assertEquals(InfoCheck, true);
	}
	
	
	
	
	@Test // fail
	void GetUserInfoFunctionsFail() {
		
		Member memb = new Member("Joe bad", 69, "nice");
		memb = new Member("Joe good", 96, "mean");
		Boolean InfoCheck = false;
		if(memb.getName() == "Joe bad" && memb.getID() == 69 && memb.getPwd() == "nice") {
			InfoCheck = true;
		}
		
		assertEquals(InfoCheck, false);
	}
	
}
