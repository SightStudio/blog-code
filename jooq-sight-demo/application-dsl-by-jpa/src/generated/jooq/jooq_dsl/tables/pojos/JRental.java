/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JRental implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer rentalid;
    private final LocalDateTime lastupdate;
    private final LocalDateTime rentaldate;
    private final LocalDateTime returndate;
    private final Integer customerId;
    private final Integer inventoryId;
    private final Integer staffId;

    public JRental(JRental value) {
        this.rentalid = value.rentalid;
        this.lastupdate = value.lastupdate;
        this.rentaldate = value.rentaldate;
        this.returndate = value.returndate;
        this.customerId = value.customerId;
        this.inventoryId = value.inventoryId;
        this.staffId = value.staffId;
    }

    public JRental(
        Integer rentalid,
        LocalDateTime lastupdate,
        LocalDateTime rentaldate,
        LocalDateTime returndate,
        Integer customerId,
        Integer inventoryId,
        Integer staffId
    ) {
        this.rentalid = rentalid;
        this.lastupdate = lastupdate;
        this.rentaldate = rentaldate;
        this.returndate = returndate;
        this.customerId = customerId;
        this.inventoryId = inventoryId;
        this.staffId = staffId;
    }

    /**
     * Getter for <code>Rental.rentalId</code>.
     */
    public Integer getRentalid() {
        return this.rentalid;
    }

    /**
     * Getter for <code>Rental.lastUpdate</code>.
     */
    public LocalDateTime getLastupdate() {
        return this.lastupdate;
    }

    /**
     * Getter for <code>Rental.rentalDate</code>.
     */
    public LocalDateTime getRentaldate() {
        return this.rentaldate;
    }

    /**
     * Getter for <code>Rental.returnDate</code>.
     */
    public LocalDateTime getReturndate() {
        return this.returndate;
    }

    /**
     * Getter for <code>Rental.customer_id</code>.
     */
    public Integer getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for <code>Rental.inventory_id</code>.
     */
    public Integer getInventoryId() {
        return this.inventoryId;
    }

    /**
     * Getter for <code>Rental.staff_id</code>.
     */
    public Integer getStaffId() {
        return this.staffId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JRental other = (JRental) obj;
        if (this.rentalid == null) {
            if (other.rentalid != null)
                return false;
        }
        else if (!this.rentalid.equals(other.rentalid))
            return false;
        if (this.lastupdate == null) {
            if (other.lastupdate != null)
                return false;
        }
        else if (!this.lastupdate.equals(other.lastupdate))
            return false;
        if (this.rentaldate == null) {
            if (other.rentaldate != null)
                return false;
        }
        else if (!this.rentaldate.equals(other.rentaldate))
            return false;
        if (this.returndate == null) {
            if (other.returndate != null)
                return false;
        }
        else if (!this.returndate.equals(other.returndate))
            return false;
        if (this.customerId == null) {
            if (other.customerId != null)
                return false;
        }
        else if (!this.customerId.equals(other.customerId))
            return false;
        if (this.inventoryId == null) {
            if (other.inventoryId != null)
                return false;
        }
        else if (!this.inventoryId.equals(other.inventoryId))
            return false;
        if (this.staffId == null) {
            if (other.staffId != null)
                return false;
        }
        else if (!this.staffId.equals(other.staffId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.rentalid == null) ? 0 : this.rentalid.hashCode());
        result = prime * result + ((this.lastupdate == null) ? 0 : this.lastupdate.hashCode());
        result = prime * result + ((this.rentaldate == null) ? 0 : this.rentaldate.hashCode());
        result = prime * result + ((this.returndate == null) ? 0 : this.returndate.hashCode());
        result = prime * result + ((this.customerId == null) ? 0 : this.customerId.hashCode());
        result = prime * result + ((this.inventoryId == null) ? 0 : this.inventoryId.hashCode());
        result = prime * result + ((this.staffId == null) ? 0 : this.staffId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JRental (");

        sb.append(rentalid);
        sb.append(", ").append(lastupdate);
        sb.append(", ").append(rentaldate);
        sb.append(", ").append(returndate);
        sb.append(", ").append(customerId);
        sb.append(", ").append(inventoryId);
        sb.append(", ").append(staffId);

        sb.append(")");
        return sb.toString();
    }
}