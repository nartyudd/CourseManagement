/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Duy
 */
@Embeddable
public class ProfileQuizzPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "profile_id")
    private int profileId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quizz_id")
    private int quizzId;

    public ProfileQuizzPK() {
    }

    public ProfileQuizzPK(int profileId, int quizzId) {
        this.profileId = profileId;
        this.quizzId = quizzId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getQuizzId() {
        return quizzId;
    }

    public void setQuizzId(int quizzId) {
        this.quizzId = quizzId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) profileId;
        hash += (int) quizzId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileQuizzPK)) {
            return false;
        }
        ProfileQuizzPK other = (ProfileQuizzPK) object;
        if (this.profileId != other.profileId) {
            return false;
        }
        if (this.quizzId != other.quizzId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.ProfileQuizzPK[ profileId=" + profileId + ", quizzId=" + quizzId + " ]";
    }
    
}
