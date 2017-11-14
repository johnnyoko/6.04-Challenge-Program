/**
 * Hurricane description:
 *
 * @author:
 * @version:
 *
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Hurricanes2
{
    public static void main(String[] args)throws IOException
    {       
        double pressureAverage = 0.0;
        double maxPressure = 0.0;
        double minPressure = 0.0;
        double windAverage = 0.0;       
        double maxWindSpeed = 0.0;
        double minWindSpeed = 0.0;
        double categoryAverage = 0.0;
        double maxCategory = 0.0;
        double minCategory = 0.0;
        int category1 = 0;
        int category2 = 1;
        int category3 = 2;
        int category4 = 3;
        int category5 = 4;
           
        int arrayLength = 59;
        int [] year = new int[arrayLength];
        String [] month = new String[arrayLength];
        int [] pressure = new int[arrayLength];
        double [] windSpeed = new double[arrayLength];
        String [] name = new String[arrayLength];
        int [] category = new int[arrayLength];
        
        File newData = new File("/Users/johnny/Desktop/AP Computer Science/Modules/Module 6/Assignments/6.04 Challenge Program/hurcdata2.txt");
        Scanner inFile = new Scanner(newData);
        int index = 0;
        while (inFile.hasNext())
        {
            year[index] = inFile.nextInt();
            month[index] = inFile.next();
            pressure[index] = inFile.nextInt();
            windSpeed[index] = inFile.nextInt();
            name[index] = inFile.next();
            
            index++;
        }
        
        for (int i = 0; i < 59; i++)
        {
            double windData = Double.parseDouble(inFile.next());
            windData = windData*1.15077945;
            if (windData < 95.0) 
            {
            category[index] = 1;
            category1++;
            } 
            else if (windData <= 110) 
            {
                category[index] = 2;
                category2++;
            } 
            else if (windData <= 129) 
            {
                category[index] = 3;
                category3++;
            } 
            else if (windData <= 156 ) 
            {
                category[index] = 4;
                category4++;
            } 
            else if (windData > 156) 
            {
                category[index] = 5;
                category5++;
            }
            windSpeed[index] = windData;
            categoryAverage += category[index];
            windAverage += windSpeed[index];
            name[index] = inFile.next();
            int categoryV2 = category[index];
            int pressure2 = pressure[index];
            double windSpeed2 = windSpeed[index];
            if  (maxCategory < categoryV2) 
            {
                maxCategory = category[index];
                minCategory = category[index];
            }
            if (minCategory > categoryV2) 
            {
                minCategory = category[index];
            }            
            if (maxPressure < pressure2) 
            {
                maxPressure = pressure[index];
                minPressure = pressure[index];
            }
            if (minPressure > pressure2)
            {
                minPressure = pressure[index];
            }           
            if (maxWindSpeed < windSpeed2) 
            {
                maxWindSpeed = windSpeed[index];
                minWindSpeed = windSpeed[index];
            }
            if (minWindSpeed > windSpeed2) 
            {
                minWindSpeed = windSpeed[index];
            }          
            index++;
        }
    
        //Output - print table using printf to format the columns


        System.out.println("                      Hurricanes 1980 - 2006");
        System.out.println();
        System.out.println("Year     Hurricane    Category     Pressure (mb)     Wind Speed (mph)");
        System.out.println("=====================================================================");
        System.out.print("Average: ");
        System.out.printf("%23.1f%18.2f%20.2f\n", categoryAverage, pressureAverage, windAverage);
        System.out.print("Maximum: ");
        System.out.printf("%23.0f%18.0f%20.2f\n", maxCategory, maxPressure, maxWindSpeed);
        System.out.print("Minimum: ");
        System.out.printf("%23.0f%18.0f%20.2f\n\n", minCategory, minPressure, minWindSpeed);
        System.out.println("Number of Category 1: " + category1);
        System.out.println("Number of Category 2: " + category2);
        System.out.println("Number of Category 3: " + category3);
        System.out.println("Number of Category 4: " + category4);
        System.out.println("Number of Category 5: " + category5);
        System.out.println("=====================================================================");
        inFile.close();
    }
}
