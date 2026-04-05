
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainAI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();

		boolean hasNumber = inputString.matches(".*\\d.*");

		try {
			if (hasNumber) {
				Object order = Class.forName("Order").getDeclaredConstructor().newInstance();
				Method orderOutput = order.getClass().getMethod("OrderOutput", String.class);
				System.out.println(orderOutput.invoke(order, inputString));
			} else {
				Object formal = Class.forName("Formal").getDeclaredConstructor().newInstance();
				Method formalOutput = formal.getClass().getMethod("FormalOutput", String.class);
				System.out.println(formalOutput.invoke(formal, inputString.toLowerCase()));
			}
		} catch (Exception exception) {
			if (hasNumber) {
				System.out.println(fallbackOrderOutput(inputString));
			} else {
				System.out.println(fallbackFormalOutput(inputString.toLowerCase()));
			}
		}

		sc.close();
	}

	private static String fallbackFormalOutput(String inputString) {
		if (inputString.contains("hello") || inputString.contains("meet")) {
			return "Hello Nice to meet you!\nHow may i Help You?";
		}

		if (inputString.contains("help") || inputString.contains("need")) {
			return "Sure i am Will help you but i am not trained well \nso in the future may be i will help you";
		}

		if (inputString.contains("tell me") || inputString.contains("what is")) {
			return "I am in phase of Training, so Sorry for now i cant help you just give me the time i will defenately help in future.....";
		}

		return "\nWrong Input\nTry again\n";
	}

	private static String fallbackOrderOutput(String inputString) {
		StringBuilder output = new StringBuilder();
		String[] words = inputString.split(" ");
         output.append("\nYou placed the Order: \nso below is your order right: \n");
			
		for (int i = 0; i < words.length; i++) {
			String num = words[i].replaceAll("[^0-9]", "");
           if (!num.isEmpty() && i > 0) {
				String product = i > 1 ? words[i - 2] + " " + words[i - 1] : words[i - 1];
				output.append(product).append(" -> ").append(num).append("\n");
			}
		}

		return output.toString();
	}
}
