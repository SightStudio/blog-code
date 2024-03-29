/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.records;


import java.time.LocalDateTime;

import jooq.jooq_dsl.tables.JStaff;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JStaffRecord extends UpdatableRecordImpl<JStaffRecord> implements Record11<Integer, Boolean, String, String, String, LocalDateTime, String, String, String, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Staff.staffId</code>.
     */
    public JStaffRecord setStaffid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>Staff.staffId</code>.
     */
    public Integer getStaffid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Staff.active</code>.
     */
    public JStaffRecord setActive(Boolean value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>Staff.active</code>.
     */
    public Boolean getActive() {
        return (Boolean) get(1);
    }

    /**
     * Setter for <code>Staff.email</code>.
     */
    public JStaffRecord setEmail(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>Staff.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Staff.firstName</code>.
     */
    public JStaffRecord setFirstname(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>Staff.firstName</code>.
     */
    public String getFirstname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>Staff.lastName</code>.
     */
    public JStaffRecord setLastname(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>Staff.lastName</code>.
     */
    public String getLastname() {
        return (String) get(4);
    }

    /**
     * Setter for <code>Staff.lastUpdate</code>.
     */
    public JStaffRecord setLastupdate(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>Staff.lastUpdate</code>.
     */
    public LocalDateTime getLastupdate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>Staff.password</code>.
     */
    public JStaffRecord setPassword(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>Staff.password</code>.
     */
    public String getPassword() {
        return (String) get(6);
    }

    /**
     * Setter for <code>Staff.picture</code>.
     */
    public JStaffRecord setPicture(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>Staff.picture</code>.
     */
    public String getPicture() {
        return (String) get(7);
    }

    /**
     * Setter for <code>Staff.username</code>.
     */
    public JStaffRecord setUsername(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>Staff.username</code>.
     */
    public String getUsername() {
        return (String) get(8);
    }

    /**
     * Setter for <code>Staff.address_id</code>.
     */
    public JStaffRecord setAddressId(Integer value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>Staff.address_id</code>.
     */
    public Integer getAddressId() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>Staff.store_id</code>.
     */
    public JStaffRecord setStoreId(Integer value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>Staff.store_id</code>.
     */
    public Integer getStoreId() {
        return (Integer) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<Integer, Boolean, String, String, String, LocalDateTime, String, String, String, Integer, Integer> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Integer, Boolean, String, String, String, LocalDateTime, String, String, String, Integer, Integer> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JStaff.STAFF.STAFFID;
    }

    @Override
    public Field<Boolean> field2() {
        return JStaff.STAFF.ACTIVE;
    }

    @Override
    public Field<String> field3() {
        return JStaff.STAFF.EMAIL;
    }

    @Override
    public Field<String> field4() {
        return JStaff.STAFF.FIRSTNAME;
    }

    @Override
    public Field<String> field5() {
        return JStaff.STAFF.LASTNAME;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return JStaff.STAFF.LASTUPDATE;
    }

    @Override
    public Field<String> field7() {
        return JStaff.STAFF.PASSWORD;
    }

    @Override
    public Field<String> field8() {
        return JStaff.STAFF.PICTURE;
    }

    @Override
    public Field<String> field9() {
        return JStaff.STAFF.USERNAME;
    }

    @Override
    public Field<Integer> field10() {
        return JStaff.STAFF.ADDRESS_ID;
    }

    @Override
    public Field<Integer> field11() {
        return JStaff.STAFF.STORE_ID;
    }

    @Override
    public Integer component1() {
        return getStaffid();
    }

    @Override
    public Boolean component2() {
        return getActive();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public String component4() {
        return getFirstname();
    }

    @Override
    public String component5() {
        return getLastname();
    }

    @Override
    public LocalDateTime component6() {
        return getLastupdate();
    }

    @Override
    public String component7() {
        return getPassword();
    }

    @Override
    public String component8() {
        return getPicture();
    }

    @Override
    public String component9() {
        return getUsername();
    }

    @Override
    public Integer component10() {
        return getAddressId();
    }

    @Override
    public Integer component11() {
        return getStoreId();
    }

    @Override
    public Integer value1() {
        return getStaffid();
    }

    @Override
    public Boolean value2() {
        return getActive();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public String value4() {
        return getFirstname();
    }

    @Override
    public String value5() {
        return getLastname();
    }

    @Override
    public LocalDateTime value6() {
        return getLastupdate();
    }

    @Override
    public String value7() {
        return getPassword();
    }

    @Override
    public String value8() {
        return getPicture();
    }

    @Override
    public String value9() {
        return getUsername();
    }

    @Override
    public Integer value10() {
        return getAddressId();
    }

    @Override
    public Integer value11() {
        return getStoreId();
    }

    @Override
    public JStaffRecord value1(Integer value) {
        setStaffid(value);
        return this;
    }

    @Override
    public JStaffRecord value2(Boolean value) {
        setActive(value);
        return this;
    }

    @Override
    public JStaffRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public JStaffRecord value4(String value) {
        setFirstname(value);
        return this;
    }

    @Override
    public JStaffRecord value5(String value) {
        setLastname(value);
        return this;
    }

    @Override
    public JStaffRecord value6(LocalDateTime value) {
        setLastupdate(value);
        return this;
    }

    @Override
    public JStaffRecord value7(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public JStaffRecord value8(String value) {
        setPicture(value);
        return this;
    }

    @Override
    public JStaffRecord value9(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public JStaffRecord value10(Integer value) {
        setAddressId(value);
        return this;
    }

    @Override
    public JStaffRecord value11(Integer value) {
        setStoreId(value);
        return this;
    }

    @Override
    public JStaffRecord values(Integer value1, Boolean value2, String value3, String value4, String value5, LocalDateTime value6, String value7, String value8, String value9, Integer value10, Integer value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JStaffRecord
     */
    public JStaffRecord() {
        super(JStaff.STAFF);
    }

    /**
     * Create a detached, initialised JStaffRecord
     */
    public JStaffRecord(Integer staffid, Boolean active, String email, String firstname, String lastname, LocalDateTime lastupdate, String password, String picture, String username, Integer addressId, Integer storeId) {
        super(JStaff.STAFF);

        setStaffid(staffid);
        setActive(active);
        setEmail(email);
        setFirstname(firstname);
        setLastname(lastname);
        setLastupdate(lastupdate);
        setPassword(password);
        setPicture(picture);
        setUsername(username);
        setAddressId(addressId);
        setStoreId(storeId);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised JStaffRecord
     */
    public JStaffRecord(jooq.jooq_dsl.tables.pojos.JStaff value) {
        super(JStaff.STAFF);

        if (value != null) {
            setStaffid(value.getStaffid());
            setActive(value.getActive());
            setEmail(value.getEmail());
            setFirstname(value.getFirstname());
            setLastname(value.getLastname());
            setLastupdate(value.getLastupdate());
            setPassword(value.getPassword());
            setPicture(value.getPicture());
            setUsername(value.getUsername());
            setAddressId(value.getAddressId());
            setStoreId(value.getStoreId());
            resetChangedOnNotNull();
        }
    }
}
