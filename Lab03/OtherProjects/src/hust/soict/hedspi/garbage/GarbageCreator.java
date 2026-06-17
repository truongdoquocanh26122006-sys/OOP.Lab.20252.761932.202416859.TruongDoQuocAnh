package hust.soict.dsai;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "/Users/truongdoquocanh/Documents/Kiến trúc máy tính/LearningMaterial_IT3280_RISCV_v8.2.pdf"; 
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        
        long startTime = System.currentTimeMillis();
        StringBuilder sb= new StringBuilder();
        for (byte b : inputBytes) {
            sb.append((char) b);
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);
    }
}