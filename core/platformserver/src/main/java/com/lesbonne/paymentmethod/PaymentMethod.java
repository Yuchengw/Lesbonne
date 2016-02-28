package com.lesbonne.paymentmethod;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lesbonne.entity.CommonEntityInfo;
import com.lesbonne.order.Order;
import com.lesbonne.partner.Partner;
import com.lesbonne.user.User;

/**
 * @author Jassica
 * @since 1
 * */
@Entity
@Table(name = "PAYMENTMETHOD")
public class PaymentMethod extends CommonEntityInfo implements Serializable {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = -7116449282620644264L;
    
    @Id
    @Column(
            name = "PAYMENTMETHODID", nullable = false, unique = true,
            columnDefinition = "VARCHAR(18)")
    @GenericGenerator(
            strategy = "com.lesbonne.mysqldb.DBIdGenerator",
            name = "paymentMethodIdGenerator", parameters = { @Parameter(
                    name = "prefix", value = "0pm") })
    @GeneratedValue(generator = "paymentMethodIdGenerator")
    private String paymentMethodId;
    
    @Column(name = "PAYMENTTYPE", columnDefinition = "TINYINT NOT NULL")
    private int paymentType;
    
    // We will use the general 20 string column to hold different payment type
    // information
    // If paymentType is 1, it means credit card, hence
    // column1: credit card number; column2: expiration month; column3:
    // expiration year; column4: cvc; column5: cridit card type; column6: name
    // on card; column7: address without zipcode; column8: address zipcode;
    // If paymentType is 2, it means paypal and so far we don't know what field
    // information we need
    @Column(name = "COLUMN1", columnDefinition = "VARCHAR(255)")
    private String column1;
    
    @Column(name = "COLUMN2", columnDefinition = "VARCHAR(255)")
    private String column2;
    
    @Column(name = "COLUMN3", columnDefinition = "VARCHAR(255)")
    private String column3;
    
    @Column(name = "COLUMN4", columnDefinition = "VARCHAR(255)")
    private String column4;
    
    @Column(name = "COLUMN5", columnDefinition = "VARCHAR(255)")
    private String column5;
    
    @Column(name = "COLUMN6", columnDefinition = "VARCHAR(255)")
    private String column6;
    
    @Column(name = "COLUMN7", columnDefinition = "VARCHAR(255)")
    private String column7;
    
    @Column(name = "COLUMN8", columnDefinition = "VARCHAR(255)")
    private String column8;
    
    @Column(name = "COLUMN9", columnDefinition = "VARCHAR(255)")
    private String column9;
    
    @Column(name = "COLUMN10", columnDefinition = "VARCHAR(255)")
    private String column10;
    
    @Column(name = "COLUMN11", columnDefinition = "VARCHAR(255)")
    private String column11;
    
    @Column(name = "COLUMN12", columnDefinition = "VARCHAR(255)")
    private String column12;
    
    @Column(name = "COLUMN13", columnDefinition = "VARCHAR(255)")
    private String column13;
    
    @Column(name = "COLUMN14", columnDefinition = "VARCHAR(255)")
    private String column14;
    
    @Column(name = "COLUMN15", columnDefinition = "VARCHAR(255)")
    private String column15;
    
    @Column(name = "COLUMN16", columnDefinition = "VARCHAR(255)")
    private String column16;
    
    @Column(name = "COLUMN17", columnDefinition = "VARCHAR(255)")
    private String column17;
    
    @Column(name = "COLUMN18", columnDefinition = "VARCHAR(255)")
    private String column18;
    
    @Column(name = "COLUMN19", columnDefinition = "VARCHAR(255)")
    private String column19;
    
    @Column(name = "COLUMN20", columnDefinition = "VARCHAR(255)")
    private String column20;
    
    public String getPaymentMethodId() {
        return paymentMethodId;
    }
    
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    
    public int getPaymentType() {
        return paymentType;
    }
    
    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }
    
    public String getColumn1() {
        return column1;
    }
    
    public void setColumn1(String column1) {
        this.column1 = column1;
    }
    
    public String getColumn2() {
        return column2;
    }
    
    public void setColumn2(String column2) {
        this.column2 = column2;
    }
    
    public String getColumn3() {
        return column3;
    }
    
    public void setColumn3(String column3) {
        this.column3 = column3;
    }
    
    public String getColumn4() {
        return column4;
    }
    
    public void setColumn4(String column4) {
        this.column4 = column4;
    }
    
    public String getColumn5() {
        return column5;
    }
    
    public void setColumn5(String column5) {
        this.column5 = column5;
    }
    
    public String getColumn6() {
        return column6;
    }
    
    public void setColumn6(String column6) {
        this.column6 = column6;
    }
    
    public String getColumn7() {
        return column7;
    }
    
    public void setColumn7(String column7) {
        this.column7 = column7;
    }
    
    public String getColumn8() {
        return column8;
    }
    
    public void setColumn8(String column8) {
        this.column8 = column8;
    }
    
    public String getColumn9() {
        return column9;
    }
    
    public void setColumn9(String column9) {
        this.column9 = column9;
    }
    
    public String getColumn10() {
        return column10;
    }
    
    public void setColumn10(String column10) {
        this.column10 = column10;
    }
    
    public String getColumn11() {
        return column11;
    }
    
    public void setColumn11(String column11) {
        this.column11 = column11;
    }
    
    public String getColumn12() {
        return column12;
    }
    
    public void setColumn12(String column12) {
        this.column12 = column12;
    }
    
    public String getColumn13() {
        return column13;
    }
    
    public void setColumn13(String column13) {
        this.column13 = column13;
    }
    
    public String getColumn14() {
        return column14;
    }
    
    public void setColumn14(String column14) {
        this.column14 = column14;
    }
    
    public String getColumn15() {
        return column15;
    }
    
    public void setColumn15(String column15) {
        this.column15 = column15;
    }
    
    public String getColumn16() {
        return column16;
    }
    
    public void setColumn16(String column16) {
        this.column16 = column16;
    }
    
    public String getColumn17() {
        return column17;
    }
    
    public void setColumn17(String column17) {
        this.column17 = column17;
    }
    
    public String getColumn18() {
        return column18;
    }
    
    public void setColumn18(String column18) {
        this.column18 = column18;
    }
    
    public String getColumn19() {
        return column19;
    }
    
    public void setColumn19(String column19) {
        this.column19 = column19;
    }
    
    public String getColumn20() {
        return column20;
    }
    
    public void setColumn20(String column20) {
        this.column20 = column20;
    }
    
    // Foreign keys
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "USERID", referencedColumnName = "USERID", nullable = false)
    @JsonBackReference(value = "user-paymentmethod")
    private User owner;
    
    @OneToMany(
            mappedBy = "payment", fetch = FetchType.LAZY,
            targetEntity = Order.class)
    @JsonManagedReference(value="paymentmethod-order")
    private Set<Order> orders;
    
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    
}
