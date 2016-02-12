package com.lesbonne.promotion;

import java.io.Serializable;
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
import com.lesbonne.entity.EntityBean;
import com.lesbonne.promotionusage.PromotionUsage;
import com.lesbonne.user.User;

/**
 * The entity to save the promotion information
 * 
 * @author Jassica
 * @since 1
 * */
@Entity
@Table(name = "PROMOTIONCODE")
public class PromotionCode extends CommonEntityInfo implements Serializable {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = -3170417062437731815L;
    
    @Id
    @Column(
            name = "PROMOTIONCODEID", nullable = false, unique = true,
            columnDefinition = "VARCHAR(18)")
    @GenericGenerator(
            strategy = "com.lesbonne.mysqldb.DBIdGenerator",
            name = "promotionCodeIdGenerator", parameters = { @Parameter(
                    name = "prefix", value = "0pc") })
    @GeneratedValue(generator = "promotionCodeIdGenerator")
    private String promotionCodeId;
    
    @Column(
            name = "PROMOTIONCODEVALUE",
            columnDefinition = "VARCHAR(20) NOT NULL")
    private String promotionCodeValue;
    
    @Column(name = "EXPIREDAT", columnDefinition = "DATETIME NOT NULL")
    private String expiredAt;
    
    // Foreign keys
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "USERID", referencedColumnName = "USERID", nullable = false)
    @JsonBackReference(value = "user-promotion")
    private User owner;
    
    @OneToMany(
            mappedBy = "promotionCode", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = PromotionUsage.class)
    @JsonManagedReference(value = "promotion-usage")
    private Set<PromotionUsage> promotionUsages;
    
    public User getOwner() {
        return owner;
    }
    
    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    public String getPromotionCodeId() {
        return promotionCodeId;
    }
    
    public void setPromotionCodeId(String promotionCodeId) {
        this.promotionCodeId = promotionCodeId;
    }
    
    public String getPromotionCodeValue() {
        return promotionCodeValue;
    }
    
    public void setPromotionCodeValue(String promotionCodeValue) {
        this.promotionCodeValue = promotionCodeValue;
    }
    
    public String getExpiredAt() {
        return expiredAt;
    }
    
    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }
    
    public Set<PromotionUsage> getPromotionUsages() {
        return promotionUsages;
    }

    public void setPromotionUsages(Set<PromotionUsage> promotionUsages) {
        this.promotionUsages = promotionUsages;
    }
}
