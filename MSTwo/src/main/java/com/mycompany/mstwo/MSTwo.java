/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mstwo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author MP
 */
public class MSTwo {

    public static void main(String[] args) {
        
        String TimeInInput;
        String TimeOutInput;
        int count = 0;
        String[] daysOfWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
        String[] TimeInCapture = new String[5];
        String[] TimeOutCapture = new String[5];
        double weekHoursWorked =0;
        double HourlyRate = 357.14;//285714285721;
        double sssContribution = 1125.00/4;
        double pagIbigContribution = 100/4;
        double philHealthContribution = 1800/4;
        double taxCalculation = (2500+((60000-33333)*.25))/4;
        double late = 0;
        double overTime = 0;
        double weekLateHours = 0;
        double weekOverTime = 0;
        
        do{
            count = count +1;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Time In "+daysOfWeek[count-1]+":");
                TimeInInput = sc.nextLine();
                TimeInCapture[count-1] = TimeInInput;
                System.out.println("Enter Time Out "+daysOfWeek[count-1]+":");
                TimeOutInput = sc.nextLine(); 
                TimeOutCapture[count-1] = TimeOutInput;

                //Hours Worked Calculation
                String tIn = TimeInInput;//manually change this for now
                String tOut = TimeOutInput;//manually change this now

                //Time In
                String tInArr[] = tIn.split(":");//conversion of timeIn to array splitting between ":"
                for (int i = 0; i < tInArr.length; i++){}

                double TimeInHour = Integer.parseInt(tInArr[0]);
                double TimeInMinutes = Integer.parseInt(tInArr[1]);

                if ((TimeInHour == 8 && TimeInMinutes < 11)){//grace period            
                    TimeInHour = 8;
                    TimeInMinutes = 00;
                } else if(TimeInHour <= 7){//if earlier than 8AM
                    TimeInHour = 8;
                } else if((TimeInHour == 12 &&((TimeInMinutes >= 1) &&(TimeInMinutes <= 59)))){//if login falls on breaktime
                    TimeInMinutes = 0;
                }
                //Time Out
                String tOutArr[] = tOut.split(":");//conversion of timeOut to array splitting between ":"
                for (int i = 0; i < tOutArr.length; i++){}

                double TimeOutHour = Integer.parseInt(tOutArr[0]);
                double TimeOutMinutes = Integer.parseInt(tOutArr[1]);

                //Calculation
                double TotalMinutesWorkedIn = ((TimeInHour*60) + TimeInMinutes);//conversion of time to minutes - in
                
                late = TotalMinutesWorkedIn - 480; //calculation of late  
                
                //check break time
                if ((TotalMinutesWorkedIn >= 480) && (TotalMinutesWorkedIn <= 779)){
                    TotalMinutesWorkedIn = (TotalMinutesWorkedIn+60);
                }
                
                double TotalMinutesWorkedOut = ((TimeOutHour*60) + TimeOutMinutes); //conversion of time to minutes - out

                double TotalHoursWorked = (TotalMinutesWorkedOut - TotalMinutesWorkedIn);//calculation of hours in a day                
                
                overTime = TotalMinutesWorkedOut - 1020; //calculation of OT     
                
                weekLateHours = late + weekLateHours; //calculation of late in a week  
                weekOverTime = weekOverTime + overTime; //calculation of OT in a week    
                weekHoursWorked = TotalHoursWorked + weekHoursWorked;//hours worke in a week
                
                if (count == 5){//output
                    System.out.println("\n");
                                        System.out.println("+-------------------------------------+---------------------------+");
                                        System.out.printf("| %-35s | %-25s |\n", "Employee Details", "Details");
                                        System.out.println("+-------------------------------------+---------------------------+");
                                        System.out.printf("| %-35s | %-25s |\n", "Employee Number", "10004");
                                        //System.out.println("+---------------------------+---------------------------+");
                                        System.out.printf("| %-35s | %-25s |\n", "Employee Name", "Reyes, Isabella");
                                        //System.out.println("+---------------------------+---------------------------+");
                                        System.out.printf("| %-35s | %-25s |\n", "Gross Weekly Rae", "15,000.00");
                                        //System.out.println("+---------------------------+---------------------------+");
                                        System.out.printf("| %-35s | %-25s |\n", "Rice Subsidy Allowance (Monthly)", "1,500.00");
                                       //System.out.println("+---------------------------+---------------------------+");
                                        System.out.printf("| %-35s | %-25s |\n", "Clothing Allowance (Monthly)", "1,000.00");
                                        //System.out.println("+---------------------------+---------------------------+");
                                        System.out.printf("| %-35s | %-25s |\n", "Phone Allowance (Monthly)", "2,000.00");
                                        System.out.println("+-------------------------------------+---------------------------+");
                            System.out.println("\n");
                                        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
                                        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Time Sheet", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
                                        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
                                        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "In", TimeInCapture[0], TimeInCapture[1], TimeInCapture[2], TimeInCapture[3], TimeInCapture[4]);
                                        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Out", TimeOutCapture[0], TimeOutCapture[1], TimeOutCapture[2], TimeOutCapture[3], TimeOutCapture[4]);
                                        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
                            System.out.println("\n");            
                                        System.out.println("+--------------------------------+-----------------+");
                                        System.out.printf("| %-30s | %-15s |\n", "Total Hours", "Hours");
                                        System.out.println("+--------------------------------+-----------------+");
                                        System.out.printf("| %-30s | %-15s |\n", "Hours Worked in this week", Math.ceil((weekHoursWorked+120)/60));
                                        System.out.printf("| %-30s | %-15s |\n", "Late in this week", weekLateHours/60);
                                        System.out.printf("| %-30s | %-15s |\n", "Overtime in this week", weekOverTime/60);
                                        System.out.println("+--------------------------------+-----------------+");
                                        
                                double totalDeduction = sssContribution + pagIbigContribution + philHealthContribution;
                                double totalAllowance = Math.ceil((1500+2000+1000)/4);
                                double totalOverTime = Math.ceil((weekOverTime/60) * (HourlyRate * 1.2));
                                double totalLate = Math.ceil((weekLateHours/60) * HourlyRate);
                                double totalTaxableSalary = ((Math.ceil((((weekHoursWorked-weekOverTime)+120)/60)*HourlyRate)) + totalAllowance + totalOverTime) - (totalDeduction + totalLate); 
                                double totalSalary =  totalTaxableSalary - Math.ceil(taxCalculation);
                                
                                System.out.println("\n");  
                                        System.out.println("+--------------------------------+-----------------+");
                                        System.out.printf("| %-30s | %-15s |\n", "Net Wage Calculation", "Amount");
                                        System.out.println("+--------------------------------+-----------------+");
                                        System.out.printf("| %-30s | %-15s |\n", "Gross Salary", Math.ceil((((weekHoursWorked-weekOverTime)+120)/60)*HourlyRate));
                                        System.out.printf("| %-30s | %-15s |\n", "Total Allowances (Weekly)", totalAllowance);
                                        System.out.printf("| %-30s | %-15s |\n", "Total Deductions (Benefits)", totalDeduction);
                                        System.out.printf("| %-30s | %-15s |\n", "Total Deductions (Deliquency)", Math.ceil(totalLate));
                                        System.out.printf("| %-30s | %-15s |\n", "Total Deductions (Tax)", Math.ceil(taxCalculation));
                                        System.out.printf("| %-30s | %-15s |\n", "Total Overtime Pay", Math.ceil(totalOverTime));
                                        System.out.println("+--------------------------------+-----------------+");
                                        System.out.printf("| %-30s | %-15s |\n", "Total Take Home Pay", totalSalary);
                                        System.out.println("+--------------------------------+-----------------+");
                }
            }
        while(count<5);
    }
}
