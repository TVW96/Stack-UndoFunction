import java.util.Stack;

class TextEditor {
    // Instantiate note editor
    private StringBuilder noteBook;
    // Instantiate undo stack 
    private Stack<TextOperation> undoStack;
    // Form the text editor
    public TextEditor() {
        this.noteBook = new StringBuilder();
        this.undoStack = new Stack<>();
    }

    // add character input to noteBook
    public void addText(char character) {
        noteBook.append(character);
        undoStack.push(new TextOperation("add", character));
        display();
    }

    // delete entire notebook
    public void deleteText() {
        if (!noteBook.isEmpty()) {
            char deletedChar = noteBook.charAt(noteBook.length() - 1);
            noteBook.deleteCharAt(noteBook.length() - 1);
            undoStack.push(new TextOperation("delete", deletedChar));
            display();
        } else {
            System.out.println("No noteBook to delete.");
        }
    }

    // undo operations
    public void undo() {
        if (!undoStack.isEmpty()) {
            TextOperation lastOperation = undoStack.pop();
            if (lastOperation.operationType.equals("add")) {
                noteBook.deleteCharAt(noteBook.length() - 1);
            } else if (lastOperation.operationType.equals("delete")) {
                noteBook.append(lastOperation.character);
            }
            display();
        } else {
            System.out.println("No operations to undo.");
        }
    }

    public void display() {
        System.out.println("Current noteBook: '" + noteBook.toString() + "'");
    }
}