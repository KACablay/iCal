/******************************************************
* iCal Version 1.0.0
* Date Created: February 23, 2016
* Author: Team Seis
* Class: ICS 314
* This program is a simple output implementation
* of calendar using iCal4.
*******************************************************/

//Imports java API class for IO
import java.io.*;

public class iCal {

   private String version =    "VERSION:1.0 \n";
   private String prodid =     "PRODID:TeamSeis \r\n";
   private String vcalBegin =   "BEGIN:VCALENDAR\r\n";
   private String vcalEnd =     "END:VCALENDAR\r\n";
   private String eventBegin = "BEGIN:VEVENT\r\n";
   private String eventEnd =   "END:VEVENT\r\n";

    /************************************
    * Method: Main Method
    * Creates the calendar.
    *************************************/
    public static void main (String[]args){
      iCal myCalendar = new iCal();
      myCalendar.write("myCalendar");//to be pass by the name parameter on method call write
    }
    
    /*************************************
    * Method: Write
    * @param: name
    * This method creates the calendar
    * and output it using buffer reader
    * to a .ics file on the same
    * directory of this folder
    *************************************/
    public void write(String name ){

        StringBuilder builder = new StringBuilder();
        builder.append(name); //parameter for the main method, this is the name of the output file.
        builder.append(".ics");

        String testExample = "DTSTART:20160512T13000000Z\nDTEND:20160512T14000000Z\n" +
                             "SUMMARY:Study for Exam\nLOCATION:Hamilton Building\n";

        try {

            File file = new File(builder.toString());//creates a file following the iCal format
            if (!file.exists()) {
                file.createNewFile();//creates or overwrites the .ics file on the folder
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());//writes the data on the file
            BufferedWriter bw = new BufferedWriter(fw);//forwards the input to be written on the file
            bw.write(vcalBegin);
            bw.write(version);
            bw.write(prodid);
            bw.write(eventBegin);
            bw.write(testExample);
            bw.write(eventEnd);
            bw.write(vcalEnd);
            bw.close();
            System.out.println("File is successfully outputted.");
        } catch (IOException e) {
            e.printStackTrace();//catches IO errors.
        }
    }
}