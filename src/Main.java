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
        init();                                                                         //front = null

        System.out.print("How many nodes would you like?: ");                           //prompt user to create number of items in linked list
        int numOfNodes = input.nextInt(); System.out.println();
        if(numOfNodes == 0) {System.exit(0);}

        System.out.println("Here are the nodes you requested starting with 1: ");
        for(int i = 1; i <= numOfNodes; i++) {                                          //creates nodes starting with 1 up to the number from user input
            addNodeAtEndOfList(i);
        }
        showList(); System.out.println();                                               //prints out our list to console


        System.out.println("What would you like to do? (Pick from these options): " +   //gives choices to user to modify list
                "\n" + "Add a node: Enter 1" + "\n" + "Delete a node: Enter 2");
        addDeleteChoice = input.nextInt();
        System.out.println();
        if (addDeleteChoice == 1) {                                                                     //if user chooses to add a node, proceed to options for adding-
                                                                                                        //(if user chooses to delete, go to line 69)
            System.out.print("What integer would you like to add?: ");
            numToAdd = input.nextInt();                                                                     //receives input of number for adding to list
            System.out.println();

            System.out.println("Pick one of these three locations to add your number:" +                    //user picks location to add the number
                    "\n" + "Front of the list: Enter 1" + "\n" + "Inside the list: Enter 2" + "\n" +
                    "End of the list: Enter 3");

            addWhereChoice = input.nextInt();
            System.out.println();
            if (addWhereChoice == 1) {                                                                              //choosing to add to front of list, calls method to add to-
                addNodeAtFrontOfList(numToAdd);                                                                     //front of list
                System.out.println("Updated List with added number:");
                showList();
                System.out.println();

            } else if (addWhereChoice == 2) {                                                                       //choosing to add inside the list, calls method  that uses-
                System.out.print("After which number would you like to add your number?: ");                        //specific node for location to add a node is specific spot
                numToAddAfter = input.nextInt();
                SpotToAddAfter = findSpotForAdd(numToAddAfter);
                addAfterSpot(SpotToAddAfter, numToAdd);
                System.out.println("Updated List with added number:");
                showList();
                System.out.println();
            } else if (addWhereChoice == 3) {                                                                       //choosing to add at the end of the list, calls method to-
                addNodeAtEndOfList(numToAdd);                                                                       //add a node to the end of the list
                System.out.println("Updated List with added number:");
                showList();
                System.out.println();
            }
        }
        else {
            if(addDeleteChoice == 2) {                                                             //(line 69) if user chooses to delete a node, proceed to options for deleting
                System.out.println("What number would you like to delete");                                 //choosing which node to delete
                numToDelete = input.nextInt(); System.out.println();

                SpotBeforeDelete = findSpotForDelete(numToDelete);                                          //method call to get node with value that we want to delete
                if (SpotBeforeDelete == front) {
                    deleteFront(SpotBeforeDelete);                                                          //method call to delete front node if chosen node is in the front
                }
                else {
                    deleteAfterSpot(SpotBeforeDelete);                                                      //method call to delete node with the value that we want to delete-
                }                                                                                           //that is not the front.
                System.out.println("Updated List with added number:");
                showList();
                System.out.println();
            }
        }
    }
}
