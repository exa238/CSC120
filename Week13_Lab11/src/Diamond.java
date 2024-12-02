public class Diamond {
    private double carat; //data encapsulation

    private double value; // data encapsulation


    //constructor
    public Diamond(double inputCarats, double inputValue){
        //always the same as the class
        carat = inputCarats;
        value = inputValue; // change this
    }// end of the Diamond constructor

    public String toString(){

        return String.format(carat + " carats, worth $" + value );
    }// end of the toString method


    //getValue method
    public double getValue(){
        return value;
    }// end of the getValue method


}// end of the Diamond class
