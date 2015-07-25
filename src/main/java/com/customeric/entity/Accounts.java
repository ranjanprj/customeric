/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author RanjanPr
 */
@Entity
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
     private String companyName, companyEmailAddress, phoneNumber, 
        street1, street2, zip , city ,stateName,country,twitterHandle,facebookHandle,linkdedInHandle,skypeHandle,blogUrl,comments;
     private String customerTypeChoice;

    public String getCustomerTypeChoice() {
        return customerTypeChoice;
    }

    public void setCustomerTypeChoice(String customerTypeChoice) {
        this.customerTypeChoice = customerTypeChoice;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getLinkdedInHandle() {
        return linkdedInHandle;
    }

    public void setLinkdedInHandle(String linkdedInHandle) {
        this.linkdedInHandle = linkdedInHandle;
    }

     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmailAddress() {
        return companyEmailAddress;
    }

    public void setCompanyEmailAddress(String companyEmailAddress) {
        this.companyEmailAddress = companyEmailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return stateName;
    }

    public void setState(String state) {
        this.stateName = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getFacebookHandle() {
        return facebookHandle;
    }

    public void setFacebookHandle(String facebookHandle) {
        this.facebookHandle = facebookHandle;
    }

    public String getLinkedInHandle() {
        return linkdedInHandle;
    }

    public void setLinkedInHandle(String linkedInHandle) {
        this.linkdedInHandle = linkedInHandle;
    }

    public String getSkypeHandle() {
        return skypeHandle;
    }

    public void setSkypeHandle(String skypeHandle) {
        this.skypeHandle = skypeHandle;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.customeric.entity.Account[ id=" + id + " ]";
    }
    
}
