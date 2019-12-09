public class CaesarCipherTwo {
    int key1;
    int key2;
    private String alpha;
    private String shift1;
    private String shift2;

    public CaesarCipherTwo(int k1, int k2) {
        key1 = k1;
        key2 = k2;
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shift1 = alpha.substring(key1) + alpha.substring(0, key1);
        shift2 = alpha.substring(key2) + alpha.substring(0, key2);
    }

    public void checkCase(char currChar) {
        if (Character.isUpperCase(currChar)) {
            alpha = alpha.toUpperCase();
            shift1 = shift1.toUpperCase();
            shift2 = shift2.toUpperCase();
        } else {
            alpha = alpha.toLowerCase();
            shift1 = shift1.toLowerCase();
            shift2 = shift2.toLowerCase();
        }
    }

    public String encrypt(String input) {
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (Character.isAlphabetic(currChar)) {
                checkCase(currChar);
                int currIndex = alpha.indexOf(currChar);
                if (i % 2 == 0) {
                    output.setCharAt(i, shift1.charAt(currIndex));
                } else {
                    output.setCharAt(i, shift2.charAt(currIndex));
                }
            }
        }
        return output.toString();
    }

    public String decrypt(String input) {
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (Character.isAlphabetic(currChar)) {
                checkCase(currChar);
                int currIndex;
                if (i % 2 == 0) {
                    currIndex = shift1.indexOf(currChar);
                } else {
                    currIndex = shift2.indexOf(currChar);
                }
                output.setCharAt(i, alpha.charAt(currIndex));
            }
        }
        return output.toString();
    }
}
