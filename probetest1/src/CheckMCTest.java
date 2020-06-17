// Bitte nicht ändern. 'CheckMCTest' wird von anderen Klassen verwendet.
public class CheckMCTest {

    public static final String EXPECT =
            " 1. Welche der folgenden Aussagen treffen auf Objektmethoden bzw. Klassenmethoden zu?\n" +
            "    \n" +
            "    XXXXXXXXX In Objektmethoden bezeichnet  this  das aktuelle Objekt.\n" +
            "    XXXXXXXXX Objektmethoden haben Zugriff auf Objekt- und Klassenvariablen.\n" +
            "    XXXXXXXXX Klassenmethoden haben keinen Zugriff auf Objektvariablen.\n" +
            "    XXXXXXXXX In Klassenmethoden darf  this  nicht vorkommen.\n" +
            "    XXXXXXXXX Jede nicht als  static  deklarierte Methode ist eine Objektmethode.\n" +
            "\n" +
            " 2. s sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert  s.peek()  die Zahl  1  als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX s.push(3); s.push(1); s.push(2);\n" +
            "    XXXXXXXXX s.push(1); s.push(2); s.push(3);\n" +
            "    XXXXXXXXX s.push(1); s.push(2); s.push(s.peek());\n" +
            "    XXXXXXXXX s.push(1); s.push(s.peek()); s.push(2);\n" +
            "    XXXXXXXXX s.push(1); s.push(2); s.push(s.pop());\n" +
            "\n" +
            " 3. x sei eine Referenz auf einen Knoten (Typ Node) in einer einfach verketteten Liste\n" +
            "    mit mindestens einem existierenden Nachfolger (in der Objektvariablen next).\n" +
            "    Welche der folgenden Anweisungs-Sequenzen entfernen den direkten Nachfolger von x\n" +
            "    aus einer Liste, ändern sonst aber nichts?\n" +
            "    \n" +
            "    XXXXXXXXX x.next = x.next.next;\n" +
            "    XXXXXXXXX x.next.next = x.next.next.next;\n" +
            "    XXXXXXXXX x.next.next = x.next;\n" +
            "    XXXXXXXXX Node n = x.next.next; x.next = n;\n" +
            "    XXXXXXXXX Node d = x.next; d = d.next;\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen stimmen in Bezug auf rekursive Datenstrukturen?\n" +
            "    \n" +
            "    XXXXXXXXX Doppelt verkettete Listen sind in beide Richtungen traversierbar.\n" +
            "    XXXXXXXXX Zur Fundierung wird meist  null  verwendet.\n" +
            "    XXXXXXXXX Auch zyklische Datenstrukturen müssen fundiert sein.\n" +
            "    XXXXXXXXX Eine Datenstruktur ist rekursiv wenn ihre Methoden rekursiv sind.\n" +
            "    XXXXXXXXX Schleifen erlauben kein vollständiges Traversieren.\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen stimmen in Bezug auf dynamisches und statisches Binden?\n" +
            "    \n" +
            "    XXXXXXXXX Objektmethoden werden immer dynamisch gebunden.\n" +
            "    XXXXXXXXX Ein dynamischer Typ ist stets eine Klasse, kein Interface.\n" +
            "    XXXXXXXXX Dynamisches Binden ist zusammen mit Untertypbeziehungen nötig.\n" +
            "    XXXXXXXXX Objektmethoden werden in deklarierten Typen von Objekten ausgeführt.\n" +
            "    XXXXXXXXX 'final' Methoden werden immer dynamisch gebunden.\n" +
            "\n";

    public static final long UID = 249265448696034L;

}
