package Week_01.Engineerin_Concepts.FinancialForecasting;


public class FinancialForecaster {

    // Recursive function to calculate future value
    public static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) return currentValue;
        return forecast(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized recursive version with memoization (optional)
    public static double forecastMemo(double currentValue, double growthRate, int years, double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = forecastMemo(currentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 10000;     // ₹10,000
        double annualGrowthRate = 0.08;  // 8%
        int forecastYears = 5;

        // Basic recursion
        double futureValue = forecast(presentValue, annualGrowthRate, forecastYears);
        System.out.printf("Future Value (Recursion): ₹%.2f%n", futureValue);

        // Optimized recursion using memoization
        double[] memo = new double[forecastYears + 1];
        double futureValueMemo = forecastMemo(presentValue, annualGrowthRate, forecastYears, memo);
        System.out.printf("Future Value (Memoized): ₹%.2f%n", futureValueMemo);
    }
}

