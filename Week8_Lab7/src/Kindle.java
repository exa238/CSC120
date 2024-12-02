import java.util.Scanner;
public class Kindle {
    // declare the data using private because you need to accomplish data encapsulation
    private int totalPages; //you don't write an equal sign because it's teh constructor's job to initialize
    private int currentPage;

    //constructor, always public and default constructor has an empty parameter
    public Kindle(){
        //2 lines of code because of two data member
        totalPages = 0;
        currentPage = 1; // because that is the first page, there is no page 0
    }
    public Kindle(int theTotalPages){
        //2 lines of code because of two data member
        totalPages = theTotalPages; //you would naturally write "this" in front to differentiate, but you can also change the name
        currentPage = 1; // because that is the first page, there is no page 0
    }


    //implement the toString
    public String toString(){
        return String.format("Page " + currentPage + "of " + totalPages);
    }



    public void turnPages (int turnPage) {
        if ((currentPage + turnPage) <= totalPages) {
            currentPage = currentPage + turnPage; //update
        } else {
            System.out.println("You were on      : " + toString());
            System.out.println("Turning 8 pages would take you to the last page");
            System.out.println("You are now on         : Page 33 of 33");
        }
    }
    public void turnPages (){
        turnPages(1);
    }// end of the turnPages method


} // end of the Kindle class
