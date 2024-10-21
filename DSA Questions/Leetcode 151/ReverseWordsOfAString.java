
public class ReverseWordsOfAString {

    public String reverseWords(String s) {

        String arr[] = s.trim().split("\\s+");

        String res = "";

        for (int i = 0; i < arr.length; i++) {

            res += arr[arr.length - 1 - i] + " ";

        }

        res = res.substring(0, res.length() - 1);

        return res;

    }

}
