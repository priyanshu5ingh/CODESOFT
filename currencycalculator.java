import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import   
 okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class   
 CurrencyConverter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);   


        // Get base and target currency codes
        System.out.print("Enter base currency code (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine();
        System.out.print("Enter target currency code (e.g., INR, GBP): ");
        String targetCurrency = scanner.nextLine();

        // Fetch exchange rate from ExchangeRate-API
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.exchangeratesapi.io/latest?base=" + baseCurrency)   

                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        // Parse response to get exchange rate
        JsonObject jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
        JsonObject rates = jsonObject.getAsJsonObject("rates");
        double exchangeRate = rates.get(targetCurrency).getAsDouble();

        // Get input amount from user
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Convert amount
        double convertedAmount = amount * exchangeRate;

        // Display result
        System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
    }
}