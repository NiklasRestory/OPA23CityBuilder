// So, I put the buildings in a different folder. They're in a different package.
// To retrieve a class that is in a folder different from the one we're in,
// we're going to need to import it from its package.
package handelsakademin.citybuilder.buildings;

public class Building {
    // Attribute. Fields.
    private int id;
    private String address;
    private int area;
    private int floorCount;

    // To generate getters and setters
    // Right-click -> Generate -> Getters and Setters
    // Hold down shift to select multiple rows
    // Then click OK.

    // A usage of static is dynamically generate ids.
    // A static variable is shared by all objects of this type, there's only one.
    // It can keep track of what id the next one should get.
    // The constructor can then assign a new object the id that is nextId,
    // then increase nextId by one so the next object of this type to
    // be created gets an id that is one higher. Auto_increment but in Java. :)
    private static int nextId = 1;
    public Building(String address, int area, int floorCount) {
        setId(nextId);
        nextId++; // Increase nextId by 1.
        setAddress(address);
        setArea(area);
        setFloorCount(floorCount);
    }

    public void printInfo() {
        // I use getters here, but functions in the same class as the variables do not
        // actually need to use the getters/setters. Depends on if you feel the implementation
        // in the getters and setters should apply even if it is the same class using them.
        System.out.println("Id: " + getId() + ", Address: " + getAddress() +
                         ", Area: " + getArea() + " sqm, Floor Count: " + getFloorCount());
    }

    // We want to use private variables with Getters and Setters.
    // This is because, if we have some code we want to execute at some time
    // in the future whenever someone gets or sets a value of a certain
    // variable, we now have a place to write it.
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getArea() {
        return area;
    }
    public void setArea(int area) {
        this.area = area;
    }
    public int getFloorCount() {
        return floorCount;
    }
    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }
}
