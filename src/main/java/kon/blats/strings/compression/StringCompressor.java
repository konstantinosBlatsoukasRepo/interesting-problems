package kon.blats.strings.compression;

/**
 * Created by kon on 2/9/2018.
 */
public class StringCompressor {

    private String input;

    public StringCompressor(String input) {
        this.input = input;
    }

    public String compress() {
        if (input.length() == 1) {
            return input;
        }
        char[] uncompressed = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        char current = uncompressed[0];
        int currentCount = 1;
        for (int i = 1; i <= uncompressed.length - 1; i++) {
            char next = uncompressed[i];
            if (next == current) {
                currentCount++;
            } else {
                sb.append(String.valueOf(current)+ currentCount);
                current = next;
                currentCount = 1;
            }
        }
        sb.append(String.valueOf(current) + currentCount);
        return buildCompressedString(sb);
    }

    private String buildCompressedString(StringBuilder sb) {
        String compressedString = sb.toString();
        if (input.length() < compressedString.length()) {
            return input;
        }
        return compressedString;
    }

    public static void main(String[] args) {
        StringCompressor compressor = new StringCompressor("aabcccccaaa");
        System.out.println(compressor.compress());

        StringCompressor compressor2 = new StringCompressor("aab");
        System.out.println(compressor2.compress());

        StringCompressor compressor3 = new StringCompressor("ab");
        System.out.println(compressor3.compress());
    }
}
