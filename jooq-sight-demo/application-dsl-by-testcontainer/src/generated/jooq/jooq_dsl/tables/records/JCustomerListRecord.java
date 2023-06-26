/*
 * This file is generated by jOOQ.
 */
package jooq.jooq_dsl.tables.records;


import jooq.jooq_dsl.tables.JCustomerList;

import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.TableRecordImpl;


/**
 * VIEW
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JCustomerListRecord extends TableRecordImpl<JCustomerListRecord> implements Record9<Integer, String, String, String, String, String, String, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>sakila.customer_list.ID</code>.
     */
    public JCustomerListRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sakila.customer_list.name</code>.
     */
    public JCustomerListRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sakila.customer_list.address</code>.
     */
    public JCustomerListRecord setAddress(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.address</code>.
     */
    public String getAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sakila.customer_list.zip code</code>.
     */
    public JCustomerListRecord setZipCode(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.zip code</code>.
     */
    public String getZipCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sakila.customer_list.phone</code>.
     */
    public JCustomerListRecord setPhone(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.phone</code>.
     */
    public String getPhone() {
        return (String) get(4);
    }

    /**
     * Setter for <code>sakila.customer_list.city</code>.
     */
    public JCustomerListRecord setCity(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.city</code>.
     */
    public String getCity() {
        return (String) get(5);
    }

    /**
     * Setter for <code>sakila.customer_list.country</code>.
     */
    public JCustomerListRecord setCountry(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.country</code>.
     */
    public String getCountry() {
        return (String) get(6);
    }

    /**
     * Setter for <code>sakila.customer_list.notes</code>.
     */
    public JCustomerListRecord setNotes(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.notes</code>.
     */
    public String getNotes() {
        return (String) get(7);
    }

    /**
     * Setter for <code>sakila.customer_list.SID</code>.
     */
    public JCustomerListRecord setSid(Integer value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>sakila.customer_list.SID</code>.
     */
    public Integer getSid() {
        return (Integer) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, String, String, String, String, String, String, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, String, String, String, String, String, String, String, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JCustomerList.CUSTOMER_LIST.ID;
    }

    @Override
    public Field<String> field2() {
        return JCustomerList.CUSTOMER_LIST.NAME;
    }

    @Override
    public Field<String> field3() {
        return JCustomerList.CUSTOMER_LIST.ADDRESS;
    }

    @Override
    public Field<String> field4() {
        return JCustomerList.CUSTOMER_LIST.ZIP_CODE;
    }

    @Override
    public Field<String> field5() {
        return JCustomerList.CUSTOMER_LIST.PHONE;
    }

    @Override
    public Field<String> field6() {
        return JCustomerList.CUSTOMER_LIST.CITY;
    }

    @Override
    public Field<String> field7() {
        return JCustomerList.CUSTOMER_LIST.COUNTRY;
    }

    @Override
    public Field<String> field8() {
        return JCustomerList.CUSTOMER_LIST.NOTES;
    }

    @Override
    public Field<Integer> field9() {
        return JCustomerList.CUSTOMER_LIST.SID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getAddress();
    }

    @Override
    public String component4() {
        return getZipCode();
    }

    @Override
    public String component5() {
        return getPhone();
    }

    @Override
    public String component6() {
        return getCity();
    }

    @Override
    public String component7() {
        return getCountry();
    }

    @Override
    public String component8() {
        return getNotes();
    }

    @Override
    public Integer component9() {
        return getSid();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getAddress();
    }

    @Override
    public String value4() {
        return getZipCode();
    }

    @Override
    public String value5() {
        return getPhone();
    }

    @Override
    public String value6() {
        return getCity();
    }

    @Override
    public String value7() {
        return getCountry();
    }

    @Override
    public String value8() {
        return getNotes();
    }

    @Override
    public Integer value9() {
        return getSid();
    }

    @Override
    public JCustomerListRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public JCustomerListRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public JCustomerListRecord value3(String value) {
        setAddress(value);
        return this;
    }

    @Override
    public JCustomerListRecord value4(String value) {
        setZipCode(value);
        return this;
    }

    @Override
    public JCustomerListRecord value5(String value) {
        setPhone(value);
        return this;
    }

    @Override
    public JCustomerListRecord value6(String value) {
        setCity(value);
        return this;
    }

    @Override
    public JCustomerListRecord value7(String value) {
        setCountry(value);
        return this;
    }

    @Override
    public JCustomerListRecord value8(String value) {
        setNotes(value);
        return this;
    }

    @Override
    public JCustomerListRecord value9(Integer value) {
        setSid(value);
        return this;
    }

    @Override
    public JCustomerListRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JCustomerListRecord
     */
    public JCustomerListRecord() {
        super(JCustomerList.CUSTOMER_LIST);
    }

    /**
     * Create a detached, initialised JCustomerListRecord
     */
    public JCustomerListRecord(Integer id, String name, String address, String zipCode, String phone, String city, String country, String notes, Integer sid) {
        super(JCustomerList.CUSTOMER_LIST);

        setId(id);
        setName(name);
        setAddress(address);
        setZipCode(zipCode);
        setPhone(phone);
        setCity(city);
        setCountry(country);
        setNotes(notes);
        setSid(sid);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised JCustomerListRecord
     */
    public JCustomerListRecord(jooq.jooq_dsl.tables.pojos.JCustomerList value) {
        super(JCustomerList.CUSTOMER_LIST);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setAddress(value.getAddress());
            setZipCode(value.getZipCode());
            setPhone(value.getPhone());
            setCity(value.getCity());
            setCountry(value.getCountry());
            setNotes(value.getNotes());
            setSid(value.getSid());
            resetChangedOnNotNull();
        }
    }
}
