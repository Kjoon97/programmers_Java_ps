import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean inTag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                if (word.length() > 0) {
                    sb.append(word.reverse());
                    word.setLength(0);
                }
                inTag = true;
                sb.append(c);
            } else if (c == '>') {
                inTag = false;
                sb.append(c);
            } else if (inTag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    sb.append(word.reverse());
                    sb.append(c);
                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }
        }

        if (word.length() > 0) {
            sb.append(word.reverse());
        }

        System.out.println(sb);
    }
}