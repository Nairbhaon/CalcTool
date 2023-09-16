import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AITest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your token:");
        String token = scanner.nextLine();

        System.out.println("Enter a prompt:");
        String prompt = scanner.nextLine();

        List<ChatMessage> messageList = new ArrayList<ChatMessage>();
        messageList.add(new ChatMessage("system","You are a helpful assistant."));
        messageList.add(new ChatMessage("user",prompt));

        OpenAiService service = new OpenAiService(token);

        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .maxTokens(256)
                .messages(messageList)
                .build();
        try {
            List<ChatCompletionChoice> choices = service.createChatCompletion(completionRequest).getChoices();
            for (ChatCompletionChoice c: choices) {
                System.out.println(c.getMessage().getContent());
            }
        } catch (Exception e) {
            System.out.println("Invalid API Key");
            //throw new RuntimeException(e);
        }
    }
}
