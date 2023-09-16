package CalcTool;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods for interacting with OpenAI models
 */
public class ChatInterface {
    /**
     * Explains an equation
     * @param token API token from an OpenAI account
     * @param equation Text equation to be evaluated or explained
     * @return The model's response
     */
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
        try {
            List<ChatCompletionChoice> choices = service.createChatCompletion(completionRequest).getChoices();
            System.out.println("Results:");
            for (ChatCompletionChoice c: choices) {
                System.out.println(c);
            }
            return choices.get(0).getMessage().getContent();
        } catch (Exception e){
            return "Request failed. Check API key and rate limits.";
        }

    }
}
