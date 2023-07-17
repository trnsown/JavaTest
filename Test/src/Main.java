import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int countVnLetters(String input) {
        Map<String, String> telex = new HashMap<>();
        telex.put("aw", "ă");
        telex.put("aa", "â");
        telex.put("dd", "đ");
        telex.put("ee", "ê");
        telex.put("oo", "ô");
        telex.put("ow", "ơ");
        telex.put("w", "ư");

        int count = 0;
        int index = 0;
        while (index < input.length()) {
            boolean letter = false;
            for (int i = 2; i >= 1; i--) {
                if (index + i <= input.length()) {
                    String substring = input.substring(index, index + i);
                    if (telex.containsKey(substring)) {
                        count++;
                        index += i;
                        letter = true;
                        break;
                    }
                }
            }
            if (!letter) {
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "hfdawhwhcoomdd";
        int output = countVnLetters(input);
        System.out.println(output);
    }
}
