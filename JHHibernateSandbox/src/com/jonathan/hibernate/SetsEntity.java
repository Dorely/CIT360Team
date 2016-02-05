package com.jonathan.hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Jonathan on 1/25/2016.
 */
@Entity
@Table(name = "sets", schema = "haronez1_magic")
public class SetsEntity {
    private int setId;
    private String setName;
    private String officialCode;
    private String variantCode;
    private Date releaseDate;
    private Set<CardsEntity> cards;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardId") //JUST IGNORE THE RED LINE
    public Set<CardsEntity> getCards() {
        return cards;
    }

    public void setCards(Set<CardsEntity> cards) {
        this.cards = cards;
    }

    @Id
    @Column(name = "set_id", nullable = false)
    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    @Basic
    @Column(name = "set_name", nullable = true, length = 200)
    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    @Basic
    @Column(name = "official_code", nullable = true, length = 5)
    public String getOfficialCode() {
        return officialCode;
    }

    public void setOfficialCode(String officialCode) {
        this.officialCode = officialCode;
    }

    @Basic
    @Column(name = "variant_code", nullable = true, length = 5)
    public String getVariantCode() {
        return variantCode;
    }

    public void setVariantCode(String variantCode) {
        this.variantCode = variantCode;
    }

    @Basic
    @Column(name = "release_date", nullable = true)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /* This is the one to many annotation and getter */
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "setsEntities")
//    @OneToMany(cascade = CascadeType.MERGE)
//    @Fetch(FetchMode.JOIN)
//    @JoinTable(
//        name = "cards",
//        joinColumns = {@JoinColumn(name="set_id")},
//        inverseJoinColumns = {@JoinColumn(name="set_id")}
//    )
//    private Set<CardsEntity> cards;
//    public Set<CardsEntity> getCards(){
//        return cards;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetsEntity that = (SetsEntity) o;

        if (setId != that.setId) return false;
        if (setName != null ? !setName.equals(that.setName) : that.setName != null) return false;
        if (officialCode != null ? !officialCode.equals(that.officialCode) : that.officialCode != null) return false;
        if (variantCode != null ? !variantCode.equals(that.variantCode) : that.variantCode != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = setId;
        result = 31 * result + (setName != null ? setName.hashCode() : 0);
        result = 31 * result + (officialCode != null ? officialCode.hashCode() : 0);
        result = 31 * result + (variantCode != null ? variantCode.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }
}
