package com.lesbonne.search;

import java.net.InetSocketAddress;

import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;

import com.google.common.net.HostAndPort;

public class ElasticSearchUtils {
	private static final int DEFAULT_PORT = 9301;

    /**
     * Convert a {@link HostAndPort} instance to {@link TransportAddress}. If the {@link HostAndPort} instance doesn't
     * contain a port the resulting {@link TransportAddress} will have {@link #DEFAULT_PORT} as port.
     *
     * @param hostAndPort a valid {@link HostAndPort} instance
     * @return a {@link TransportAddress} equivalent to the provided {@link HostAndPort} instance
     */
    public static TransportAddress fromHostAndPort(final HostAndPort hostAndPort) {
        InetSocketAddress address = new InetSocketAddress(hostAndPort.getHostText(), hostAndPort.getPortOrDefault(DEFAULT_PORT));
        return new InetSocketTransportAddress(address);
    }
}
