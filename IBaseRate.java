package BankAccountApp;

/**
 * @author Zoey Luu
 */
public interface IBaseRate {

    default double getBaseRate(){
        return 2.5; //benchmark rate
    }

}
