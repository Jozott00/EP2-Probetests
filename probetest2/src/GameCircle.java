// This class represents players sitting in a circle in a counting game.
// Objects of type 'Player' are stored in a ring list (all nodes have a successor node != null).
// The first player starts counting "1", the second counts "2", etc., until the player, who reaches the
// specified dropout number. This player is removed from the game and the player next to his position
// starts counting again with "1" in the next round.
//
// Example (4 Players, dropout number is 3):
//
// Round 1:
// Player1      Player2     Player3     Player4
// "1"
//              "2"
//                          "3!"
// -> Player3 removed
//
// Round 2:
// Player1      Player2     Player4
//                          "1"
// "2"                      ⤶
//              "3!"
// -> Player2 removed
//
// Round 3:
// Player1      Player4
//              "1"
// "2"          ⤶
//              "3!"
// -> Player4 removed
// Player1 wins!
//
// TODO: define further classes for the implementation of the ring list, if needed (either in this file
//  or in separate files)
//
public class GameCircle {

    // TODO: declare variables
    Node head;
    Node tail;
    Node currP;

    // Initializes this GameCircle with the players created according to
    // 'playerNames'. The player playerNames[i] gets the number i+1.
    // playerNames[0] is the player who will start counting.
    // Preconditions: 'playerNames' is not null and has no 'null'-entries (need not be checked).
    public GameCircle(String[] playerNames) {
        // TODO: implement this constructor
        for(String name : playerNames) {
            if(name == null) continue;

            if(head == null)  {
                Node newNode = new Node(new Player(name), null, null);
                head = newNode;
                head.prev = head;
                head.next = head;
                tail = head;
                continue;
            }

            Node newNode = new Node(new Player(name), head, tail);
            tail.next = newNode;
            tail = newNode;
            head.prev = tail;
        }

        currP = head;
    }

    // This method simulates one round of the counting game with
    // dropout number 'dropOutCount'. It returns the player who is removed
    // in this round. Returns 'null' if there is no player in the game circle.
    // Note that the starting position for counting depends on the previous round!
    // Precondition: dropOutCount > 0 (needs not be checked).
    public Player play(int dropOutCount) {
        // TODO: implement this method
        if(dropOutCount <= 0) System.exit(2);
        for(int i = 1; i < dropOutCount; i++) {
            currP = currP.next;
        }

        Player selected = currP.p;

        if(currP.next == currP) currP.next.next = null;
        else {
            currP.prev.next = currP.next;
            currP.next.prev = currP.prev;
        }

        currP = currP.next;

        return selected;
    }

    // Returns 'true' if there is no player in the game circle.
    public boolean isEmpty() {
        // TODO: implement this method
        return currP == null;
    }

    // Returns a representation of this game circle with all its (remaining) players in
    // brackets in order of their insertion (player with smallest number is left).
    // The player that starts counting in the next round is marked by '*'.
    // Returns "[]" if the circle is empty.
    public String toString() {
        // TODO: implement this method
        Node currNode = head;

        String s = "[ " ;

        do{
            String temp;
            if(isEmpty()) {
                s += "";
                break;
            }
            if (currNode == currP) temp = "*" + currNode + "*";
            else temp = currNode.toString();
            s += temp + " ";
            if(currNode.next != null)
                currNode = currNode.next;
        }while (head != currNode && currNode.next != null);

        s += "]";
        return s;
    }
}

class Node {

    Player p;
    Node next;
    Node prev;

    public Node(Player p, Node next, Node prev) {
        this.p = p;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
      return p.toString();
    }
}

