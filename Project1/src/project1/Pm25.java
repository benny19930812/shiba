package project1;

import java.sql.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Pm25 {

	private String Site;

	private	String county;

	private int PM25;

	private Date DataCreationDate;

	public String getSite() {
		return Site;
	}

	public void setSite(String site) {
		Site = site;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getPM25() {
		return PM25;
	}

	public void setPM25(int pM25) {
		PM25 = pM25;
	}

	public Date getDataCreationDate() {
		return DataCreationDate;
	}

	public void setDataCreationDate(Date dataCreationDate) {
		DataCreationDate = dataCreationDate;
	}

	




}
