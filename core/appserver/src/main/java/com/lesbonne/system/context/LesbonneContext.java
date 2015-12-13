package com.lesbonne.system.context;

public class LesbonneContext implements ContextIntf{

	public static final UserContextImpl getUserContext() {
		return new UserContextImpl();
	}
}
