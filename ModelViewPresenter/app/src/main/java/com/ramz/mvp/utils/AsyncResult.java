package com.ramz.mvp.utils;

/**
 * Created by munnaz on 20/12/16.
 * Util Class for Mvp example of file operation
 * AsyncResult for async operation
 */
public class AsyncResult<T>
{
	T result;
	Exception exception=null;
	
	public AsyncResult(T result)
	{
		this.result = result;
	}

	public AsyncResult(Exception exception)
	{
		super();
		this.exception = exception;
	}

	/**
	 * Returns result fetched asynchronously, throws exception if exception present.
	 * @return
	 * @throws Exception
	 */
	public T getResult() throws Exception
	{
		if (exception != null)
			throw exception;
		return result;
	}
	
	public Exception getException()
	{
		return exception;
	}
}
