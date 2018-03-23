package testing.ui.utils;

public class Randomizer {

    private static String alphaChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    private static String getRandomString(int iLength, String sAllowedChars) {

        java.util.Random rng = new java.util.Random();
        char[] text = new char[iLength];
        for (int i = 0; i < iLength; i++)
        {
            text[i] = sAllowedChars.charAt(rng.nextInt(sAllowedChars.length()));
        }
        return new String(text);
    }

    public static String getRandomAlphaCharactersString(int iLength) {
        String randomS =  getRandomString(iLength, alphaChars);
        System.out.println("Random string: "+randomS);
        return randomS;
    }
    public static String getRandomEmailAddress(){
        String prefix = getRandomAlphaCharactersString(7);
        String sufix = getRandomAlphaCharactersString(4);
        String randomEmail = prefix+"@"+sufix+".com";
        return randomEmail.toLowerCase();
    }

}
