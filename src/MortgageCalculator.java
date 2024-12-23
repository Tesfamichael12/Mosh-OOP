import java.text.NumberFormat;

public class MortgageCalculator {
    // constants
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private final int principal;
    private final float annualInterest;
    private final int years;

    public MortgageCalculator(int principal, float annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();

        double totalNumberOfPayments = getTotalNumberOfPayments();

        // calculate the monthly interest per month
        double paymentsPerMonth = Math.pow(1 + monthlyInterest, totalNumberOfPayments);

        return principal * (monthlyInterest * paymentsPerMonth) / (paymentsPerMonth - 1);
    }

    public double calculateBalance( double numberOfPaymentsMade) {

        float monthlyInterest = getMonthlyInterest();

        double totalNumberOfPayments = getTotalNumberOfPayments();

        return principal
                * ( Math.pow(1 + monthlyInterest, totalNumberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1+ monthlyInterest, totalNumberOfPayments) - 1);
    }

    public double[] getRemainingBalances(){
        var balances = new double[getTotalNumberOfPayments()];
        for (int month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    private int getTotalNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

   }


