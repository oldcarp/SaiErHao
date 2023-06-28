package com.example.saierhao.generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 技能
 * @TableName skill
 */
@TableName(value ="skill")
@Data
public class Skill implements Serializable {
    /**
     * 
     */
    @TableId(value = "skillID")
    private String skillID;

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
    @TableField(value = "skillName")
    private String skillName;

    /**
     * 
     */
    @TableField(value = "skillType")
    private String skillType;

    /**
     * 
     */
    @TableField(value = "skillMight")
    private String skillMight;

    /**
     * 
     */
    @TableField(value = "skillPP")
    private Integer skillPP;

    /**
     * 
     */
    @TableField(value = "skillEffect")
    private String skillEffect;

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
        Skill other = (Skill) that;
        return (this.getSkillID() == null ? other.getSkillID() == null : this.getSkillID().equals(other.getSkillID()))
            && (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSkillName() == null ? other.getSkillName() == null : this.getSkillName().equals(other.getSkillName()))
            && (this.getSkillType() == null ? other.getSkillType() == null : this.getSkillType().equals(other.getSkillType()))
            && (this.getSkillMight() == null ? other.getSkillMight() == null : this.getSkillMight().equals(other.getSkillMight()))
            && (this.getSkillPP() == null ? other.getSkillPP() == null : this.getSkillPP().equals(other.getSkillPP()))
            && (this.getSkillEffect() == null ? other.getSkillEffect() == null : this.getSkillEffect().equals(other.getSkillEffect()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSkillID() == null) ? 0 : getSkillID().hashCode());
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSkillName() == null) ? 0 : getSkillName().hashCode());
        result = prime * result + ((getSkillType() == null) ? 0 : getSkillType().hashCode());
        result = prime * result + ((getSkillMight() == null) ? 0 : getSkillMight().hashCode());
        result = prime * result + ((getSkillPP() == null) ? 0 : getSkillPP().hashCode());
        result = prime * result + ((getSkillEffect() == null) ? 0 : getSkillEffect().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", skillID=").append(skillID);
        sb.append(", ID=").append(ID);
        sb.append(", name=").append(name);
        sb.append(", skillName=").append(skillName);
        sb.append(", skillType=").append(skillType);
        sb.append(", skillMight=").append(skillMight);
        sb.append(", skillPP=").append(skillPP);
        sb.append(", skillEffect=").append(skillEffect);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}