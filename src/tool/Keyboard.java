package tool;

import java.util.Scanner;

public class Keyboard {

  public static String inputString() {
    return new Scanner(System.in).nextLine();
  }

  public static int inputInt() {
    return Integer.parseInt(inputString());
  }

}
