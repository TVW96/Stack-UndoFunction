import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter 'add <char>', 'delete', 'undo', or 'exit': ");
            String operation = scanner.nextLine().trim();

            if (operation.startsWith("add")) {
                if (operation.length() > 4) { // Ensure there's a character to add
                    char charToAdd = operation.charAt(4); // Get the character after 'add '
                    editor.addText(charToAdd);
                } else {
                    System.out.println("Please provide a character to add.");
                }
            } else if (operation.equals("delete")) {
                editor.deleteText();
            } else if (operation.equals("undo")) {
                editor.undo();
            } else if (operation.equals("exit")) {
                System.out.println("Exiting the text editor.");
                break;
            } else {
                System.out.println("Invalid operation. Please try again.");
            }
        }
        scanner.close();
    }
}