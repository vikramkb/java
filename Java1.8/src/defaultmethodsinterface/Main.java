package defaultmethodsinterface;

public class Main {

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        int years = 5;
        double totalPayAmount = savingsAccount.getTotalLoanPayAmount(100000, years);
        System.out.println("Savings account total payment for 5 years = " + totalPayAmount);

        CurrentAccount currentAccount = new CurrentAccount();
        totalPayAmount = currentAccount.getTotalLoanPayAmount(100000, years);
        System.out.println("Current account total payment for 5 years = " + totalPayAmount);

    }
}
