public class LinkList {
    public static Node front;

    LinkList() {
        front = null;
    }

    public static void init() {
        front = null;
    }

    public static Node makeNode(int num) {         //method returns new node referencing a data value and null next node
        Node nBlock = new Node();
        nBlock.data = num;
        nBlock.next = null;
        return nBlock;
    }

    public static Node findEnd() {                 //returns reference to the last node in our list
        Node current = front;
        while(current.next != null) {
            current = current.next;
        }
        return current;
    }

    public static void addNodeAtFrontOfList(int num) {      //add a node to front of list, making the node the new front
        Node temp = makeNode(num);
        temp.next = front;
        front = temp;
    }

    public static void addNodeAtEndOfList(int num) {        //add a node to the end of list, making the node the new end
        Node end;
        if(front == null) {
            front = makeNode(num);
        }
        else {
            end = findEnd();
            end.next = makeNode(num);
        }
    }

    public static Node findSpotForAdd(int num) {            //method to return the location of where to add a new node
        Node current;                                       //!returns node before the insertion point!
        current = front;
        while(num > current.data) {
            current = current.next;
        }
        return current;
    }

    public static Node findSpotForDelete(int num) {         //method to return the location of which node to delete
        Node current;                                       //!returns node before the node chosen to be deleted
        current = front;
        while(num > current.next.data) {
            current = current.next;
        }
        return current;
    }

    public static void addAfterSpot(Node spot, int num) {   //method adds a new node after the node that-
        Node temp = makeNode(num);                          //findSpotForAdd() returns
        temp.next = spot.next;
        spot.next = temp;
    }

    public static void deleteAfterSpot(Node spot) {         //method deletes the node after the node that-
        Node temp;                                          //findSpotForDelete() returns
        temp = spot.next;
        spot.next = temp.next;
        temp.next = null;
    }

    public static void deleteFront(Node spot) {             //method deletes the node in front of the list.-
        front = spot.next;                                  //making the node next in line the new front.
        spot.next = null;
    }

    public static void showList() {                         //prints out our linked list
        Node current = front;
        while(current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }

}
