import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class ScheduleReader {

    public boolean scheduleExists(String filename) {
        String filepath = "./src/data/2024"+filename+".json";
        File file = new File(filepath);
        return file.exists();
    }

    public void errorRead() {
        String filePath = "./output.txt"; // 替换为你的文件路径
        // 读取JSON文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("Error");
            writer.write(System.lineSeparator());
            writer.write("----");
            writer.write(System.lineSeparator());
            // 可以根据需要继续追加更多内容
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void scheduleRead(String filename) {
        Gson gson = new Gson();

        try {
            // 读取JSON文件
            String filepath = "./src/data/2024"+filename+".json";
            FileReader reader = new FileReader(filepath);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // 获取medalsList数组
            JsonArray eventList = jsonObject.getAsJsonArray("data");

            // 将每个JSON对象转换为MedalCount对象并打印
            for (JsonElement element : eventList) {
                String filePath = "./output.txt"; // 替换为你的文件路径

                Event event = gson.fromJson(element, Event.class);

                String time = event.getStartdate();
                LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
                LocalTime now = localTime.plusHours(6);

                String str1 = "time:"+now;
                String str2 = "name:"+event.getItemcodename();
                String str3 = "sport:"+event.getTitle();
                String str4;
                if(event.getAwayname()!=""&&event.getHomename()!=""){
                    str4=event.getAwayname()+"VS"+event.getHomename();
                    System.out.println(str4);
                }else {
                    str4="";
                }
                String str5 = "venue:"+event.getVenuename();
                String str6 = "----";

                try (FileWriter fileWriter = new FileWriter(filePath, true)) {
                    fileWriter.write(str1);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.write(str2);
                    fileWriter.write(System.lineSeparator());
                    if(str4.isEmpty()){
                        fileWriter.write(str3);
                        fileWriter.write(System.lineSeparator());
                    }else {
                        fileWriter.write(str3+" "+str4);
                        fileWriter.write(System.lineSeparator());
                    }
                    fileWriter.write(str5);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.write(str6);
                    fileWriter.write(System.lineSeparator());

                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("time:"+now);
                System.out.println("name:"+event.getItemcodename());
                System.out.print("sport:"+event.getTitle()+" ");
                if(event.getAwayname()!=""&&event.getHomename()!=""){
                    System.out.print(event.getAwayname()+"VS"+event.getHomename());
                }
                System.out.println();
                System.out.println("venue:"+event.getVenuename());
                System.out.println("----");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
