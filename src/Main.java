import java.util.Scanner;
public class Main extends LinkList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Node SpotToAddAfter;
        Node SpotBeforeDelete;
        int addDeleteChoice;
        int addWhereChoice;
        int numToAdd;
        int numToDelete;
        int numToAddAfter;
        int editChoice;



        System.out.println("Let's make a custom number Linked-List!");
        init();

        System.out.print("How many nodes would you like?: ");
        int numOfNodes = input.nextInt(); System.out.println();
        if(numOfNodes == 0) {System.exit(0);}

        System.out.println("Here are the nodes you requested starting with 1: ");
        for(int i = 1; i <= numOfNodes; i++) {
            addNodeAtEndOfList(i);
        }
        showList(); System.out.println();


        System.out.println("What would you like to do? (Pick from these options): " +
                "\n" + "Add a node: Enter 1" + "\n" + "Delete a node: Enter 2");

        addDeleteChoice = input.nextInt();
        System.out.println();
        if (addDeleteChoice == 1) {

            System.out.print("What number would you like to add?: ");
            numToAdd = input.nextInt();
            System.out.println();

            System.out.println("Pick one of these three locations to add your number:" +
                    "\n" + "Front of the list: Enter 1" + "\n" + "Inside the list: Enter 2" + "\n" +
                    "End of the list: Enter 3");

            addWhereChoice = input.nextInt();
            System.out.println();
            if (addWhereChoice == 1) {
                addNodeAtFrontOfList(numToAdd);
                System.out.println("Updated List with added number:");
                showList();
                System.out.println();

            } else if (addWhereChoice == 2) {
                System.out.print("After which number would you like to add your number?: ");
                numToAddAfter = input.nextInt();
                SpotToAddAfter = findSpotForAdd(numToAddAfter);
                addAfterSpot(SpotToAddAfter, numToAdd);
                System.out.println("Updated List with added number:");
                showList();
                System.out.println();
            } else if (addWhereChoice == 3) {
                addNodeAtEndOfList(numToAdd);
                System.out.println("Updated List with added number:");
                showList();
                System.out.println();
            }
        }
        else {
            if(addDeleteChoice == 2) {
                System.out.println("What number would you like to delete");
                numToDelete = input.nextInt(); System.out.println();

                SpotBeforeDelete = findSpotForDelete(numToDelete);
                if (SpotBeforeDelete == front) {
                    deleteFront(SpotBeforeDelete);
                }
                else {
                    deleteAfterSpot(SpotBeforeDelete);
                }
                System.out.println("Updated List with added number:");
                showList();
                System.out.println();
            }
        }
    }
}
