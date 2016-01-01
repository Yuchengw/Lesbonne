package com.lesbonne.mysqldb;

import java.util.UUID;

/**
 * @author yucheng
 * @since 1
 * */
public class DBId {

	private String id;
	
	public String getId() {
		return this.id;
	}
	
	private void setId(String id) {
		this.id = id;
	}
	
	private DBId(DBIdBuilder dbIdBuilder) {
		StringBuilder sb = new StringBuilder();
		sb.append(dbIdBuilder.dataCenterId);
		sb.append(dbIdBuilder.clusterId);
		sb.append(dbIdBuilder.requestId);
		// UUID is temporary for now, will replace this with unique RequestId in the future.
		sb.append(UUID.randomUUID().toString().substring(0, 4));
		this.setId(sb.toString());
	}
	
	protected static class DBIdBuilder {
		/** 
		 * Required Parameters
		 */
		String dataCenterId; // 3 bytes
		String clusterId; // 3 bytes
		
		/** 
		 * Option Parameters
		 */
		String requestId; // 5 bytes
		
		DBIdBuilder(String dataCenterId, String clusterId) {
			this.dataCenterId = dataCenterId;
			this.clusterId = clusterId;
		}
		
		DBIdBuilder requestId(String requestId) {
			this.requestId = requestId;
			return this;
		}
		
		public DBId build() {
			return new DBId(this);
		}
	}
}
