package defaultmethodsinterface;

public class SavingsAccount implements Account {
    @Override
    public double getInterest() {
        return 14;
    }
}
