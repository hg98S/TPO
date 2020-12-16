package com.kh.tpo.rest.domain;

public class RestInfo {
	private int reNo;
	private String reName;
	private String reAddr;
	private String reImage;
	private String rePhone;
	private String reUrl;
	private String reInfo;
	private String checkIn;
	private String checkout;
	private int rTotal;
	private int pTotal;
	private String pStatus;
	private String reFacility;
	private int clcik;
	private int rNo;
	private String roName;
	private int roPrice;
	private int pLimit;
	private String roInfo;
	private String roFacility;
	private String roSize;
	private String roImage;
	private int pMaxCount;
	private int roCount;
	
	public RestInfo() {}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}

	public String getReName() {
		return reName;
	}

	public void setReName(String reName) {
		this.reName = reName;
	}

	public String getReAddr() {
		return reAddr;
	}

	public void setReAddr(String reAddr) {
		this.reAddr = reAddr;
	}

	public String getReImage() {
		return reImage;
	}

	public void setReImage(String reImage) {
		this.reImage = reImage;
	}

	public String getRePhone() {
		return rePhone;
	}

	public void setRePhone(String rePhone) {
		this.rePhone = rePhone;
	}

	public String getReUrl() {
		return reUrl;
	}

	public void setReUrl(String reUrl) {
		this.reUrl = reUrl;
	}

	public String getReInfo() {
		return reInfo;
	}

	public void setReInfo(String reInfo) {
		this.reInfo = reInfo;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public int getrTotal() {
		return rTotal;
	}

	public void setrTotal(int rTotal) {
		this.rTotal = rTotal;
	}

	public int getpTotal() {
		return pTotal;
	}

	public void setpTotal(int pTotal) {
		this.pTotal = pTotal;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public String getReFacility() {
		return reFacility;
	}

	public void setReFacility(String reFacility) {
		this.reFacility = reFacility;
	}

	public int getClcik() {
		return clcik;
	}

	public void setClcik(int clcik) {
		this.clcik = clcik;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getRoName() {
		return roName;
	}

	public void setRoName(String roName) {
		this.roName = roName;
	}

	public int getRoPrice() {
		return roPrice;
	}

	public void setRoPrice(int roPrice) {
		this.roPrice = roPrice;
	}

	public int getpLimit() {
		return pLimit;
	}

	public void setpLimit(int pLimit) {
		this.pLimit = pLimit;
	}

	public String getRoInfo() {
		return roInfo;
	}

	public void setRoInfo(String roInfo) {
		this.roInfo = roInfo;
	}

	public String getRoFacility() {
		return roFacility;
	}

	public void setRoFacility(String roFacility) {
		this.roFacility = roFacility;
	}

	public String getRoSize() {
		return roSize;
	}

	public void setRoSize(String roSize) {
		this.roSize = roSize;
	}

	public String getRoImage() {
		return roImage;
	}

	public void setRoImage(String roImage) {
		this.roImage = roImage;
	}

	public int getpMaxCount() {
		return pMaxCount;
	}

	public void setpMaxCount(int pMaxCount) {
		this.pMaxCount = pMaxCount;
	}

	public int getRoCount() {
		return roCount;
	}

	public void setRoCount(int roCount) {
		this.roCount = roCount;
	}

	@Override
	public String toString() {
		return "RestInfo [reNo=" + reNo + ", reName=" + reName + ", reAddr=" + reAddr + ", reImage=" + reImage
				+ ", rePhone=" + rePhone + ", reUrl=" + reUrl + ", reInfo=" + reInfo + ", checkIn=" + checkIn
				+ ", checkout=" + checkout + ", rTotal=" + rTotal + ", pTotal=" + pTotal + ", pStatus=" + pStatus
				+ ", reFacility=" + reFacility + ", clcik=" + clcik + ", rNo=" + rNo + ", roName=" + roName
				+ ", roPrice=" + roPrice + ", pLimit=" + pLimit + ", roInfo=" + roInfo + ", roFacility=" + roFacility
				+ ", roSize=" + roSize + ", roImage=" + roImage + ", pMaxCount=" + pMaxCount + ", roCount=" + roCount
				+ "]";
	}

	public RestInfo(int reNo, String reName, String reAddr, String reImage, String rePhone, String reUrl, String reInfo,
			String checkIn, String checkout, int rTotal, int pTotal, String pStatus, String reFacility, int clcik,
			int rNo, String roName, int roPrice, int pLimit, String roInfo, String roFacility, String roSize,
			String roImage, int pMaxCount, int roCount) {
		super();
		this.reNo = reNo;
		this.reName = reName;
		this.reAddr = reAddr;
		this.reImage = reImage;
		this.rePhone = rePhone;
		this.reUrl = reUrl;
		this.reInfo = reInfo;
		this.checkIn = checkIn;
		this.checkout = checkout;
		this.rTotal = rTotal;
		this.pTotal = pTotal;
		this.pStatus = pStatus;
		this.reFacility = reFacility;
		this.clcik = clcik;
		this.rNo = rNo;
		this.roName = roName;
		this.roPrice = roPrice;
		this.pLimit = pLimit;
		this.roInfo = roInfo;
		this.roFacility = roFacility;
		this.roSize = roSize;
		this.roImage = roImage;
		this.pMaxCount = pMaxCount;
		this.roCount = roCount;
	}
	
	
	

}
