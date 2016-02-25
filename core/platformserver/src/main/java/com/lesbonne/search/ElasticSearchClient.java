package com.lesbonne.search;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.TransportAddress;

import com.google.common.net.HostAndPort;

public enum ElasticSearchClient {
	INSTANCE;

	// instance vars, constructor
	private final Client client;

	ElasticSearchClient() {		
		final TransportAddress address = ElasticSearchUtils.fromHostAndPort(HostAndPort.fromHost("localhost"));
		this.client = TransportClient.builder().build().addTransportAddresses(address);
	}

	// Static getter
	public static ElasticSearchClient getInstance() {
		return INSTANCE;
	}

	public Client getConnection() {
		return client;
	}
}
