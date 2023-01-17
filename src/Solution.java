import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Введите корректный адрес:");
            solution(Main.scanUserInput());
        }
        return sb.toString();
    }
    public static void find(String regex, String fileAddress, HashSet<String> list){

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE|Pattern.UNICODE_CASE);

        String text = readFile(fileAddress);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) { //ВЫВОД ДАТЫ
              list.add(matcher.group());
        }
    }
    public static void solution(String arg) {
        HashSet<String> list = new HashSet<String>();

        String regex1 = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)";
        String regex2 = "((0?[1-9]|[12][0-9]|3[01]) (январ[ья]|феврал[ья]|марта|апрел[ья]|ма[йя]|июн[ья]|июл[ья]|августа|сентябр[ья]|октябр[ья]|ноябр[ья]|декабр[ья])) ((19|20)\\d\\d)";
        String regex3 = "((0?[1-9]|[12][0-9]|3[01]) (январ[ья]|феврал[ья]|марта|апрел[ья]|ма[йя]|июн[ья]|июл[ья]|августа|сентябр[ья]|октябр[ья]|ноябр[ья]|декабр[ья]))";

        String combinedPattern = regex1 + "|" + regex2 + "|" + regex3;

        find(combinedPattern, arg, list);

        System.out.println("Список дат:");

        for (String i : list)
            System.out.println(i);
    }

}