## Java | Stack Operations
# Simple Text Editor with a Undo Functionality

Task assignment: using stack operations design a program that handles an undo, add, and delete functionality within it's text editor. Design that text editor and create a class labeled TextOperations that will define the struct of operations needed for this program. 

**Step 1:**
- Define the TextOperations class as specified.
```
class TextOperation {
    String operationType; // 'add', 'delete', 'undo'.
    Character character;   // Character that the operation is performed on.
    public TextOperation(String operationType, Character character) {
        this.operationType = operationType;
        this.character = character;
    }
}
```
**Step 2:**
- Define needed variables for i/o of stack operations.
  - `private StringBuilder noteBook;`
  - `private Stack<TextOperation> undoStack;`
**Step 3:**
- Create the text editor function defining the textEditor itself. 
```
public textEditor() {
    this.noteBook = new StringBuilder();
    this.undoStack = new Stack<>();
}
```
**Step 4:**
- Build function methods for 'add', 'delete', and 'undo' operations.
  ### add()
  ```
  public void addText(char character) {
    noteBook.append(character);
    undoStack.push(new TextOperation("add", character));
    display();
  }
  ```
  ### delete()
  ```
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
  ```
  ### undo() 
    ```
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
    ```
  ### and finally display()
    ```
        public void display() {
        System.out.println("Current noteBook: '" + noteBook.toString() + "'");
    }
    ```

**Step 3:**
Instantiate the main instance of my TextEditor, asking for user input. 

