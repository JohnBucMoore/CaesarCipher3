public class CaesarCipher {
    private String alpha;
    private String shiftedAlpha;
    private int mainKey;

    public CaesarCipher(int key) {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlpha = alpha.substring(key) + alpha.substring(0, key);
        mainKey = key;
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if (Character.isAlphabetic(currChar)) {
                if (Character.isLowerCase(currChar)) {
                    alpha = alpha.toLowerCase();
                    shiftedAlpha = shiftedAlpha.toLowerCase();
                    int currIndex = alpha.indexOf(currChar);
                    encrypted.setCharAt(i, shiftedAlpha.charAt(currIndex));
                } else {
                    alpha = alpha.toUpperCase();
                    shiftedAlpha = shiftedAlpha.toUpperCase();
                    int currIndex = alpha.indexOf(currChar);
                    encrypted.setCharAt(i, shiftedAlpha.charAt(currIndex));
                }
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }

}
