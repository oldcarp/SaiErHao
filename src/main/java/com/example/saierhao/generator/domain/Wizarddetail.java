package com.example.saierhao.generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName wizarddetail
 */
@TableName(value ="wizarddetail")
@Data
public class Wizarddetail implements Serializable {
    /**
     * 
     */
    @TableId(value = "ID")
    private String ID;

    /**
     * 
     */
    @TableField(value = "name")
    private String name;

    /**
     * 
     */
    @TableField(value = "Stats")
    private String stats;

    /**
     * 
     */
    @TableField(value = "Soulmark")
    private String soulmark;

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
        Wizarddetail other = (Wizarddetail) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStats() == null ? other.getStats() == null : this.getStats().equals(other.getStats()))
            && (this.getSoulmark() == null ? other.getSoulmark() == null : this.getSoulmark().equals(other.getSoulmark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStats() == null) ? 0 : getStats().hashCode());
        result = prime * result + ((getSoulmark() == null) ? 0 : getSoulmark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", name=").append(name);
        sb.append(", stats=").append(stats);
        sb.append(", soulmark=").append(soulmark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}