package week06_greedy.necessary;

import java.util.*;

public class P1213_CreatingPalindrome {

    public static final String NOT_PALINDROME = "I'm Sorry Hansoo";
    public static char oddAlphabet = '\0';
    public static Map<Character, Integer> alphabetCounts = new TreeMap<>();
    public static String englishName;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        englishName = sc.next();

        if (!checkPalindromable()) {
            System.out.println(NOT_PALINDROME);
            return;
        }

        String palindrome = createPalindrome();
        System.out.println(palindrome);
    }

    private static void countAlphabet() {
        for (char c : englishName.toCharArray())
            alphabetCounts.put(c, alphabetCounts.getOrDefault(c, 0) + 1);
    }

    private static boolean checkPalindromable() {

        countAlphabet();

        for (char key : alphabetCounts.keySet()) {
            int alphabetCnt = alphabetCounts.get(key);

            // 홀수 개인 알파벳 감지
            if (alphabetCnt % 2 != 0) {
                // oddAlphabet 점검; 이전에 이미 oddAlphabet 이 발견된 경우 => return false / 그 외의 경우 => oddAlphabet 으로 설정
                if (oddAlphabet >= 'A' && oddAlphabet <= 'Z')
                    return false;

                oddAlphabet = key;
            }
        }

        return true;
    }

    private static String createPalindrome() {

        String palindrome = "";

        // key(알파벳) 기준으로 alphabetCounts 정렬
        List<Character> keySet = new ArrayList<>(alphabetCounts.keySet());

        // 팰린드롬의 앞부분 채우기
            // 짝수 (ex.6) => 0~2
            // 홀수 (ex.5) => 0~1
        StringBuilder pre = new StringBuilder();
        for (Character k : keySet)
            pre.append(String.valueOf(k).repeat(alphabetCounts.get(k) / 2));

        palindrome += pre;

        // (홀수 길이인 경우) 팰린드롬의 중간
        if (oddAlphabet != '\0')
            palindrome += oddAlphabet;

        // 팰린드롬의 뒷부분 채우기
        StringBuilder post = pre.reverse();
        palindrome += post;

        return palindrome;
    }
}
