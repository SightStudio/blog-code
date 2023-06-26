package com.sight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Address {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(length = 50)
    private String address2;

    @Column(nullable = false, length = 20)
    private String district;

    @Column(length = 10)
    private String postalCode;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "address")
    private Set<Staff> addressStaffs;

    @OneToMany(mappedBy = "address")
    private Set<Store> addressStores;

    @OneToMany(mappedBy = "address")
    private Set<Customer> addressCustomers;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(final Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(final String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(final City city) {
        this.city = city;
    }

    public Set<Staff> getAddressStaffs() {
        return addressStaffs;
    }

    public void setAddressStaffs(final Set<Staff> addressStaffs) {
        this.addressStaffs = addressStaffs;
    }

    public Set<Store> getAddressStores() {
        return addressStores;
    }

    public void setAddressStores(final Set<Store> addressStores) {
        this.addressStores = addressStores;
    }

    public Set<Customer> getAddressCustomers() {
        return addressCustomers;
    }

    public void setAddressCustomers(final Set<Customer> addressCustomers) {
        this.addressCustomers = addressCustomers;
    }

}
