package handelsakademin.citybuilder.buildings;

// To make a class inherit from another,
// write extends and then what class it should inherit from after.
public class Appartment extends Building {
    private int appartmentNumber;

    // A class that inherits must call the constructor of the class it
    // inherits from. It does so with super(). super() calls that
    // constructor, and must be given the parameters that constructor takes.
    public Appartment(String address, int area, int appartmentNumber) {
        super(address, area, 1);
        setAppartmentNumber(appartmentNumber);
    }

    // Override function.
    @Override
    public void printInfo() {
        System.out.println("Id: " + getId() + ", Address: " + getAddress() +
                ", Area: " + getArea() + " sqm, Appartment Nr: " + getAppartmentNumber());
    }


    public int getAppartmentNumber() {
        return appartmentNumber;
    }
    public void setAppartmentNumber(int appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }
}
