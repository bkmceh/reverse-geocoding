package inforest.reversegeocoding.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "AddressMapper")
public class AddressMapperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

    @Column(name = "address")
    private String address;

    public AddressMapperEntity() {}

    public AddressMapperEntity(double lat, double lon, String address) {
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

}
