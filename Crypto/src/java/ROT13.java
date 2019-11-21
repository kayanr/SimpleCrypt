import static java.lang.Character.*;

public class ROT13  {
    private final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private Integer delta;

    ROT13(Character cs, Character cf) {
        delta = cf.compareTo(cs);
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        delta = 13;
        return encrypt(text);
    }
    public Character matchCase(Character input, Character output) {
        if(isUpper(input)) output = output.toString().toUpperCase().charAt(0);
        else output = output.toString().toLowerCase().charAt(0);
        return output;
    }

    public Boolean isUpper(Character a) { return String.valueOf(a).matches("[A-Z]");}
    public Boolean isAlpha(Character c) { return String.valueOf(c).matches("[A-Za-z]");}

    public Integer getAlphabetIndex(char letter) {
        Integer index = -1;
        for (int i = 0; i < alphabet.length; i++) {
            if (String.valueOf(letter).toUpperCase().equals(String.valueOf(alphabet[i]))) {
                index = i;
                break;
            }
        }
        return index;
    }

    public String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            Integer index = getAlphabetIndex(text.charAt(i)) + delta;
            Character in = (!isAlpha(text.charAt(i))) ?
                    text.charAt(i) :
                    (index < alphabet.length) ?
                            alphabet[index] :
                            alphabet[index - alphabet.length];
            sb.append(matchCase(text.charAt(i), in));
        }
        return sb.toString();
    }

    public String decrypt(String text) {
        delta = alphabet.length - delta;
        return encrypt(text);
    }

    public  String rotate(String s, Character c) {
        StringBuilder sb = new StringBuilder();
        delta = c.compareTo(s.charAt(0));
        for(int i = 0; i < s.length(); i++){
            char letter;
            if(i + delta < s.length()){
                letter = s.charAt(i + delta);
            }
            else {
                letter = s.charAt(i + delta - s.length());
            }
            sb.append(letter);
        }
        return sb.toString();
    }

}
