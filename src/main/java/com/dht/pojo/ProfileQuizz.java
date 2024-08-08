/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duy
 */
@Entity
@Table(name = "profile_quizz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfileQuizz.findAll", query = "SELECT p FROM ProfileQuizz p"),
    @NamedQuery(name = "ProfileQuizz.findByProfileId", query = "SELECT p FROM ProfileQuizz p WHERE p.profileQuizzPK.profileId = :profileId"),
    @NamedQuery(name = "ProfileQuizz.findByQuizzId", query = "SELECT p FROM ProfileQuizz p WHERE p.profileQuizzPK.quizzId = :quizzId"),
    @NamedQuery(name = "ProfileQuizz.findByIsCompleted", query = "SELECT p FROM ProfileQuizz p WHERE p.isCompleted = :isCompleted")})
public class ProfileQuizz implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfileQuizzPK profileQuizzPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_completed")
    private boolean isCompleted;
    @JoinColumn(name = "profile_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profile profile;
    @JoinColumn(name = "quizz_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quizz quizz;

    public ProfileQuizz() {
    }

    public ProfileQuizz(ProfileQuizzPK profileQuizzPK) {
        this.profileQuizzPK = profileQuizzPK;
    }

    public ProfileQuizz(ProfileQuizzPK profileQuizzPK, boolean isCompleted) {
        this.profileQuizzPK = profileQuizzPK;
        this.isCompleted = isCompleted;
    }

    public ProfileQuizz(int profileId, int quizzId) {
        this.profileQuizzPK = new ProfileQuizzPK(profileId, quizzId);
    }

    public ProfileQuizzPK getProfileQuizzPK() {
        return profileQuizzPK;
    }

    public void setProfileQuizzPK(ProfileQuizzPK profileQuizzPK) {
        this.profileQuizzPK = profileQuizzPK;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileQuizzPK != null ? profileQuizzPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfileQuizz)) {
            return false;
        }
        ProfileQuizz other = (ProfileQuizz) object;
        if ((this.profileQuizzPK == null && other.profileQuizzPK != null) || (this.profileQuizzPK != null && !this.profileQuizzPK.equals(other.profileQuizzPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.ProfileQuizz[ profileQuizzPK=" + profileQuizzPK + " ]";
    }
    
}
