import edu.duke.FileResource;

public class TestCaesarCipher {
    private String alpha;

    public int[] countLetters(String input) {
        alpha = "abcdefghijklmnopqrstuvwxyz";
        input = input.toLowerCase();
        int[] freqs = new int[26];
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                freqs[alpha.indexOf(input.charAt(i))] += 1;
            }
        }
        return freqs;
    }

    public int maxIndex(String input) {
        int maxIndex = 0;
        int[] freqs = countLetters(input);
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] > freqs[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int decryptKey(int max) {
        int dkey = max - 4;
        if (max < 4) {
            dkey = 26 - (4 - max);
        }
        return dkey;
    }

    public String breakCaesarCipher(String input) {
        int max = maxIndex(input);
        int dkey = decryptKey(max);
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.decrypt(input);
    }

    public void simpleTests() {
        FileResource fr = new FileResource();
        String s = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(s);
        //String decrypted = cc.decrypt(encrypted);
        System.out.println(encrypted);
        //System.out.println(decrypted);
        System.out.println(breakCaesarCipher(encrypted));
    }

    public static void main(String[] args) {
        TestCaesarCipher tcc = new TestCaesarCipher();
        tcc.simpleTests();
    }
}
