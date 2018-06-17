import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputText inputText = new ConsoleInputText();
        String str = inputText.readText();
        inputText.showInputText();
        ParseText parseText = new SpaceParseText();
        List<String> words = parseText.handle(str);
        MentionListCreator mentionListCreator = new MentionListCreator(words);
        Map<String, Integer> mentionList = mentionListCreator.toMentionList();
        System.out.println(mentionListCreator.toMentionList());
        Search searching = new WordSearch(mentionList);
        try {
            searching.inputWordToSearch();
            searching.showMentionQuantity();
        } catch (WordNotFoundException e) {
            e.printStackTrace();
        }
    }
}