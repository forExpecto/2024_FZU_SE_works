import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        FileDelete fileDelete = new FileDelete();
        fileDelete.deleteFile();

        String filePath = "./input.txt"; // Path to the input file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void processLine(String line) {
        if(line.equals("total")){
            TotalReader reader = new TotalReader();
            reader.totalRead();
        }

        if(line.contains("schedule")){
            String[] parts = line.split(" ");
            String date = parts[1];
            System.out.println(date);
            ScheduleReader reader = new ScheduleReader();
            if(reader.scheduleExists(date)){
                reader.scheduleRead(date);
            }
            if (!reader.scheduleExists(date)) {
                reader.errorRead();
            }
        }

    }
}
