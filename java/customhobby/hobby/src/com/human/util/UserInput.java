package com.human.util;

import java.util.Scanner;

public class UserInput {

		private static Scanner sc = new Scanner(System.in);

		public static int inputInt(String st) {
			System.out.println(st + " 숫자를 입력하세요.>>");
			return Integer.parseInt(sc.nextLine());
		}

		public static String inputString(String st) {
			System.out.println(st + " hobby를 입력하세요.>>");
			return sc.nextLine();
		}

}
