package util;

public enum Region {
	NULL("��ѡ��Region", ""),CNSOUTH("����-����", "cn-south-1"), CNNORTH("����-����һ", "cn-north-1"), CNNE("����-����","cn-northeast-1"), CNEAST("����-�Ϻ���", "cn-east-2");
	
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
 ����-����     (cn-south-1)
����-����һ  ()
	    ()
  ()
 */
