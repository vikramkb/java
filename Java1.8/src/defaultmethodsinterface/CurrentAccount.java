package defaultmethodsinterface;

public class CurrentAccount implements Account {
    @Override
    public double getInterest() {
        return 15;
    }

    @Override
    public double getTotalLoanPayAmount(double amount, int tenureInYears) {
        return Account.super.getTotalLoanPayAmount(amount, tenureInYears) + getProcessingCharges();
    }

    private double getProcessingCharges() {
        return 5000;
    }
}
