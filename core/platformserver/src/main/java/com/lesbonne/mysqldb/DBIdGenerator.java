package com.lesbonne.mysqldb;

import java.io.Serializable;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class DBIdGenerator implements IdentifierGenerator, Configurable {

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
		StringBuilder sb = new StringBuilder();
		sb.append(prefix);
		sb.append(new DBId.DBIdBuilder(DBInfoService.getDataCenterId(),
									DBInfoService.getClusterId()).
									requestId("00000").build().getId());
		return sb.toString();
	}
}
