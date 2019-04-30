package vo;

public class MemberVo {

 private String userid;
 private String name;
 private String password;
 private String birthyear;
 private String addr;
 private String signdate;
 
 public String getPassword() {
	 return password;
 }
 public void setPassword(String password) {
	 this.password = password;
 }
 public String getBirthyear() {
  return birthyear;
 }
 public void setBirthyear(String birthyear) {
  this.birthyear = birthyear;
 }
 public String getAddr() {
  return addr;
 }
 public void setAddr(String addr) {
  this.addr = addr;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getUserid() {
  return userid;
 }
 public void setUserid(String userid) {
  this.userid = userid;
 }
 public String getSigndate() {
	 return signdate;
 }
 public void setSigndate(String signdate) {
	 this.signdate = signdate;
 }

 
 public String toString() {
  return " MemberVo [ name=" + name + 
               ", userid" +  userid +
               ", addr=" + addr +
               ", birthyear=" + birthyear +"]";
 }

}
