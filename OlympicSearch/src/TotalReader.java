import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TotalReader {
    public void totalRead() {
        Gson gson = new Gson();
        try {
            String filepath = "./src/data/total.json";
            String outputpath = "./output.txt";
            // 读取JSON文件
            FileReader reader = new FileReader(filepath);
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // 获取medalsList数组
            JsonArray medalsList = jsonObject.getAsJsonObject("data").getAsJsonArray("medalsList");

            // 将每个JSON对象转换为MedalCount对象并打印
            for (JsonElement element : medalsList) {
                MedalCount medalCount = gson.fromJson(element, MedalCount.class);

                String str1 = "rank"+medalCount.getRank()+":"+medalCount.getCountryid();
                String str2 = "gold:"+medalCount.getGold();
                String str3 = "silver:"+medalCount.getSilver();
                String str4 = "bronze:"+medalCount.getBronze();
                String str5 = "gold:"+medalCount.getGold();
                String str6 = "total:"+medalCount.getCount();

                try (FileWriter fileWriter = new FileWriter(outputpath, true)) {
                    fileWriter.write(str1);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.write(str2);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.write(str3);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.write(str4);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.write(str5);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.write(str6);
                    fileWriter.write(System.lineSeparator());
                    fileWriter.write("----");
                    fileWriter.write(System.lineSeparator());

                } catch (IOException e) {
                    e.printStackTrace();
                }






                System.out.println("rank"+medalCount.getRank()+":"+medalCount.getCountryid());
                System.out.println("gold:"+medalCount.getGold());
                System.out.println("silver:"+medalCount.getSilver());
                System.out.println("bronze:"+medalCount.getBronze());
                System.out.println("total:"+medalCount.getCount());
                System.out.println("-----");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}