package com.tomash.contactgetter.entity;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;


public class Contact {
    private int contactId;
    private List<Email> emailList = new ArrayList<>();
    private List<PhoneNumber> phoneList = new ArrayList<>();
    private List<Address> addressesList = new ArrayList<>();
    private List<String> websitesList = new ArrayList<>();
    private List<IMAddress> imAddressesList = new ArrayList<>();
    private List<Relation> relationsList = new ArrayList<>();
    private List<SpecialDate> specialDatesList = new ArrayList<>();
    private List<Group> groupList = new ArrayList<>();
    private String note = "";
    private String nickName = "";
    private String sipAddress = "";
    private Uri photoUri = Uri.EMPTY;
    private Organization organization = new Organization();
    private NameData nameData = new NameData();
    private String compositeName;
    private long lastModificationDate;


    public int getContactId() {
        return contactId;
    }

    public Contact setContactId(int contactId) {
        this.contactId = contactId;
        return this;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public Contact setEmailList(List<Email> emailList) {
        if (emailList == null) return this;
        this.emailList = emailList;
        return this;
    }

    public List<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    public Contact setPhoneList(List<PhoneNumber> phoneList) {
        if (phoneList == null) return this;
        this.phoneList = phoneList;
        return this;
    }

    /**
     * Returns {@link Uri#EMPTY} in case of no photo , otherwise returns Uri with photo for current contact
     */
    public Uri getPhotoUri() {
        return photoUri;
    }

    public Contact setPhotoUri(Uri photoUri) {
        if (photoUri == null) return this;
        this.photoUri = photoUri;
        return this;
    }

    public List<Address> getAddressesList() {
        return addressesList;
    }

    public Contact setAddressesList(List<Address> addressesList) {
        if (addressesList == null) return this;
        this.addressesList = addressesList;
        return this;
    }

    public String getCompositeName() {
        return compositeName;
    }

    public Contact setCompositeName(String compositeName) {
        this.compositeName = compositeName;
        return this;
    }

    public List<String> getWebsitesList() {
        return websitesList;
    }

    public Contact setWebsitesList(List<String> websitesList) {
        if (websitesList == null) return this;
        this.websitesList = websitesList;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Contact setNote(String note) {
        if (note == null) return this;
        this.note = note;
        return this;
    }

    /**
     * <p>
     *     Gets last modification timestamp in Unix time
     * </p>
     * <p>
     *     AVAILABLE FROM 18 API
     * </p>
     *
     */
    public long getLastModificationDate() {
        return lastModificationDate;
    }

    public Contact setLastModificationDate(long lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public List<IMAddress> getImAddressesList() {
        return imAddressesList;
    }

    public Contact setImAddressesList(List<IMAddress> imAddressesList) {
        if (imAddressesList == null) return this;
        this.imAddressesList = imAddressesList;
        return this;
    }

    public List<Relation> getRelationsList() {
        return relationsList;
    }

    public Contact setRelationsList(List<Relation> relationsList) {
        if (relationsList == null) return this;
        this.relationsList = relationsList;
        return this;
    }

    public List<SpecialDate> getSpecialDatesList() {
        return specialDatesList;
    }

    public Contact setSpecialDatesList(List<SpecialDate> specialDatesList) {
        if (specialDatesList == null) return this;
        this.specialDatesList = specialDatesList;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public Contact setNickName(String nickName) {
        if (nickName == null) return this;
        this.nickName = nickName;
        return this;
    }

    public String getSipAddress() {
        return sipAddress;
    }

    public Contact setSipAddress(String sipAddress) {
        if (sipAddress == null) return this;
        this.sipAddress = sipAddress;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Contact setOrganization(Organization organization) {
        if (organization == null) return this;
        this.organization = organization;
        return this;
    }

    public NameData getNameData() {
        return nameData;
    }

    public Contact setNameData(NameData nameData) {
        if (nameData == null) return this;
        this.nameData = nameData;
        return this;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public Contact setGroupList(List<Group> groupList) {
        if(groupList==null) return this;
        this.groupList = groupList;
        return this;
    }
}