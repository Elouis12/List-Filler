
import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FillList{

    static Scanner input;
    public static void main(String[] args){


        input  = new Scanner(System.in);

        // DATES
        System.out.print("What is the starting month? : ");
        int month = input.nextInt();

        System.out.print("What is the day? : ");
        int day = input.nextInt();

        System.out.print("What is the year? : ");
        int year = input.nextInt();

        System.out.print("For how many months? : ");
        int monthsAfter = input.nextInt();

        System.out.print("intervals between each day? : ");
        int interval = input.nextInt();


        // DATE BETWEEN OBJECT
//        DateRangeBetween list = new DateRangeBetween(2021, 5, 22, 7);
        DateRangeBetween list = new DateRangeBetween(year, month, day
                , monthsAfter, interval);


        // AUTOFILL FUNCTION
        System.out.printf("How many entries? : ");
        int entries = input.nextInt();
        autoFill(entries, list.getDates());

    }



    public static void autoFill(int entries, List<String> dates){


        // File inputFile;
        File outputFile;
        PrintWriter pWriter;

        input  = new Scanner(System.in);



        try{

            outputFile = new File("Eso.txt");

			/*if( outputFile.exists() ){

				throw new Exception("File already exists");

			}*/

            pWriter = new PrintWriter(outputFile);

            String name;
            int column = 1; // prints columns of numbers

            for(int order = 1; order <= entries; order+=1 ){



                // SHOWS AS COLUMN TO COPY AND PASTE
                if( order == entries && column == 1){ // NUMBER COLUMN

                    pWriter.write(order + "\n");
                    order = 1;
                    column = 2;
                    pWriter.write("\n\n");

                }else if( order < entries && column == 1){

                    pWriter.write(order + "\n");

                }

                if( order == entries && column == 2){ // NAME COLUMN

                    System.out.printf("Enter name %s : ", order);
                    name = input.nextLine();
                    pWriter.write(name + "\n"); //prints one last time
                    order = 1;
                    column = 3; // prints column of names
                    pWriter.write("\n\n");

                }else if( order < entries && column == 2 ){

                    System.out.printf("Enter name %s : ", order);
                    name = input.nextLine();
                    pWriter.write(name + "\n");

                }


                if( order == entries && column == 3 ){ // DATE COLUMN

                    if( ( order - 1 )  > dates.size() ){ // in case you enter entries larger than there are elements in the arrays, it saves your progress

                        System.out.println("hey");
                        System.exit(1);

                    }else{

                        pWriter.write(dates.get(order - 1) + "\n"); //prints one last time
                    }   
                    break;

                }else if( order < entries && column == 3 ){

                    if( ( order - 1 )  > dates.size() ){ // in case you enter entries larger than there are elements in the arrays, it saves your progress

                        System.out.println("hey");
                        System.exit(1);

                    }else{

                        pWriter.write(dates.get(order - 1) + "\n");
                    }

                }

            }

            input.close();
            pWriter.close();


        }catch(ArrayIndexOutOfBoundsException e){

//            pWriter.close();
            System.out.println(e);

        }catch(Exception e){

            e.printStackTrace();
            System.out.println(e);
        }

    }




}