public class Calculate
{
    public static String GetMonthlyPayment(double interest, double totalLoan, double numberOfYears) {
        double monthlyPayment;
        double monthlyInterest = (interest / 100d) / 12d;
        double numberOfPayments = numberOfYears * 12d;

        double base = (1d + monthlyInterest);
        double exponentResult = 1d;

        for (int i = 1; i <= numberOfPayments; i++) {
            exponentResult *= base;
        }

        monthlyPayment = totalLoan * ((monthlyInterest * exponentResult) / (exponentResult - 1));

        return String.format("%.2f",monthlyPayment);
    }
}
