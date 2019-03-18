package com.movie.soap.webservice.provider;

/**
 * 
 * @author Nagendra
 *
 */
public class SoapServerException  extends Exception{
	
	private SoapError fault;
	
	public  SoapServerException(String message,SoapError fault){
		 super(message);
		 this.fault=fault;
	}
	
	public  SoapError getFault(){
			return fault;
	}
}
