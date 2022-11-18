package FileManaged;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFile {


    public static List<String> sReader() {
        List<String> strings = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("database.txt")))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                strings.add(s);

            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return strings;
    }




}
