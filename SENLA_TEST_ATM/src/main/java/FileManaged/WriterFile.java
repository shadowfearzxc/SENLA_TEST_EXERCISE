package FileManaged;


import java.io.*;
import java.io.IOException;
import java.util.Objects;

public class WriterFile {
    public static void write(String text, String path) {
        if(Objects.equals(path, "CashATM.txt")) {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, false)))  {
                FileWriter fstream1 = new FileWriter(path);// конструктор с одним параметром - для перезаписи
                BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
                out1.write("");
            }

            catch (IOException ex) {
                System.out.println(ex.getMessage());
                }
            }


        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)))  {
            bw.write(text);
            bw.write("\n");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
