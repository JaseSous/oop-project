import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QLBH {
    protected static DS_Sach ds_Sach;

    public void loadFileDSSach(){
        try {
            String FilePath = "DATA/DS_Sach.dat";

            // Kiểm tra file rỗng hoặc ko tồn tại
            Path path = Paths.get(FilePath);

            if (!Files.exists(path) || !Files.isRegularFile(path) || Files.size(path) == 0) {
                ds_Sach = new DS_Sach();
                return;
            }

            // Đọc file
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            int n = Integer.parseInt(reader.readLine().trim());
            
            ds_Sach = new DS_Sach();
            for (int i = 0; i < n; i++){
                // Đọc các thuộc tính của sách
                String
                    masach = reader.readLine().trim(),
                    tensach = reader.readLine().trim(),
                    matheloai = reader.readLine().trim(),
                    matg = reader.readLine().trim(),
                    manxb = reader.readLine().trim();

                int
                    soluong = Integer.parseInt(reader.readLine().trim()),
                    gia = Integer.parseInt(reader.readLine().trim());

                // Thêm vào ds sách
                ds_Sach.them(masach, tensach, matheloai, matg, manxb, soluong, gia);
            }

            reader.close();
        } catch (IOException e) {
            ds_Sach = new DS_Sach();
            return;
        }
    }

    public void menuChinh(){}
}
