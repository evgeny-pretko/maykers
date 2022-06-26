package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pageobject.components.LoginComponent;

import java.util.List;

public class LoginStep extends LoginComponent {

    @When("I login with credentials")
    public void iLoginWithCredentials(DataTable table) {

        List<List<String>> credentials = table.asLists(String.class);

        openLoginPopup();
        loginWithCredentials(credentials.get(0).get(0), credentials.get(0).get(1));
    }
}
