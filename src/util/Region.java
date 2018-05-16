package util;

public enum Region {
	NULL("请选择Region", ""),CNSOUTH("华南-广州", "cn-south-1"), CNNORTH("华北-北京一", "cn-north-1"), CNNE("东北-大连","cn-northeast-1"), CNEAST("华东-上海二", "cn-east-2");
	
	private String region;
	private String endpoint;
	
	private Region(String region, String endpoint) {
		this.region = region;
		this.endpoint = endpoint;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
	
	@Override
	public String toString() {
		return this.region+"   "+this.endpoint;
	}
}
/*
 华南-广州     (cn-south-1)
华北-北京一  ()
	    ()
  ()
 */
