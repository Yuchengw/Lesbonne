package com.lesbonne.paymentmethod;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The CreditCard information entity holder
 * 
 * @author jassica
 *
 */
@JsonIgnoreProperties(value = { "column1", "column2", "column3", "column4",
        "column5", "column6", "column7", "column8", "column9", "column10",
        "column11", "column12", "column13", "column14", "column15", "column16",
        "column17", "column18", "column19", "column20" })
public class CreditCard extends PaymentMethod {
    private static final long serialVersionUID = -7116449282620644265L;
    
    public CreditCard() {
        setPaymentType(1);
    }
    
    public int getPaymentType() {
        return 1;
    }
    
    public void setPaymentType(int paymentType) {
        super.setPaymentType(1);
    }
    
    // We will use the general 20 string column to hold different payment type
    // information
    // If paymentType is 1, it means credit card, hence
    // column1: credit card number; column2: expiration month; column3:
    // expiration year; column4: cvc; column5: cridit card type; column6: name
    // on card; column7: address without zipcode; column8: address zipcode;
    // If paymentType is 2, it means paypal and so far we don't know what field
    // information we need
    public String getCardNumber() {
        return super.getColumn1();
    }
    
    public void setCardNumber(String value) {
        super.setColumn1(value);
    }
    
    public String getExpireMonth() {
        return super.getColumn2();
    }
    
    public void setExpireMonth(String value) {
        super.setColumn2(value);
    }
    
    public String getExpireYear() {
        return super.getColumn3();
    }
    
    public void setExpireYear(String value) {
        super.setColumn3(value);
    }
    
    public String getCVC() {
        return super.getColumn4();
    }
    
    public void setCVC(String value) {
        super.setColumn4(value);
    }
    
    public String getCardType() {
        return super.getColumn5();
    }
    
    public void setCardType(String value) {
        super.setColumn5(value);
    }
    
    public CreditCard(PaymentMethod p) {
        setCardNumber(p.getColumn1());
        setExpireMonth(p.getColumn2());
        setExpireYear(p.getColumn3());
        setCVC(p.getColumn4());
        setCardType(p.getColumn5());
        setPaymentMethodId(p.getPaymentMethodId());
        setPaymentType(getPaymentType());
        setLastModifiedTime(getLastModifiedTime());
        setOwner(getOwner());
    }
}
