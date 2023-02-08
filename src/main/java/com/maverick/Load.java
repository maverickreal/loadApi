package com.maverick;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;

@Entity
public class Load {
    private String loadingPoint, unloadingPoint, productType,
                   truckType, comment, date,
                   sid;
    private int noOfTrucks, weight;
    @Id @SequenceGenerator(name = "load_id_sequence", sequenceName = "load_id_sequence", allocationSize = 1) @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "load_id_sequence")
    private int id;

    public Load(){}

    public Load(String LoadingPoint, String UnloadingPoint, String ProductType,
        String TruckType, String Comment, String Date,
        String Sid, int NoOfTrucks, int Weight) {
        this.loadingPoint = LoadingPoint;
        this.unloadingPoint = UnloadingPoint;
        this.productType = ProductType;
        this.truckType = TruckType;
        this.comment = Comment;
        this.date = Date;
        this.sid = Sid;
        this.noOfTrucks = NoOfTrucks;
        this.weight = Weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String Sid) {
        this.sid = Sid;
    }

    public int getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(int noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Load)) return false;
        Load load = (Load) o;
        return noOfTrucks == load.noOfTrucks &&
                weight == load.weight &&
                id == load.id &&
                Objects.equals(loadingPoint, load.loadingPoint) &&
                Objects.equals(unloadingPoint, load.unloadingPoint) &&
                Objects.equals(productType, load.productType) &&
                Objects.equals(truckType, load.truckType) &&
                Objects.equals(comment, load.comment) &&
                Objects.equals(date, load.date) &&
                Objects.equals(sid, load.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadingPoint, unloadingPoint, productType, truckType, comment, date, sid, noOfTrucks, weight, id);
    }

    @Override
    public String toString() {
        return "Load{" +
                "loadingPoint='" + loadingPoint + '\'' +
                ", unloadingPoint='" + unloadingPoint + '\'' +
                ", productType='" + productType + '\'' +
                ", truckType='" + truckType + '\'' +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                ", sid='" + sid + '\'' +
                ", noOfTrucks=" + noOfTrucks +
                ", weight=" + weight +
                ", id=" + id +
                '}';
    }
}