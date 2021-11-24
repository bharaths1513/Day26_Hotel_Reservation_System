package Day26_Workshop_Hotel_Reservation_System;

public class Hotel {

	// hotel parameters
	private String hotelName;
	private int hotelPriceWeekDays;
	private int hotelPriceWeekEnds;
	private int hotelRating;
	private int hotelRewardWeekDays;
	private int hotelRewardWeekEnds;

	@Override
	public String toString() {
		return "\n" + "Hotel{" + "hotelName='" + hotelName + '\'' + ", hotelPriceWeekDays=" + hotelPriceWeekDays
				+ ", hotelPriceWeekEnds=" + hotelPriceWeekEnds + ", hotelRating=" + hotelRating
				+ ", hotelRewardWeekDays=" + hotelRewardWeekDays + ", hotelRewardWeekEnds=" + hotelRewardWeekEnds + '}';
	}

	public String getHotelName() {
		return hotelName;
	}

	public Hotel() {
	};

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getHotelPriceWeekDays() {
		return hotelPriceWeekDays;
	}

	public void setHotelPriceWeekDays(int hotelPriceWeekDays) {
		this.hotelPriceWeekDays = hotelPriceWeekDays;
	}

	public int getHotelPriceWeekEnds() {
		return hotelPriceWeekEnds;
	}

	public void setHotelPriceWeekEnds(int hotelPriceWeekEnds) {
		this.hotelPriceWeekEnds = hotelPriceWeekEnds;
	}

	public Hotel(String hotelName, int hotelPriceWeekDays, int hotelPriceWeekEnds, int hotelRating,
			int hotelRewardWeekDays, int hotelRewardWeekEnds) {
		this.hotelName = hotelName;
		this.hotelPriceWeekDays = hotelPriceWeekDays;
		this.hotelPriceWeekEnds = hotelPriceWeekEnds;
		this.hotelRating = hotelRating;
		this.hotelRewardWeekDays = hotelRewardWeekDays;
		this.hotelRewardWeekEnds = hotelRewardWeekEnds;
	}

	public int getHotelRewardWeekDays() {
		return hotelRewardWeekDays;
	}

	public void setHotelRewardWeekDays(int hotelRewardWeekDays) {
		this.hotelRewardWeekDays = hotelRewardWeekDays;
	}

	public int getHotelRewardWeekEnds() {
		return hotelRewardWeekEnds;
	}

	public void setHotelRewardWeekEnds(int hotelRewardWeekEnds) {
		this.hotelRewardWeekEnds = hotelRewardWeekEnds;
	}

	public int getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(int hotelRating) {
		this.hotelRating = hotelRating;
	}
}
