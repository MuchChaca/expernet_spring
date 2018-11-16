package test.java;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.springframework.http.HttpStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefsIntegrationTest extends SpringIntegrationTest {

	@When("^the client calls /todo/all$")
	public void the_client_issues_GET_todo_all() throws Throwable {
		try {
			executeGet("localhost:9090/todo/all");
		} catch (Exception ex) {
			System.out.println(ex.toString()); // DEBUG
		}
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
		try {
			System.out.println("-----------------------------------------"); // DEBUG
			final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
			System.out.println(currentStatusCode.toString()); // DEBUG
			System.out.println("-----------------------------------------"); // DEBUG
			assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(),
					is(statusCode));
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	// @And("^the client receives server version (.+)$")
	// public void the_client_receives_server_version_body(String version) throws
	// Throwable {
	// assertThat(latestResponse.getBody(), is(version));
	// }
}