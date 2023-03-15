public class LinkList {
    public static Node front;

    LinkList() {
        front = null;
    }

    public static void init() {
        front = null;
    }

    public static Node makeNode(int num) {
        Node nBlock = new Node();
        nBlock.data = num;
        nBlock.next = null;
        return nBlock;
    }

    public static Node findEnd() {
        Node current = front;
        while(current.next != null) {
            current = current.next;
        }
        return current;
    }

    public static void addNodeAtFrontOfList(int num) {
        Node temp = makeNode(num);
        temp.next = front;
        front = temp;
    }

    public static void addNodeAtEndOfList(int num) {
        Node end;
        if(front == null) {
            front = makeNode(num);
        }
        else {
            end = findEnd();
            end.next = makeNode(num);
        }
    }

    public static Node findSpotForAdd(int num) {
        Node current;
        current = front;
        while(num > current.data) {
            current = current.next;
        }
        return current;
    }

    public static Node findSpotForDelete(int num) {
        Node current, previous;
        current = front;
        previous = current;
        while(num > current.data) {
            previous = current;
            current = current.next;
        }
        return previous;
    }

    public static void addAfterSpot(Node spot, int num) {
        Node temp = makeNode(num);
        temp.next = spot.next;
        spot.next = temp;
    }

    public static void deleteAfterSpot(Node spot) {
        Node temp;
        temp = spot.next;
        spot.next = temp.next;
        temp.next = null;
    }

    public static void deleteFront(Node spot) {
        front = spot.next;
            spot.next = null;
    }

    public static void showList() {
        Node current = front;
        while(current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }

}
