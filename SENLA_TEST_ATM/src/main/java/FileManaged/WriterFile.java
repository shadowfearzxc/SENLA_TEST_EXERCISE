package FileManaged;


import java.io.*;
import java.io.IOException;
import java.util.Objects;

public class WriterFile {
    public static void write(String text, String path){
        if (Objects.equals(path, "CashATM.txt")) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
                bw.write("" + text);
            }

            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

          else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                    bw.write(text);
                    bw.write("\n");
                }

                catch(IOException ex) {
                    System.out.println(ex.getMessage());
                }
        }
        }
    }

