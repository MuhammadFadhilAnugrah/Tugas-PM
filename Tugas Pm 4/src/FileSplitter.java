import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileSplitter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();

        System.out.print("Masukkan nama file (misal: file.txt): ");
        String fileName = scanner.nextLine();

        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
            return;
        }

        System.out.print("Masukkan jumlah bagian yang diinginkan: ");
        int numberOfParts = scanner.nextInt();

        String content = fileContent.toString();
        int partSize = content.length() / numberOfParts;
        int startIndex = 0;

        for (int i = 0; i < numberOfParts; i++) {

            int endIndex = (i == numberOfParts - 1) ? content.length() : startIndex + partSize;
            String part = content.substring(startIndex, endIndex);
            queue.add(part);
            startIndex = endIndex;
        }

        System.out.println("\nHasil pemotongan file:");
        int partNumber = 1;
        while (!queue.isEmpty()) {
            System.out.println("Bagian " + partNumber + ":\n" + queue.poll());
            partNumber++;
            System.out.println("----------------------------");
        }
    }
}
