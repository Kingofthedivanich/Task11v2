import java.util.Scanner;

public class Main {

    public static String scanUserInput(){
        String r;
        Scanner scanner = new Scanner(System.in);
        r = scanner.next();
        return r;
    }

    public static void main(String[] args) {

        System.out.println("Введите адрес файла: "); //C:\Users\frost\Desktop\inf\Task11v2\Tests\test01
        String gog = scanUserInput();
        Solution.solution(gog);

    }

}