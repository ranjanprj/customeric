/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customeric.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ranjan
 */
@Entity

@NamedQueries({    
    @NamedQuery( name = "findUserFromUserName", query = "SELECT U FROM Users U WHERE U.userName = :userName"),
    @NamedQuery( name = "searchUserFromUserName", query = "SELECT U FROM Users U WHERE lower(U.firstName) like lower(:userName) or  lower(U.lastName) like lower(:userName)")
        
})
public class Users implements Serializable {
//firstName, lastName, companyEmailAddress, personalEmailAddress, phoneNumber, 
        //street1, street2, zip , city ,stateName,country,twitterHandle,facebookHandle,linkedHandle,skypeHandle,blogUrl,comments
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String userName,password, salt;   

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dob,doj;   
    private String sessionId;    
    private List<String> reportees,reportsTo,followedBy;
    
    private String title,firstName, lastName, companyEmailAddress, personalEmailAddress, phoneNumber, 
        street1, street2, zip , city ,stateName,country,twitterHandle,facebookHandle,linkedInHandle,skypeHandle,blogUrl,comments;
    
    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<String> getReportees() {
        return reportees;
    }

    public void setReportees(List<String> reportees) {
        this.reportees = reportees;
    }

    public List<String> getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(List<String> reportsTo) {
        this.reportsTo = reportsTo;
    }

    public List<String> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(List<String> followedBy) {
        this.followedBy = followedBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyEmailAddress() {
        return companyEmailAddress;
    }

    public void setCompanyEmailAddress(String companyEmailAddress) {
        this.companyEmailAddress = companyEmailAddress;
    }

    public String getPersonalEmailAddress() {
        return personalEmailAddress;
    }

    public void setPersonalEmailAddress(String personalEmailAddress) {
        this.personalEmailAddress = personalEmailAddress;
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
        return linkedInHandle;
    }

    public void setLinkedInHandle(String linkedInHandle) {
        this.linkedInHandle = linkedInHandle;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
