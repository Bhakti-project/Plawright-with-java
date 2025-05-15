package StepDefination;

import Base.BaseTest;
import Pages.ImagePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Assertions;

public class ImageStep {
	ImagePages imagepage;

	public ImageStep() {
		this.imagepage = new ImagePages(BaseTest.getPage());
	}

	@Given("I navigate to the products page")
	public void i_navigate_to_the_products_page() {
		imagepage.navigateTOProductPage();
	}

	@When("I take a screenshot")
	public void i_take_a_screenshot() {
		imagepage.productpageTakeScreenshot();
	}

	@Then("the screenshot should match the expected image")
	public void the_screenshot_should_match_the_expected_image() throws Exception {
		boolean result = imagepage.comparetheImage("target/Screenshot/Actual2.png", "target/Screenshot/ActualTake.png");
		assertTrue(result, "Screenshot does not match the expected image");
		
	}

}
