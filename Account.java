package BankAccountApp;

/**
 * @author Zoey Luu
 */
public abstract class Account implements IBaseRate{
    private String name;
    private String niNumber;
    String accountNumber;
    private double balance;
    double rate;
    private static int index = 10000;


    // Constructor to set base properties and initialise the account

    /**
     * Account constructor
     * @param name name of person to create account for
     * @param niNumber the national insurance number of the person
     * @param initialDeposit the initial deposit for the account
     */
    Account(String name, String niNumber, double initialDeposit) {
        this.name = name;
        this.niNumber = niNumber;
        balance = initialDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();

        getBaseRate();
        setRate();
    }

    /**
     * Sets the rate
     */
    public abstract void setRate();

    /**
     * Creates an account number
     * @return the new account number as a string
     */
    private String setAccountNumber() {
        String lastTwoNIDigits = niNumber.substring(niNumber.length()-3,niNumber.length()-1);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoNIDigits + uniqueID + randomNumber;
    }

    /**
     * Calculates the accrued interest
     */
    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest £" + accruedInterest);
        printBalance();
    }

    /**
     * Updates account balance depending on deposit amount
     * @param amount the deposit amount
     */
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Depositing £" + amount);
        printBalance();
    }

    /**
     * Updates the account balance depending on withdrawal amount
     * @param amount the withdrawal amount
     */
    public void withdraw(double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing £" + amount);
        printBalance();
    }

    /**
     * Updates the account depending on the transfer amount
     * @param transferTo the name of the account to transfer money to
     * @param amount the amount to transfer
     */
    public void transfer(String transferTo, double amount) {
        balance = balance - amount;
        System.out.println("Transferring £" + amount + " to " + transferTo);
        printBalance();
    }

    /**
     * Displays account balance
     */
    public void printBalance() {
        System.out.println("--Your balance is now £" + balance);
    }

    /**
     * Shows account information
     */
    public void showInfo() {
        System.out.println(
                "NAME: " + name +
                        "\n ACCOUNT NUMBER: " + accountNumber +
                        "\n BALANCE: " + balance +
                        "\n RATE: " + rate + "%"
        );
    }
}
