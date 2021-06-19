package com.cafe2team.domain;

public class Sales {
	private String contractFianlCode;
	private String shoppingMallName;
	private String contract;
	private int contractPrice;
	private int contractQuantity;
	private String contractStart;
	private String contractEnd;
	private String contractRegDate;

	
	public String getContractFianlCode() {
		return contractFianlCode;
	}
	public void setContractFianlCode(String contractFianlCode) {
		this.contractFianlCode = contractFianlCode;
	}
	public String getShoppingMallName() {
		return shoppingMallName;
	}
	public void setShoppingMallName(String shoppingMallName) {
		this.shoppingMallName = shoppingMallName;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public int getContractPrice() {
		return contractPrice;
	}
	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}
	public int getContractQuantity() {
		return contractQuantity;
	}
	public void setContractQuantity(int contractQuantity) {
		this.contractQuantity = contractQuantity;
	}
	public String getContractStart() {
		return contractStart;
	}
	public void setContractStart(String contractStart) {
		this.contractStart = contractStart;
	}
	public String getContractEnd() {
		return contractEnd;
	}
	public void setContractEnd(String contractEnd) {
		this.contractEnd = contractEnd;
	}
	public String getContractRegDate() {
		return contractRegDate;
	}
	public void setContractRegDate(String contractRegDate) {
		this.contractRegDate = contractRegDate;
	}
	@Override
	public String toString() {
		return "Sales [contractFianlCode=" + contractFianlCode + ", shoppingMallName=" + shoppingMallName
				+ ", contract=" + contract + ", contractPrice=" + contractPrice + ", contractQuantity="
				+ contractQuantity + ", contractStart=" + contractStart + ", contractEnd=" + contractEnd
				+ ", contractRegDate=" + contractRegDate + "]";
	}

}
