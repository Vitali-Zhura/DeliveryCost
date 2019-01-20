import java.util.Scanner;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Perevozka {

        private int km;

        Perevozka(){
            Scanner scan = new Scanner (System.in);
            int chislo = scan.nextInt();
            if (chislo>0)
                km = chislo;
            else
                System.out.println ("Vvedite pravilnoe chislo");
        }

        void raschet() throws IOException, ParseException {

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/home/vital/IdeaProjects/Perevozka/src/Tarif.json"));
            JSONObject jsonObject =  (JSONObject) obj;
            long result;
            if (km<=10&km>=1)
                result = (Long) jsonObject.get("1-10");
            else if (km<=20&km>=11)
                result = (Long) jsonObject.get("11-100");
            else
                result = (Long) jsonObject.get("bolshe 100");
            System.out.println(result*km);
        }

        public static void main(String[] args)  {
           Perevozka ob = new Perevozka();
            try {
                ob.raschet();
            }

            catch (FileNotFoundException ex){
                System.out.println("File not found");
            }
            catch (ParseException ex) {
                ex.printStackTrace();
            }
            catch (Exception ex){
                System.out.println("Error");
            }

        }

    }

