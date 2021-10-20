package ch.sweng.inventory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class StepDefinitions {
    private Inventory inventory;

    @Given("there are {int} sweaters in the inventory")
    public void withXSweatersInInventory(int nSweaters) {
        this.inventory = new Inventory();
        for (int i = 0; i < nSweaters; i++) {
            this.inventory.add(Product.SWEATER);
        }
    }

    @When("I add {int} sweaters to the inventory")
    public void addXSweatersToInventory(int nSweaters){
        for (int i = 0; i < nSweaters; i++) {
            this.inventory.add(Product.SWEATER);
        }
    }


    @When("I remove {int} sweater to the inventory")
    public void removeXSweaterToTheInventory(int nSweaters) {
        for(int i  = 0; i< nSweaters; ++i){
            this.inventory.remove(Product.SWEATER);
        }
    }

    @Then("the inventory contains {int} sweaters")
    public void checkXSweatersInInventory(int nSweaters) {
        assertThat(this.inventory.getProductQuantity(Product.SWEATER)
                , is(nSweaters));
    }
}
