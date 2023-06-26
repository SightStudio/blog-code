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
public class Rental {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalId;

    @Column(nullable = false)
    private OffsetDateTime rentalDate;

    @Column
    private OffsetDateTime returnDate;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @OneToMany(mappedBy = "rental")
    private Set<Payment> rentalPayments;

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(final Integer rentalId) {
        this.rentalId = rentalId;
    }

    public OffsetDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(final OffsetDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public OffsetDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final OffsetDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(final Inventory inventory) {
        this.inventory = inventory;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(final Staff staff) {
        this.staff = staff;
    }

    public Set<Payment> getRentalPayments() {
        return rentalPayments;
    }

    public void setRentalPayments(final Set<Payment> rentalPayments) {
        this.rentalPayments = rentalPayments;
    }

}
