package com.lesbonne.promotionusage;

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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lesbonne.entity.CommonEntityInfo;
import com.lesbonne.entity.EntityBean;
import com.lesbonne.promotion.PromotionCode;
import com.lesbonne.user.User;

/**
 * The entity to save the promotion information
 * 
 * @author Jassica
 * @since 1
 * */
@Entity
@Table(name = "PROMOTIONUSAGE")
public class PromotionUsage extends CommonEntityInfo implements Serializable {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = -3170417062437731815L;
    
    @Id
    @Column(
            name = "PROMOTIONUSAGEID", nullable = false, unique = true,
            columnDefinition = "VARCHAR(18)")
    @GenericGenerator(
            strategy = "com.lesbonne.mysqldb.DBIdGenerator",
            name = "promotionUsageIdGenerator", parameters = { @Parameter(
                    name = "prefix", value = "0pu") })
    @GeneratedValue(generator = "promotionUsageIdGenerator")
    private String promotionUsageId;
    
    @Column(name = "USEDTIMES", columnDefinition = "TINYINT NOT NULL")
    private int usedTimes;
    
    // Foreign keys
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "USERID", referencedColumnName = "USERID", nullable = true)
    @JsonBackReference(value = "user-promotionusage")
    private User usedBy;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "PROMOTIONCODEID", referencedColumnName = "PROMOTIONCODEID", nullable = false)
    @JsonBackReference(value = "promotion-usage")
    private PromotionCode promotionCode;
    
    public User getUsedBy() {
        return usedBy;
    }

    public void setUsedBy(User usedBy) {
        this.usedBy = usedBy;
    }

    public PromotionCode getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(PromotionCode promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getPromotionUsageId() {
        return promotionUsageId;
    }
    
    public void setPromotionUsageId(String promotionUsageId) {
        this.promotionUsageId = promotionUsageId;
    }
    
    public int getUsage() {
        return usedTimes;
    }

    public void setUsage(int usage) {
        this.usedTimes = usage;
    }
}
