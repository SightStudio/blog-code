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
public class Store {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private Staff managerStaff;

    @OneToMany(mappedBy = "store")
    private Set<Customer> storeCustomers;

    @OneToMany(mappedBy = "store")
    private Set<Inventory> storeInventorys;

    @OneToMany(mappedBy = "store")
    private Set<Staff> storeStaffs;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(final Integer storeId) {
        this.storeId = storeId;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Staff getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(final Staff managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Set<Customer> getStoreCustomers() {
        return storeCustomers;
    }

    public void setStoreCustomers(final Set<Customer> storeCustomers) {
        this.storeCustomers = storeCustomers;
    }

    public Set<Inventory> getStoreInventorys() {
        return storeInventorys;
    }

    public void setStoreInventorys(final Set<Inventory> storeInventorys) {
        this.storeInventorys = storeInventorys;
    }

    public Set<Staff> getStoreStaffs() {
        return storeStaffs;
    }

    public void setStoreStaffs(final Set<Staff> storeStaffs) {
        this.storeStaffs = storeStaffs;
    }

}
