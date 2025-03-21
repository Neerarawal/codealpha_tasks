import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AIChatbot {
    private static Map<String, String> responses = new HashMap<>();
    
    static {
        responses.put("hello", "Hello! How can I assist you today?");
        responses.put("how are you", "I'm just a bot, but I'm functioning perfectly!");
        responses.put("what is your name", "I'm an AI chatbot developed to assist you.");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("thanks", "You're welcome! Happy to help.");
    }
    
    public static String getResponse(String input) {
        input = input.toLowerCase();
        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }
        return "I'm sorry, I don't understand that. Can you please rephrase?";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("AI Chatbot initialized. Type 'exit' to quit.");
        
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye! Have a nice day!");
                break;
            }
            
            System.out.println("Chatbot: " + getResponse(userInput));
        }
        
        scanner.close();
    }
}
