package login;

import java.io.Serializable;

public class studentBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
       
	private String stdRollNo, stdName,stdMother, stdAddress, StdPartNo, stdClass, adharNo;

	public String getStdRollNo() {
		return stdRollNo;
	}

	public void setStdRollNo(String stdRollNo) {
		this.stdRollNo = stdRollNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdMother() {
		return stdMother;
	}

	public void setStdMother(String stdMother) {
		this.stdMother = stdMother;
	}

	public String getStdAddress() {
		return stdAddress;
	}

	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}

	public String getStdPartNo() {
		return StdPartNo;
	}

	public void setStdPartNo(String stdPartNo) {
		StdPartNo = stdPartNo;
	}

	public String getStdClass() {
		return stdClass;
	}

	public void setStdClass(String stdClass) {
		this.stdClass = stdClass;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	
	
	
}
