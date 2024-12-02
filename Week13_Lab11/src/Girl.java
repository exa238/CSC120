public class Girl {
    private String name; //data encapsulation

    private Diamond diamond; // data encapsulation

    //constructor
    public Girl(){//always the same as the class
        name = null;
        diamond = null; // change this
    }// end of the Diamond constructor

    public Girl(String inputName){
        name = inputName;
        diamond = null;

    }// end of Girl method

    public String toString(){
        if (diamond == null) {
            return name + " has no best friend";
        }// end of if statement
        else{
            return name + " has a diamond " + diamond;
        }// end of else statement
    }// end of the toString method

    public boolean setDiamond(Diamond myDiamond){
        if (diamond == null || diamond.getValue() < myDiamond.getValue()){
            diamond = myDiamond;
            return true;
        }// end of if statement
        else{
            return false;
        }// end of else statement
    }// end of setDiamond method



}// end of the Girl class
