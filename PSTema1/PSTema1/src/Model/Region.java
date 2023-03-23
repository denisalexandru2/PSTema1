package Model;

public class Region {
    public int id;
    public String regionName;

    public Region(int id, String regionName) {
        this.id = id;
        this.regionName = regionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
