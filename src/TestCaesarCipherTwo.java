import edu.duke.FileResource;

public class TestCaesarCipherTwo {
    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String decompose(String input, int start, int step) {
        StringBuilder output = new StringBuilder();
        for (int i = start; i < input.length(); i+=step) {
            output.append(input.charAt(i));
        }
        return output.toString();
    }

    public String compose(String h1, String h2) {
        StringBuilder composite = new StringBuilder();
        for (int i = 0; i < h1.length(); i++) {
            composite.append(h1.charAt(i));
            if (i < h2.length()) {
                composite.append(h2.charAt(i));
            }
        }
        return composite.toString();
    }

    public int[] freqs(String input) {
        int[] freqs = new int[26];
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                freqs[alpha.indexOf(input.charAt(i))] += 1;
            }
        }
        return freqs;
    }

    public int maxIndex(int[] freqs) {
        int maxIndex = 0;
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] > freqs[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int dkey(int maxIndex) {
        int dkey = maxIndex - 4;
        if (maxIndex < 4) {
            dkey = 26 - (4 - maxIndex);
        }
        return dkey;
    }

    public int breakKey(String h) {
        int[] freqs = freqs(h);
        int maxIndex = maxIndex(freqs);
        return dkey(maxIndex);
    }

    public String breakCaesarCipher(String input) {
        String h1 = decompose(input, 0, 2);
        String h2 = decompose(input, 1, 2);
        int dkey1 = breakKey(h1);
        int dkey2 = breakKey(h2);
        CaesarCipherTwo cc = new CaesarCipherTwo(dkey1, dkey2);
        return cc.decrypt(input);
    }

    public void run() {
        FileResource fr = new FileResource();
        String input = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
        String h1 = decompose(input, 0, 2);
        String h2 = decompose(input, 1, 2);
        System.out.println(h1);
        System.out.println(h2);
        String composite = compose(h1,h2);
        System.out.println(composite);
        String encrytped = cc.encrypt(composite);
        System.out.println(encrytped);
        String decrypted = cc.decrypt(encrytped);
        System.out.println(decrypted);
        System.out.println(breakCaesarCipher(encrytped));
    }

    public static void main(String[] args) {
        TestCaesarCipherTwo test = new TestCaesarCipherTwo();
        test.run();
    }

}
