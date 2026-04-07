import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a year (e.g., 1956): ");
		int year = sc.nextInt();
		System.out.print("Enter month in number between 1 and 12: ");
		int month = sc.nextInt();
		String monthName = month(month);
		int dayInMonth = dayInMonth(month, year);
		int totalDay = totalDay(month, year);
		System.out.println("          " + monthName + " " + year);
		System.out.println("-----------------------------");
		System.out.printf("%4s%4s%4s%4s%4s%4s%4s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
		day(dayInMonth, totalDay);
	}
	public static String month(int a) {
		String month = "";
		switch (a) {
		case 1 : month = "January"; break;
		case 2 : month = "February"; break;
		case 3 : month = "March"; break;
		case 4 : month = "April"; break;
		case 5 : month = "May"; break;
		case 6 : month = "June"; break;
		case 7 : month = "July"; break;
		case 8 : month = "August"; break;
		case 9 : month = "September"; break;
		case 10 : month = "October"; break;
		case 11 : month = "November"; break;
		case 12 : month = "December"; break;
		}
		return month;
	}
	public static void day(int dayInMonth, int totalDay) {
		int spaceDay = (totalDay + 1) % 7;
		int totalPlace = 0;
		for (int i = 1; i <= spaceDay; i++) {
			System.out.print("    ");
			totalPlace++;
		}
		for (int i = 1; i <= dayInMonth; i++) {
			if(totalPlace % 7 == 0 && totalPlace != 0) {
				System.out.printf("\n%4d", i);
			}
			else {
				System.out.printf("%4d", i);
			}
			totalPlace++;
		}
	}
	public static int totalDay(int whichMonth, int year) {
		int totalDay = 0;
		for (int a = 1; a < whichMonth; a++) {
			totalDay += dayInMonth(a, year);
		}
		for(int i = 1; i < year; i++) {
			if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				totalDay += 366;
			}
			else {
				totalDay += 365;
			}
		}
		return totalDay;
	}
	public static int dayInMonth(int whichMonth, int year) {
		int dayInMonth = 0;
		if (whichMonth == 1 || whichMonth == 3 || whichMonth == 5 || whichMonth == 7 || whichMonth == 8 || whichMonth == 10 || whichMonth == 12) {
			dayInMonth = 31;
		}
		else if (whichMonth == 4 || whichMonth == 6 || whichMonth == 9 || whichMonth == 11) {
			dayInMonth = 30;
		}
		else {
			if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			dayInMonth = 29;
			}
			else {
				dayInMonth = 28;
			}
		}
		return dayInMonth;
	}
}