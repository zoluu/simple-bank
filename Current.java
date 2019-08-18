package BankAccountApp;

/**
 * @author Zoey Luu
 */
public class Current extends Account {
    private int debitCardNumber;
    private int debitCardPIN;

    /**
     * Constructor to initialise current account properties
     * @param name name of the person to create account for
     * @param niNumber national insurance number of the person
     * @param initialDeposit initial deposit for creating the account
     */
    public Current(String name, String niNumber, double initialDeposit) {
        super(name, niNumber, initialDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    /**
     * Set the interest rate for the current account
     */
    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    /**
     * Set the debit card number and debit card pin number
     */
    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10,12));
        debitCardPIN = (int) (Math.random() * Math.pow(10,4));
    }

    /**
     * Prints current account specific information
     */
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Current Account Features:" +
                        "\n  - Debit Card Number: " + debitCardNumber +
                        "\n  - Debit Card PIN: " + debitCardPIN
        );
    }

}
