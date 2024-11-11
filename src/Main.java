import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean helper = true;
        while (helper == true) {
            System.out.println("What do you want to do");
            System.out.println("1. create a file");
            System.out.println("2. write in file");
            System.out.println("3. read the file");
            System.out.println("4. end the program");
            int talFile = input.nextInt();
            if (talFile == 1) {
                createFile();
            } else if (talFile == 2) {
                writeFile();
            } else if (talFile == 3) {
                readFile();
            } else if (talFile == 4) {
                System.out.println("The program has ended");
                helper = false;
            }
            else {
                System.out.println("it has to be a number between 1 and 3");
            }
        }

    }

    public static void createFile() {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e){
                System.out.println("An error occured");
                e.printStackTrace();
            }

    }
    public static void readFile() {
    try {
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred");
        e.printStackTrace();
    }

    }
    public static void writeFile() {
    Scanner input = new Scanner(System.in);
        try {
            System.out.println("Write your text");
            String text = input.nextLine();
        FileWriter myWriter = new FileWriter("filename.txt");
        myWriter.write(text);
        myWriter.close();
        System.out.println("Succesfully wrote to the file");
    } catch (IOException e) {
        System.out.println("An error occured");
        e.printStackTrace();
    }
    }
}