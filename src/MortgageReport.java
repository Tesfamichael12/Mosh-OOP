import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private final MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        // calculate the mortgage value
        double mortgage = calculator.calculateMortgage();

        System.out.println("\nMORTGAGE \n----------");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE \n------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
