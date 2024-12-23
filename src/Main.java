public class Main {
    public static void main(String[] args) {

        int principal = (int) Console.readNumber(
                "Principal: ", 1_000, 100_000);
        float annualInterest = (float) Console.readNumber(
                "Annual Interest Rate: ", 1, 30);
        int years = (int) Console.readNumber(
                "Period (Years): ", 1, 30);

        MortgageCalculator mortgageCalculator = new MortgageCalculator(
                principal, annualInterest, years);

        MortgageReport report = new MortgageReport(mortgageCalculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }
}