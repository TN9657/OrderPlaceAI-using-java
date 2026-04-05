import java.util.*;

public class Order {

    public String OrderOutput(String s) {
        StringBuilder output = new StringBuilder();

        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {

            // Extract digits from word (like 3kg → 3)
            String num = words[i].replaceAll("[^0-9]", "");

            if (!num.isEmpty()) {

                String count = num;

                // Previous word is product
                if (i > 0) {
                    String product = words[i - 2]+" "+words[i-1];

                    output.append(product)
                          .append(" ---> ")
                          .append(count)
                          .append("\n");
                }
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        Order o = new Order();
        System.out.println("\nYou placed the Order: \nso below is your order right: \n" + o.OrderOutput(inputString));
    }
}