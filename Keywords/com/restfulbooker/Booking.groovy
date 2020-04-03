package com.restfulbooker

public class Booking {
	private String firstname
	private String lastname
	private int totalprice
	private BookingDates bookingdates
	private boolean depositpaid
	private String additionalneeds

	public Booking() {}
	
	public Booking(String firstname, String lastname, int totalprice, BookingDates bookingdates, boolean depositpaid,
			String additionalneeds) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.bookingdates = bookingdates;
		this.depositpaid = depositpaid;
		this.additionalneeds = additionalneeds;
	}

	@Override
	public String toString() {
		return "Booking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
		+ ", bookingdates=" + bookingdates + ", depositpaid=" + depositpaid + ", additionalneeds="
		+ additionalneeds + "]";
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public BookingDates getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(BookingDates bookingdates) {
		this.bookingdates = bookingdates;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public String getadditionalneeds() {
		return additionalneeds;
	}

	public void setadditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
}
