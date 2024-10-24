// TextOperation class
class TextOperation {

    String operationType; // 'add', 'delete', 'undo'.
    Character character;   // Character that the operation is performed on.

    public TextOperation(String operationType, Character character) {
        this.operationType = operationType;
        this.character = character;
    }
}