package handelsakademin.citybuilder.buildings;

import java.util.ArrayList;

public class AppartmentBuilding extends Building {
    private String landlord;
    // This exists as an example. I could have an AppartmentBuilding class
    // that then contains appartments.
    ArrayList<Appartment> appartments = new ArrayList<>();

    public AppartmentBuilding(String address, int area, int floorCount, String landlord) {
        super(address, area, floorCount);
        setLandlord(landlord);
    }

    public int getAppartmentCount() {
        return appartments.size();
    }

    public String getLandlord() {
        return landlord;
    }
    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }
}
