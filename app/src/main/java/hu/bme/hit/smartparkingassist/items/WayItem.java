package hu.bme.hit.smartparkingassist.items;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class WayItem implements Parcelable {

    private Integer wayId;
    private String nameOfWay;
    private Integer gpsTime;
    private Double latitude1;
    private Double longitude1;
    private Double latitude2;
    private Double longitude2;
    private Integer allSpaces;
    private Integer freeSpaces;
    private Double distance;
    private List<Double> latitudes;
    private List<Double> longitudes;

    protected WayItem(Parcel in) {
        nameOfWay = in.readString();
        latitude1 = in.readDouble();
        longitude1 = in.readDouble();
        latitude2 = in.readDouble();
        longitude2 = in.readDouble();
        distance = in.readDouble();
        latitudes = new ArrayList<Double>();
        in.readList(latitudes, null);
        longitudes = new ArrayList<Double>();
        in.readList(longitudes, null);
    }

    public static final Creator<WayItem> CREATOR = new Creator<WayItem>() {
        @Override
        public WayItem createFromParcel(Parcel in) {
            return new WayItem(in);
        }

        @Override
        public WayItem[] newArray(int size) {
            return new WayItem[size];
        }
    };

    /**
     *
     * @return
     * The wayId
     */
    public Integer getWayId() {
        return wayId;
    }

    /**
     *
     * @param wayId
     * The wayId
     */
    public void setWayId(Integer wayId) {
        this.wayId = wayId;
    }

    /**
     *
     * @return
     * The nameOfWay
     */
    public String getNameOfWay() {
        return nameOfWay;
    }

    /**
     *
     * @param nameOfWay
     * The nameOfWay
     */
    public void setNameOfWay(String nameOfWay) {
        this.nameOfWay = nameOfWay;
    }

    /**
     *
     * @return
     * The latitude1
     */
    public Double getLatitude1() {
        return latitude1;
    }

    /**
     *
     * @param latitude1
     * The latitude1
     */
    public void setLatitude1(Double latitude1) {
        this.latitude1 = latitude1;
    }

    /**
     *
     * @return
     * The longitude1
     */
    public Double getLongitude1() {
        return longitude1;
    }

    /**
     *
     * @param longitude1
     * The longitude1
     */
    public void setLongitude1(Double longitude1) {
        this.longitude1 = longitude1;
    }

    /**
     *
     * @return
     * The gpsTime
     */
    public Integer getGpsTime() {
        return gpsTime;
    }

    /**
     *
     * @param gpsTime
     * The gpsTime
     */
    public void setGpsTime(Integer gpsTime) {
        this.gpsTime = gpsTime;
    }

    /**
     *
     * @return
     * The latitude1
     */
    public Double getLatitude2() {
        return latitude2;
    }

    /**
     *
     * @param latitude2
     * The latitude2
     */
    public void setLatitude2(Double latitude2) {
        this.latitude2 = latitude2;
    }

    /**
     *
     * @return
     * The longitude2
     */
    public Double getLongitude2() {
        return longitude2;
    }

    /**
     *
     * @param longitude2
     * The longitude2
     */
    public void setLongitude2(Double longitude2) {
        this.longitude2 = longitude2;
    }


    /**
     *
     * @return
     * The allSpaces
     */
    public Integer getAllSpaces() {
        return allSpaces;
    }

    /**
     *
     * @param allSpaces
     * The allSpaces
     */
    public void setAllSpaces(Integer allSpaces) {
        this.allSpaces = allSpaces;
    }

    /**
     *
     * @return
     * The freeSpaces
     */
    public Integer getFreeSpaces() {
        return freeSpaces;
    }

    /**
     *
     * @param freeSpaces
     * The freeSpaces
     */
    public void setFreeSpaces(Integer freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    /**
     *
     * @return
     * The distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     * The distance
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *
     * @return
     * The longitudes
     */
    public List<Double> getLongitudes() {
        return longitudes;
    }

    /**
     *
     * @param longitudes
     * The longitudes
     */
    public void setDistance(List<Double> longitudes) {
        this.longitudes = longitudes;
    }

    /**
     *
     * @return
     * The latitudes
     */
    public List<Double> getLatitudes() {
        return latitudes;
    }

    /**
     *
     * @param latitudes
     * The latitudes
     */
    public void setLatitudes(List<Double> latitudes) {
        this.latitudes = latitudes;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameOfWay);
        dest.writeDouble(latitude1);
        dest.writeDouble(longitude1);
        dest.writeDouble(latitude2);
        dest.writeDouble(longitude2);
        dest.writeDouble(distance);
        dest.writeList(latitudes);
        dest.writeList(longitudes);
    }
}