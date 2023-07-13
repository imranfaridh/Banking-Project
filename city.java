public class city {
    String cityname ;
    String regionname;

    public city(String cityname, String regionname) {
        this.cityname = cityname;
        this.regionname = regionname;
    }

    @Override
    public String toString() {
        return cityname+ " - "+ regionname;

    }
}
