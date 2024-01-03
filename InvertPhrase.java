import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvertPhrase {

    public static String invertPhrase(String input) {
        Pattern pattern = Pattern.compile("(\\w+(-\\w+)*)|([.,?!])");
        Matcher matcher = pattern.matcher(input);

        String[] wordsAndPunctuation = new String[input.length()];
        int index = 0;

        while (matcher.find()) {
            wordsAndPunctuation[index++] = matcher.group();
        }

        // Invert the array
        StringBuilder invertedPhrase = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            invertedPhrase.append(wordsAndPunctuation[i]);
            if (i > 0 && wordsAndPunctuation[i - 1].matches("\\w+(-\\w+)*")) {
                invertedPhrase.append(" ");
            }
        }

        return invertedPhrase.toString();
    }

    public static void main(String[] args) {
        String input1 = "Good afternoon";
        String output1 = invertPhrase(input1);
        System.out.println("Input: " + input1 + "\nExpected Output: " + output1);

        String input2 = "Hello, how are you?";
        String output2 = invertPhrase(input2);
        System.out.println("\nInput: " + input2 + "\nExpected Output: " + output2);

        String input3 = "Are you twenty-one years old?";
        String output3 = invertPhrase(input3);
        System.out.println("\nInput: " + input3 + "\nExpected Output: " + output3);
    }
}
