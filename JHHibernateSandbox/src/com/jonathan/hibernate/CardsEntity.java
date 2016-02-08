package com.jonathan.hibernate;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Jonathan on 1/25/2016.
 */
@Entity
@Table(name = "cards", schema = "haronez1_magic")
public class CardsEntity {
    private int cardId;
    private String cardName;
    private String cardType;
    private String rarity;
    private String manaCost;
    private String convertedManaCost;
    private String power;
    private String toughness;
    private String loyalty;
    private String abilityText;
    private String flavorText;
    private String variationNumber;
    private String artist;
    private String collectorNumber;
    private String rulingText;
    private String color;
    private Double price;
    private Double priceFoil;
    private Date priceDate;

    @Id
    @Column(name = "card_id", nullable = false)
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "card_name", nullable = true, length = -1)
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Basic
    @Column(name = "card_type", nullable = true, length = -1)
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "rarity", nullable = true, length = -1)
    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    @Basic
    @Column(name = "mana_cost", nullable = true, length = -1)
    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    @Basic
    @Column(name = "converted_mana_cost", nullable = true, length = -1)
    public String getConvertedManaCost() {
        return convertedManaCost;
    }

    public void setConvertedManaCost(String convertedManaCost) {
        this.convertedManaCost = convertedManaCost;
    }

    @Basic
    @Column(name = "power", nullable = true, length = -1)
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Basic
    @Column(name = "toughness", nullable = true, length = -1)
    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    @Basic
    @Column(name = "loyalty", nullable = true, length = -1)
    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    @Basic
    @Column(name = "ability_text", nullable = true, length = -1)
    public String getAbilityText() {
        return abilityText;
    }

    public void setAbilityText(String abilityText) {
        this.abilityText = abilityText;
    }

    @Basic
    @Column(name = "flavor_text", nullable = true, length = -1)
    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    @Basic
    @Column(name = "variation_number", nullable = true, length = -1)
    public String getVariationNumber() {
        return variationNumber;
    }

    public void setVariationNumber(String variationNumber) {
        this.variationNumber = variationNumber;
    }

    @Basic
    @Column(name = "artist", nullable = true, length = -1)
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Basic
    @Column(name = "collector_number", nullable = true, length = -1)
    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    @Basic
    @Column(name = "ruling_text", nullable = true, length = -1)
    public String getRulingText() {
        return rulingText;
    }

    public void setRulingText(String rulingText) {
        this.rulingText = rulingText;
    }

    @Basic
    @Column(name = "color", nullable = true, length = -1)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "price_foil", nullable = true, precision = 0)
    public Double getPriceFoil() {
        return priceFoil;
    }

    public void setPriceFoil(Double priceFoil) {
        this.priceFoil = priceFoil;
    }

    @Basic
    @Column(name = "price_date", nullable = true)
    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    /* This is the many to one annotation and getter */
//    @ManyToOne(fetch = FetchType.LAZY)
//    private SetsEntity set;
//    public SetsEntity getSet(){
//        return set;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardsEntity that = (CardsEntity) o;

        if (cardId != that.cardId) return false;
        if (cardName != null ? !cardName.equals(that.cardName) : that.cardName != null) return false;
        if (cardType != null ? !cardType.equals(that.cardType) : that.cardType != null) return false;
        if (rarity != null ? !rarity.equals(that.rarity) : that.rarity != null) return false;
        if (manaCost != null ? !manaCost.equals(that.manaCost) : that.manaCost != null) return false;
        if (convertedManaCost != null ? !convertedManaCost.equals(that.convertedManaCost) : that.convertedManaCost != null)
            return false;
        if (power != null ? !power.equals(that.power) : that.power != null) return false;
        if (toughness != null ? !toughness.equals(that.toughness) : that.toughness != null) return false;
        if (loyalty != null ? !loyalty.equals(that.loyalty) : that.loyalty != null) return false;
        if (abilityText != null ? !abilityText.equals(that.abilityText) : that.abilityText != null) return false;
        if (flavorText != null ? !flavorText.equals(that.flavorText) : that.flavorText != null) return false;
        if (variationNumber != null ? !variationNumber.equals(that.variationNumber) : that.variationNumber != null)
            return false;
        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;
        if (collectorNumber != null ? !collectorNumber.equals(that.collectorNumber) : that.collectorNumber != null)
            return false;
        if (rulingText != null ? !rulingText.equals(that.rulingText) : that.rulingText != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (priceFoil != null ? !priceFoil.equals(that.priceFoil) : that.priceFoil != null) return false;
        if (priceDate != null ? !priceDate.equals(that.priceDate) : that.priceDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardId;
        result = 31 * result + (cardName != null ? cardName.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        result = 31 * result + (rarity != null ? rarity.hashCode() : 0);
        result = 31 * result + (manaCost != null ? manaCost.hashCode() : 0);
        result = 31 * result + (convertedManaCost != null ? convertedManaCost.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (toughness != null ? toughness.hashCode() : 0);
        result = 31 * result + (loyalty != null ? loyalty.hashCode() : 0);
        result = 31 * result + (abilityText != null ? abilityText.hashCode() : 0);
        result = 31 * result + (flavorText != null ? flavorText.hashCode() : 0);
        result = 31 * result + (variationNumber != null ? variationNumber.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (collectorNumber != null ? collectorNumber.hashCode() : 0);
        result = 31 * result + (rulingText != null ? rulingText.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (priceFoil != null ? priceFoil.hashCode() : 0);
        result = 31 * result + (priceDate != null ? priceDate.hashCode() : 0);
        return result;
    }

    private SetsEntity setsEntities;

//    @ManyToOne(optional = false)
//    public SetsEntity getSetsEntities() {
//        return setsEntities;
//    }

    public void setSetsEntities(SetsEntity setsEntities) {
        this.setsEntities = setsEntities;
    }
}
