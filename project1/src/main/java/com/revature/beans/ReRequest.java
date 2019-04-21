package com.revature.beans;

import java.sql.Blob;

public class ReRequest {
	
	private int reId;
	private int typeId;
	private int status;
	private String text;
	private String reImage;
	private int useId;
	
	public ReRequest() {

	}
	
	public ReRequest(int reId, int typeId, int status, String text, String reImage, int useId) {
		super();
		this.reId = reId;
		this.typeId = typeId;
		this.status = status;
		this.text = text;
		this.reImage = reImage;
		this.useId = useId;
	}

	public int getReId() {
		return reId;
	}
	public void setReId(int reId) {
		this.reId = reId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getReImage() {
		return reImage;
	}
	public void setReImage(String reImage) {
		this.reImage = reImage;
	}
	public int getUseId() {
		return useId;
	}
	public void setUseId(int useId) {
		this.useId = useId;
	}

	@Override
	public String toString() {
		return "ReRequest [reId=" + reId + ", typeId=" + typeId + ", status=" + status + ", text=" + text + ", reImage="
				+ reImage + ", useId=" + useId + "]";
	}
	
	
	
}
