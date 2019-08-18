package BankAccountApp;

/**
 * @author Zoey Luu
 */
public class Savings extends Account {
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    /**
     * Constructor to initialise savings account properties
     * @param name name of the account holder
     * @param niNumber national insurance of the account holder
     * @param initialDeposit initial amount to deposit to savings account
     */
    public Savings(String name, String niNumber, double initialDeposit) {
        super(name, niNumber, initialDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    /**
     * Interest rate for savings account
     */
    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    /**
     * Set the safety deposit box ID and key
     */
    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    /**
     * Print savings account specific information
     */
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Savings Account Features:" +
                        "\n  - Safety Deposit Box ID: " + safetyDepositBoxID +
                        "\n  - Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }
}
