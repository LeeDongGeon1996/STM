package kw.comso.dto;

//이름. id(이메일) , pw, 권한, 생년월일, {{지역}},{{전화번호}})

public class MemberInfoVO {
   String userName;
   String email;
   String password;
   String birth;
   String address;
   String pNum;
   String auth;
   
   //setter
   
   public void setName(String userName) {
      this.userName = userName;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public void setBirth(String birth) {
      this.birth = birth;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public void setPNum(String pNum) {
      this.pNum = pNum;
   }
   public void setAuth(String auth) {
      this.auth = auth;
   }
   
   
   //getter
   public String getUserName() {
      return this.userName;
   }
   public String getEmail() {
      return this.email;
   }
   public String getPassword() {
      return this.password;
   }
   public String getBirth() {
      return this.birth;
   }
   public String getAddress() {
      return this.address;
   }
   public String getPNum() {
      return this.pNum;
   }
   public String getAuth() {
      return this.auth;
   }
}
