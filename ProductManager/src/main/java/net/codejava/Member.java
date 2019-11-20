package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
public Long id;
public String name;
public String name_en;
public String father_name;
public String father_name_en;
public String address;
public String adhar_number;
public String pan_number;
public String account_number;
public String bank_name;
public String branch;
public String ifse;
public String email;
public String rasu;
public String pangada;
public String pangada2;
public String member_type;
public String nominee_name;
public String nominee_relation;
public String property_info;
public String nm_father_name;
public String gender;
public String phone_number;



public Member()
{
	
}






public Member(Long id, String name, String name_en, String father_name, String father_name_en, String address,
		String adhar_number, String pan_number, String account_number, String bank_name, String branch, String ifse,
		String email, String rasu, String pangada, String pangada2, String member_type, String nominee_name,
		String nominee_relation, String property_info, String nm_father_name, String gender, String phone_number) {
	super();
	this.id = id;
	this.name = name;
	this.name_en = name_en;
	this.father_name = father_name;
	this.father_name_en = father_name_en;
	this.address = address;
	this.adhar_number = adhar_number;
	this.pan_number = pan_number;
	this.account_number = account_number;
	this.bank_name = bank_name;
	this.branch = branch;
	this.ifse = ifse;
	this.email = email;
	this.rasu = rasu;
	this.pangada = pangada;
	this.pangada2 = pangada2;
	this.member_type = member_type;
	this.nominee_name = nominee_name;
	this.nominee_relation = nominee_relation;
	this.property_info = property_info;
	this.nm_father_name = nm_father_name;
	this.gender = gender;
	this.phone_number = phone_number;
}






public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getName_en() {
	return name_en;
}
public void setName_en(String name_en) {
	this.name_en = name_en;
}
public String getFather_name() {
	return father_name;
}
public void setFather_name(String father_name) {
	this.father_name = father_name;
}
public String getFather_name_en() {
	return father_name_en;
}
public void setFather_name_en(String father_name_en) {
	this.father_name_en = father_name_en;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAdhar_number() {
	return adhar_number;
}
public void setAdhar_number(String adhar_number) {
	this.adhar_number = adhar_number;
}
public String getPan_number() {
	return pan_number;
}
public void setPan_number(String pan_number) {
	this.pan_number = pan_number;
}
public String getAccount_number() {
	return account_number;
}
public void setAccount_number(String account_number) {
	this.account_number = account_number;
}
public String getBank_name() {
	return bank_name;
}
public void setBank_name(String bank_name) {
	this.bank_name = bank_name;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getIfse() {
	return ifse;
}
public void setIfse(String ifse) {
	this.ifse = ifse;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getRasu() {
	return rasu;
}
public void setRasu(String rasu) {
	this.rasu = rasu;
}
public String getPangada() {
	return pangada;
}
public void setPangada(String pangada) {
	this.pangada = pangada;
}
public String getPangada2() {
	return pangada2;
}
public void setPangada2(String pangada2) {
	this.pangada2 = pangada2;
}
public String getMember_type() {
	return member_type;
}
public void setMember_type(String member_type) {
	this.member_type = member_type;
}
public String getNominee_name() {
	return nominee_name;
}
public void setNominee_name(String nominee_name) {
	this.nominee_name = nominee_name;
}
public String getNominee_relation() {
	return nominee_relation;
}
public void setNominee_relation(String nominee_relation) {
	this.nominee_relation = nominee_relation;
}
public String getProperty_info() {
	return property_info;
}
public void setProperty_info(String property_info) {
	this.property_info = property_info;
}
public String getNm_father_name() {
	return nm_father_name;
}
public void setNm_father_name(String nm_father_name) {
	this.nm_father_name = nm_father_name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}






@Override
public String toString() {
	return "Member [id=" + id + ", name=" + name + ", name_en=" + name_en + ", father_name=" + father_name
			+ ", father_name_en=" + father_name_en + ", address=" + address + ", adhar_number=" + adhar_number
			+ ", pan_number=" + pan_number + ", account_number=" + account_number + ", bank_name=" + bank_name
			+ ", branch=" + branch + ", ifse=" + ifse + ", email=" + email + ", rasu=" + rasu + ", pangada=" + pangada
			+ ", pangada2=" + pangada2 + ", member_type=" + member_type + ", nominee_name=" + nominee_name
			+ ", nominee_relation=" + nominee_relation + ", property_info=" + property_info + ", nm_father_name="
			+ nm_father_name + ", gender=" + gender + ", phone_number=" + phone_number + "]";
}


}