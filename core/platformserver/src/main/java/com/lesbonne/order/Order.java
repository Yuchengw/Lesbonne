package com.lesbonne.order;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.entity.CommonEntityInfo;
import com.lesbonne.paymentmethod.PaymentMethod;
import com.lesbonne.sharingpost.SharingPost;
import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * @author jassica
 * @since 2
 * */
@Entity
@Table(name = "LESBONNEORDER")
public class Order extends CommonEntityInfo implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 379661088187729287L;
    
    @Id
    @Column(
            name = "ORDERID", nullable = false, unique = true,
            columnDefinition = "VARCHAR(18)")
    @GenericGenerator(
            strategy = "com.lesbonne.mysqldb.DBIdGenerator",
            name = "orderIdGenerator", parameters = { @Parameter(
                    name = "prefix", value = "00d") })
    @GeneratedValue(generator = "orderIdGenerator")
    private String orderId;
    
    @Column(name = "QUANTITY", columnDefinition = "TINYINT NOT NULL")
    private int quantity;
    
    @Column(
            name = "UNITPRICE",
            columnDefinition = "DECIMAL(10,2) NOT NULL default '0.00'")
    private double unitPrice;
    
    // TODO: need another ID to specify the order target.
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "USERID", referencedColumnName = "USERID", nullable = false)
    @JsonBackReference(value = "user-order")
    private User owner;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "SHARINGPOSTID", referencedColumnName = "SHARINGPOSTID",
            nullable = true)
    @JsonBackReference(value = "sharingpost-order")
    private SharingPost sharingPost;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ASKINGPOSTID", referencedColumnName = "ASKINGPOSTID",
            nullable = true)
    @JsonBackReference(value = "askingpost-order")
    private AskingPost askingPost;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "PAYMENTMETHODID", referencedColumnName = "PAYMENTMETHODID",
            nullable = true)
    @JsonBackReference(value = "paymentmethod-order")
    private PaymentMethod payment;
    
    @Column(name = "PAYMENTMETHOD_ID")
    private String paymentId;
    
    public String getPaymentId() {
        return this.paymentId;
    }
    
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public User getOwner() {
        return owner;
    }
    
    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    public SharingPost getSharingPost() {
        return sharingPost;
    }
    
    public void setSharingPost(SharingPost sharingPost) {
        this.sharingPost = sharingPost;
    }
    
    public AskingPost getAskingPost() {
        return askingPost;
    }
    
    public void setAskingPost(AskingPost askingPost) {
        this.askingPost = askingPost;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public PaymentMethod getPayment() {
        return payment;
    }
    
    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
        setPaymentId(payment.getPaymentMethodId());
    }
    
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("{" + "\"orderId\":\"" + getOrderId() + "\","
                + "\"unitPrice\":\"" + getUnitPrice() + "\","
                + "\"quantity\":\"" + getQuantity() + "\"");
        result.append(getOwner() != null ? "," + "\"owner\":{"
                + "\"userId\":\"" + getOwner().getUserId() + "\"" + "}" : "");
        result.append(getAskingPost() != null ? "," + "\"askingPost\":{"
                + "\"askingPostId\":\"" + getAskingPost().getAskingPostId()
                + "\"" + "}" : "");
        result.append(getSharingPost() != null ? "," + "\"sharingPost\":{"
                + "\"sharingPostId\":\"" + getSharingPost().getSharingPostId()
                + "\"" + "}" : "");
        result.append("}");
        return result.toString();
        
    }
}
