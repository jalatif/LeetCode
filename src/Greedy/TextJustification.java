package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 4/16/15.
 */
public class TextJustification {

    public static List<String> fullJustify(String[] words, int L) {
        int line_index = 0, word_index = 0;
        List<String> lines = new ArrayList<String>();

        while (word_index < words.length) {
            int char_count = 0;
            int num_words = 0;
            int wi = word_index;
            while (wi < words.length) {
                char_count += words[wi++].length();
                if (char_count > L) break;
                char_count += 1;
                num_words++;
            }
            if (num_words == 1) {
                StringBuilder line = new StringBuilder(words[word_index]);
                int diff = L - line.length();
                for (int i = 0; i < diff; i++)
                    line.append(" ");
                if (line.length() > L) {
                    line.setLength(L);
                }
                lines.add(line.toString());
                word_index++;
                line_index++;
            } else {
                word_index += num_words;
                int diff = L;
                for (int i = word_index - num_words; i < word_index; i++) {
                    diff -= words[i].length();
                }
                int spaces = num_words - 1;
                StringBuilder line = new StringBuilder();
                if (word_index >= words.length) {
                    for (int i = word_index - num_words; i < word_index; i++) {
                        line.append(words[i]).append(" ");
                    }
                    diff = L - line.length();
                    for (int i = 0; i < diff; i++)
                        line.append(" ");
                } else {
                    for (int i = word_index - num_words; i < word_index; i++) {
                        line.append(words[i]);
                        int gapAdd = 0;
                        if (spaces > 0)
                            gapAdd = (int) Math.ceil((diff * 1.0) / spaces);
                        for (int j = 0; j < gapAdd; j++) {
                            line.append(" ");
                        }
                        diff -= gapAdd;
                        spaces -= 1;
                    }
                }
                if (line.length() > L) {
                    line.setLength(L);
                }
                lines.add(line.toString());
                line_index++;
            }
        }
        return lines;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words2 = {""};
        String[] words3 = {"Listen","to","many,","speak","to","a","few."};
        String[] words4 = {"Here","is","an","example","of","text","justification."};
        List<String> lines = fullJustify(words4, 16);
        for (String s : lines)
            System.out.println(s + "<-");
    }
}
