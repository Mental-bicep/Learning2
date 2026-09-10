package solidprinciples;

//1. General base class
class Document {
 void open() { System.out.println("Opening document..."); }
 void save() { System.out.println("Saving document..."); }
}

//2. Specialized base for printable types
class PrintableDocument extends Document {
 void print() { System.out.println("Printing to paper..."); }
}

//3. Implementations
class TextDocument extends Document {
 // Only has open and save
}

class PDFDocument extends PrintableDocument {
 // Has open, save, AND print
}

public class LiskovSubstitutionPrinciple {

}
