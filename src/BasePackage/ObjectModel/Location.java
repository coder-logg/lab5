package BasePackage.ObjectModel;

public enum Location {
    SPACESHIP("Космический корабль") ,
    FOREST("Лес") ;
    private String locationName;
    Location(String locationName){
        this.locationName=locationName;
    }
}