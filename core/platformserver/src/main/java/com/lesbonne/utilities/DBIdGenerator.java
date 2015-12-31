package com.lesbonne.utilities;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.*;
import org.hibernate.type.*;

import java.util.Properties;

/**
 * Generate DB entity id key with the prefix specified in the Entity java file.
 * The id will be length 3 prefix with 15 random string.
 * 
 * @author jassica
 * @version 1
 */
public class DBIdGenerator implements IdentifierGenerator, Configurable {

	public static final String PREFIX = "prefix";
	private String prefix;

	/**
	 * Grab the entity prefix from the entity java definition file
	 */
	@Override
	public void configure(Type type, Properties params, Dialect d) {
		prefix = params.getProperty("prefix");
	}

	/**
	 * The id is composed with length 3 prefix and 15 random string which is
	 * first 15 characters for the UUID UUID should be thread safe.
	 */
	@Override
	public Serializable generate(SessionImplementor si, Object o)
			throws HibernateException {
		return prefix + UUID.randomUUID().toString().substring(0, 15);

	}
}
