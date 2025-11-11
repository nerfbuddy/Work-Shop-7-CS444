
package Project4.Tests;





import static org.junit.jupiter.api.Assertions.*;



import java.io.PrintStream;



import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;



import Project4.Manager;

import Project4.Member;

import Project4.MemberVerifier;

import Project4.Provider;

import Project4.ReportWriter;

import Project4.User;

import Project4.aTerminal;

import Project4.ManagerVerifier;



class MackenzieUnitTest {




	@BeforeEach

	void setUp() throws Exception {



	}




	@Test // success

	void memberSummaryReportSuccess() {

		ReportWriter summary = new ReportWriter();

		Member mem = new Member("Kenzie", 100, "password11");

		assertEquals(summary.getMemberSummaryReport(mem), true);


	}


	@Test // fail

	void memberSummaryReportException() {

		ReportWriter summary = new ReportWriter();

		Provider prov = new Provider("Kenzie", 100, "password11");

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> {

			summary.getMemberSummaryReport(prov);

		});

		assertEquals("User Type must be Member", thrown.getMessage());

// Fix: not actually fail

	}


	@Test // success

	void providerSummaryReportSuccess() {

		ReportWriter summary = new ReportWriter();

		Provider prov = new Provider("Kenzie", 100, "password11");

		assertEquals(summary.getProviderSummaryReport(prov), true);

	}



	@Test // failure

	void providerSummaryReportException() {

		ReportWriter summary = new ReportWriter();

		Member mem = new Member("Kenzie", 100, "password11");

// Provider prov = new Provider("Kenzie", 100, "password11");

//assertEquals(summary.getProviderSummaryReport(mem), "User Type must be Provider");

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> {

			summary.getProviderSummaryReport(mem);

		});

		assertEquals("User Type must be Provider", thrown.getMessage());

// Fix: not actually fail

	}



	@Test // success

	void VerifyManagerSuccess() {

// aTerminal terminal = new aTerminal();

// terminal.s = "1";

// assertEquals(terminal.x, true);


		ManagerVerifier memver = new ManagerVerifier();

		Manager prov = new Manager("man", 1, "man1");

		assertEquals(memver.VerifyManager(prov), true);

	}



	@Test // fail

	void VerifyMangerFail() {

		ManagerVerifier memver = new ManagerVerifier();

		Manager prov = new Manager("me", 4, "pass");

		assertEquals(memver.VerifyManager(prov), false);

	}





}