## Java - Stack Operations
# Simple Text Editor with Undo Fucntionality

Task assignment was to create TextOperations class that is used to define the struct and operations of a text editor program with undo functionality. 

**Step 1:**

Define the TextOperations class as specified.
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
The class accepts operation type and character value as it's parameters, correctly defining operations to be handled.


**Step 2:**
Create my text editor file. 

- Define needed variables for i/o stack operations.
  - `private StringBuilder noteBook;`
  - `private Stack<TextOperation> undoStack;`
- Build the functions for my 'add', 'delete', and 'undo' operations.
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

