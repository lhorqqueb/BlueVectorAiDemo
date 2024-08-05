package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Automations;
import net.datafaker.Faker;

import static utils.Automations.sleep;

public class ContactUsPage {

    private WebDriver driver;
    private Faker faker;

    // --- Web Elements Locations ------- //
    private final By loc_name_input = By.cssSelector("input#wpforms-5768-field_6");
    private final By loc_email_input = By.cssSelector("input#wpforms-5768-field_1");
    private final By loc_company_input = By.cssSelector("input#wpforms-5768-field_7");
    private final By loc_phone_input = By.cssSelector("#wpforms-5768-field_5");
    private final By loc_message_input = By.cssSelector("#wpforms-5768-field_2");
    private final By loc_submit_button = By.cssSelector("#wpforms-submit-5768");

    /**
     * Constructor to initialize the ContactUsPage class.
     *
     * @param driver The WebDriver instance to interact with the browser.
     */
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.faker = new Faker();
        Automations.setDriver(driver); // Ensure Automations is initialized with the driver
    }

    /**
     * Method to fill in the contact form with fake data.
     * Uses Faker library to generate random data for each input field.
     */
    public void fillContactForm() {
        // Highlight and type in the Name input field
        Automations.highlight(loc_name_input);
        sleep(2);
        Automations.type(loc_name_input, faker.name().fullName());
        sleep(2);

        // Highlight and type in the Email input field
        Automations.highlight(loc_email_input);
        sleep(2);
        Automations.type(loc_email_input, faker.internet().emailAddress());
        sleep(2);

        // Highlight and type in the Company input field
        Automations.highlight(loc_company_input);
        sleep(2);
        Automations.type(loc_company_input, faker.company().name());
        sleep(2);

        // Highlight and type in the Phone input field
        Automations.highlight(loc_phone_input);
        sleep(2);
        Automations.type(loc_phone_input, faker.phoneNumber().phoneNumber());
        sleep(2);

        // Highlight and type in the Message input field
        Automations.highlight(loc_message_input);
        sleep(2);
        Automations.type(loc_message_input, faker.lorem().paragraph());
        sleep(2);
    }

    /**
     * Method to click the submit button on the contact form.
     * Highlights the submit button before clicking it.
     */
    public void clickSubmit() {
        Automations.highlight(loc_submit_button);
        sleep(2);
        Automations.click(loc_submit_button);
    }
}
