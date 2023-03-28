import java.util.*;

public class TradingSystem {

    public static void main(String[] args) {

        double lastDayClosingPrice = // Input last day closing price of the asset price
        double stopLoss = lastDayClosingPrice * 0.99; // Set stop loss at 1% below opening price
        double targetProfit = lastDayClosingPrice * 1.03; // Set target profit at 3% above opening price

        // Check if the stock price goes above last day's closing price by 2%
        if (getCurrentPrice() >= lastDayClosingPrice * 1.02) {

            // Check if the stock volume traded is more than 20 Crores
            if (getVolumeTraded() >= 200000000) {

                // Check if the stock is in the top 100 market cap companies
                if (isTop100MarketCapCompany()) {

                    // Enter the trade
                    enterTrade();

                    // Set stop loss
                    setStopLoss(stopLoss);

                    // Wait for the trade to close or hit stop loss
                    while (getCurrentPrice() > stopLoss) {

                        // Check if the stock returns a profit of more than 3%
                        if (getCurrentPrice() >= targetProfit) {
                            // Sell the stock
                            sell();
                            break;
                        }

                        // Wait for a minute before checking the stock price again
                        try {
                            Thread.sleep(60000); // Sleep for 1 minute
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static double getCurrentPrice() {
        // Get the current price of the stock
    }

    private static long getVolumeTraded() {
        // Get the volume traded of the stock
    }

    private static boolean isTop100MarketCapCompany() {
        // Check if the stock is in the top 100 market cap companies
    }

    private static void enterTrade() {
        // Enter the trade
    }

    private static void setStopLoss(double stopLoss) {
        // Set stop loss at the specified price
    }

    private static void sell() {
        // Sell the stock
    }
}
