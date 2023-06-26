package com.example.saierhao.generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName passivity
 */
@TableName(value ="passivity")
@Data
public class Passivity implements Serializable {
    /**
     * 
     */
    @TableId(value = "passivityID")
    private String passivityID;

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
    @TableField(value = "passivityName")
    private String passivityName;

    /**
     * 
     */
    @TableField(value = "passivityEffect")
    private String passivityEffect;

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
        Passivity other = (Passivity) that;
        return (this.getPassivityID() == null ? other.getPassivityID() == null : this.getPassivityID().equals(other.getPassivityID()))
            && (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassivityName() == null ? other.getPassivityName() == null : this.getPassivityName().equals(other.getPassivityName()))
            && (this.getPassivityEffect() == null ? other.getPassivityEffect() == null : this.getPassivityEffect().equals(other.getPassivityEffect()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPassivityID() == null) ? 0 : getPassivityID().hashCode());
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassivityName() == null) ? 0 : getPassivityName().hashCode());
        result = prime * result + ((getPassivityEffect() == null) ? 0 : getPassivityEffect().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", passivityID=").append(passivityID);
        sb.append(", ID=").append(ID);
        sb.append(", name=").append(name);
        sb.append(", passivityName=").append(passivityName);
        sb.append(", passivityEffect=").append(passivityEffect);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}