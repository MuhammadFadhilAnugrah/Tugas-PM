import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private StringBuilder currentText;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        currentText = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void show() {
        System.out.println("Teks saat ini: ");
        System.out.println(currentText.length() == 0 ? "<kosong>" : currentText.toString());
        System.out.println();
    }

    public void write(String text) {

        undoStack.push(currentText.toString());

        redoStack.clear();

        currentText.append(text);
        System.out.println("Teks '" + text + "' ditambahkan.");
    }

    public void undo() {
        if (!undoStack.isEmpty()) {

            redoStack.push(currentText.toString());

            currentText = new StringBuilder(undoStack.pop());
            System.out.println("Undo berhasil.");
        } else {
            System.out.println("Tidak ada tindakan yang bisa di-undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {

            undoStack.push(currentText.toString());

            currentText = new StringBuilder(redoStack.pop());
            System.out.println("Redo berhasil.");
        } else {
            System.out.println("Tidak ada tindakan yang bisa di-redo.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Simulasi Text Editor");
        System.out.println("Perintah yang tersedia: show, write <text>, undo, redo, exit");

        // Loop untuk membaca perintah pengguna
        while (true) {
            System.out.print("Masukkan perintah: ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.equalsIgnoreCase("show")) {
                editor.show();
            } else if (command.startsWith("write ")) {
                String text = command.substring(6); // Mengambil teks setelah perintah 'write'
                editor.write(text);
            } else if (command.equalsIgnoreCase("undo")) {
                editor.undo();
            } else if (command.equalsIgnoreCase("redo")) {
                editor.redo();
            } else {
                System.out.println("Perintah tidak dikenali.");
            }
        }
        scanner.close();
    }
}
