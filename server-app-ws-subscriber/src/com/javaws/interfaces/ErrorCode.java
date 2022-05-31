package com.javaws.interfaces;

public interface ErrorCode {
	public static final int SUCCESS = 0;
	public static final int ERROR_WHILE_ACCESSING_DB = 1;
	public static final int SUBSCRIBER_NOT_FOUND = 2;
	public static final int SUBSCRIBER_ALREADY_ACTIVATED = 3;
	public static final int SUBSCRIBER_ALREADY_DEACTIVATED = 4;
	public static final int SUBSCRIBER_ALREADY_EXIST = 5;
}
