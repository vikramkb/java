package defaultmethodsinterface;

public interface Account {
    default double getTotalLoanPayAmount(double amount, int tenureInYears) {
        return (amount * ( 1 + getInterest() * tenureInYears )) / 100;
    }
    double getInterest();
}
