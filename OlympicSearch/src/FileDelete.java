import java.io.File;

public class FileDelete {
    public void deleteFile() {
        String filepath = "./output.txt";
        File file = new File(filepath);
        if (file.exists()) {
          try {
              file.delete();
          }catch (Exception e){
              e.printStackTrace();
          }
            System.out.println("file is deleted");
        }else {
            System.out.println("file is not exist");
        }
    }
}
