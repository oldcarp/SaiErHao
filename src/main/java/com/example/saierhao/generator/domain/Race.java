package com.example.saierhao.generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 种族值
 * @TableName race
 */
@TableName(value ="race")
@Data
public class Race implements Serializable {
    /**
     * 
     */
    @TableId(value = "raceID")
    private String raceID;

    /**
     * 
     */
    @TableField(value = "ID")
    private String ID;

    /**
     * 
     */
    @TableField(value = "name")
    private String name;

    /**
     * 
     */
    @TableField(value = "raceHP")
    private Integer raceHP;

    /**
     * 
     */
    @TableField(value = "raceGJ")
    private Integer raceGJ;

    /**
     * 
     */
    @TableField(value = "raceTG")
    private Integer raceTG;

    /**
     * 
     */
    @TableField(value = "raceFY")
    private Integer raceFY;

    /**
     * 
     */
    @TableField(value = "raceTF")
    private Integer raceTF;

    /**
     * 
     */
    @TableField(value = "raceSD")
    private Integer raceSD;

    /**
     * 
     */
    @TableField(value = "raceNum")
    private Integer raceNum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Race other = (Race) that;
        return (this.getRaceID() == null ? other.getRaceID() == null : this.getRaceID().equals(other.getRaceID()))
            && (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRaceHP() == null ? other.getRaceHP() == null : this.getRaceHP().equals(other.getRaceHP()))
            && (this.getRaceGJ() == null ? other.getRaceGJ() == null : this.getRaceGJ().equals(other.getRaceGJ()))
            && (this.getRaceTG() == null ? other.getRaceTG() == null : this.getRaceTG().equals(other.getRaceTG()))
            && (this.getRaceFY() == null ? other.getRaceFY() == null : this.getRaceFY().equals(other.getRaceFY()))
            && (this.getRaceTF() == null ? other.getRaceTF() == null : this.getRaceTF().equals(other.getRaceTF()))
            && (this.getRaceSD() == null ? other.getRaceSD() == null : this.getRaceSD().equals(other.getRaceSD()))
            && (this.getRaceNum() == null ? other.getRaceNum() == null : this.getRaceNum().equals(other.getRaceNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRaceID() == null) ? 0 : getRaceID().hashCode());
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRaceHP() == null) ? 0 : getRaceHP().hashCode());
        result = prime * result + ((getRaceGJ() == null) ? 0 : getRaceGJ().hashCode());
        result = prime * result + ((getRaceTG() == null) ? 0 : getRaceTG().hashCode());
        result = prime * result + ((getRaceFY() == null) ? 0 : getRaceFY().hashCode());
        result = prime * result + ((getRaceTF() == null) ? 0 : getRaceTF().hashCode());
        result = prime * result + ((getRaceSD() == null) ? 0 : getRaceSD().hashCode());
        result = prime * result + ((getRaceNum() == null) ? 0 : getRaceNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", raceID=").append(raceID);
        sb.append(", ID=").append(ID);
        sb.append(", name=").append(name);
        sb.append(", raceHP=").append(raceHP);
        sb.append(", raceGJ=").append(raceGJ);
        sb.append(", raceTG=").append(raceTG);
        sb.append(", raceFY=").append(raceFY);
        sb.append(", raceTF=").append(raceTF);
        sb.append(", raceSD=").append(raceSD);
        sb.append(", raceNum=").append(raceNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}