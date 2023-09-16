import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.List;

public class ChatInterface {
    public static String explainEquation(String token, String equation){
        OpenAiService service = new OpenAiService(token);

        List<ChatMessage> messageList = new ArrayList<ChatMessage>();
        messageList.add(new ChatMessage("system","You are a helpful math assistant that explains equations and their " +
                "solutions in an easily understandable way."));
        messageList.add(new ChatMessage("user","Explain the equation " + equation + "."));

        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .maxTokens(256)
                .messages(messageList)
                .build();
        List<ChatCompletionChoice> choices = service.createChatCompletion(completionRequest).getChoices();
        System.out.println("Results:");
        for (ChatCompletionChoice c: choices) {
            System.out.println(c);
        }
        return choices.get(0).getMessage().getContent();
    }
}
