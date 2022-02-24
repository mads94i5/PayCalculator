package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        final int normalWeeklyHours = 37;
        double bruttoSalary;

        System.out.print("Please enter the hourly wage: ");
        int hourlyWage = sc.nextInt();

        System.out.print("Please enter the hours you worked this week: ");
        int actualWeeklyHours = sc.nextInt();

        if (actualWeeklyHours < normalWeeklyHours)
        {
            System.out.println("Below the normal weekly hours. Adjusting to normal weekly hours.");
            bruttoSalary = hourlyWage * normalWeeklyHours;
        }
        else if (actualWeeklyHours == normalWeeklyHours)
        {
            System.out.println("Exactly the normal weekly hours.");
            bruttoSalary = hourlyWage * actualWeeklyHours;
        }
        else
        {
            int overtimeHours = actualWeeklyHours - normalWeeklyHours;
            bruttoSalary = (normalWeeklyHours * hourlyWage) + (overtimeHours * hourlyWage * 1.5f);
            System.out.println("Worked " + overtimeHours + " hours of overtime.");
        }
        System.out.println("Brutto salary for the week: " + fmt.format(bruttoSalary));

        final double laborMarketContribution = 1-0.08d;
        double aTax;
        double nettoSalary = bruttoSalary * laborMarketContribution;
        System.out.println("After labor market contribution, there is: " + fmt.format(nettoSalary) + " left.");
        System.out.print("Please enter your personal allowance: ");
        int personalAllowance = sc.nextInt();

        System.out.print("Please enter your withdrawal percentage: ");
        int withdrawalPercentage = sc.nextInt();

        aTax = ((nettoSalary - personalAllowance) * ((double)withdrawalPercentage / 100d));
        System.out.println("A-Tax for the week totals to: " + fmt.format(aTax));
        nettoSalary -= aTax;
        System.out.println("Netto salary for the week: " + fmt.format(nettoSalary));
    }
}
