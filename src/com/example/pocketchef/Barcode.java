package com.example.pocketchef;


import java.text.DecimalFormat;

/**
* Represents a Barcode.
*/
@SuppressWarnings({ "rawtypes" })
public class Barcode implements Comparable {
	private String code;
	private String name;

	/**
	* Constructs a new Barcode object.
	* @param s The value of the Barcode
	*/
	public Barcode(String s) {
		setCode(s);
	}

	/**
	* Gets the Barcode's code.
	* @return The Barcode's number.
	*/
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}

	/**
	* Sets the Barcode's code.
	* @param code The new value for the Barcode.
	*/
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode(){
		return (code == null) ? 0 : code.hashCode();
	}
	
	public boolean equals(Object o){
		if(o instanceof Barcode) return hashCode() == o.hashCode();
		else return false;
	}

	@Override
	public int compareTo(Object o) {
		return code.compareTo(((Barcode)o).getCode());
	}

	public String toString() {
		return code;
	}
}
