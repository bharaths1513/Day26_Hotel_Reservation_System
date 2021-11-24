package Day26_Workshop_Hotel_Reservation_System;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class HotelReservation extends Hotel {
	public ArrayList<Hotel> hotelDetails = new ArrayList<Hotel>();

	// Adding Hotels
	public void addHotel(String hotelName, int hotelPriceWeekDays, int hotelPriceWeekEnds, int hotelRating,
			int hotelRewardWeekDays, int hotelRewardWeekEnds) {
		Hotel adder = new Hotel(hotelName, hotelPriceWeekDays, hotelPriceWeekEnds, hotelRating, hotelRewardWeekDays,
				hotelRewardWeekEnds);
		hotelDetails.add(adder);
	}

	public void getHotelDetails() {
		System.out.println(hotelDetails);
	}

	// finding weekEnds count
	public int getWeekDaysCount(LocalDate dateStart, int noOfDays) {
		int weekEnds = 0;
		int temp = noOfDays;
		while (noOfDays > 0) {
			String d = dateStart.getDayOfWeek().toString();
			if ((d.equals("SUNDAY")) || (d.equals("SATURDAY"))) {
				weekEnds++;
			}
			dateStart = dateStart.plusDays(1);
			noOfDays--;
		}
		System.out.println("WeekEnd days count is :" + weekEnds);
		System.out.println("WeekDay days count is :" + (temp - weekEnds));
		return weekEnds;
	}

	// finding best rate and cheap hotel as per requirement with have two rates in reward and normal rates
	public void getMinPriceBestRatedHotel(int weekEndsCount, int weekDaysCount, int opt) {
		Hotel minWeekDays = hotelDetails.stream().min(Comparator.comparing(Hotel::getHotelPriceWeekDays)).orElseThrow();
		Hotel minWeekEnd = hotelDetails.stream().min(Comparator.comparing(Hotel::getHotelPriceWeekEnds)).orElseThrow();

		Hotel minWeekDaysReward = hotelDetails.stream().min(Comparator.comparing(Hotel::getHotelRewardWeekDays))
				.orElseThrow();
		Hotel minWeekEndReward = hotelDetails.stream().min(Comparator.comparing(Hotel::getHotelRewardWeekEnds))
				.orElseThrow();

		long totalRate1 = 0;
		long totalRate2 = 0;

		long totalRate3 = 0;
		long totalRate4 = 0;

		totalRate1 = (weekEndsCount) * (minWeekDays.getHotelPriceWeekEnds())
				+ (weekDaysCount) * (minWeekDays.getHotelPriceWeekDays());
		totalRate2 = (weekEndsCount) * (minWeekEnd.getHotelPriceWeekEnds())
				+ (weekDaysCount) * (minWeekEnd.getHotelPriceWeekDays());

		totalRate3 = (weekEndsCount) * (minWeekDaysReward.getHotelRewardWeekEnds())
				+ (weekDaysCount) * (minWeekDays.getHotelRewardWeekDays());
		totalRate4 = (weekEndsCount) * (minWeekEndReward.getHotelRewardWeekEnds())
				+ (weekDaysCount) * (minWeekEnd.getHotelRewardWeekDays());

		switch (opt) {
		case 1:
			if (totalRate1 < totalRate2 && totalRate1 < totalRate3 && totalRate1 < totalRate4) {
				System.out.println("Best rate Hotel is : " + minWeekDays.getHotelName());
				System.out.println(minWeekDays);
				System.out.println(minWeekDays.getHotelName() + " Total Rate is : " + totalRate1);
				break;
			} else if (totalRate2 < totalRate3 && totalRate2 < totalRate4 && totalRate2 < totalRate1) {
				System.out.println("Best rate Hotel is : " + minWeekEnd.getHotelName());
				System.out.println(minWeekEnd);
				System.out.println(minWeekEnd.getHotelName() + " Total Rate is : " + totalRate2);
				break;
			} else if (totalRate3 < totalRate1 && totalRate3 < totalRate2 && totalRate3 < totalRate4) {
				System.out.println("Best rate Hotel is : " + minWeekDaysReward.getHotelName());
				System.out.println(minWeekDaysReward);
				System.out.println(minWeekDaysReward.getHotelName() + " Total Rate is : " + totalRate3);
				break;
			} else if (totalRate4 < totalRate1 && totalRate4 < totalRate2 && totalRate4 < totalRate3) {
				System.out.println("Best rate Hotel is : " + minWeekEndReward.getHotelName());
				System.out.println(minWeekEndReward);
				System.out.println(minWeekEndReward.getHotelName() + " Total Rate is : " + totalRate4);
				break;
			}
		case 2:
			if (totalRate1 < totalRate2 && totalRate1 < totalRate3 && totalRate1 < totalRate4
					&& minWeekDays.getHotelRating() > minWeekDaysReward.getHotelRating()) {
				System.out.println("Best rate Hotel is : " + minWeekDays.getHotelName());
				System.out.println(minWeekDays);
				System.out.println(minWeekDays.getHotelName() + " Total Rate is : " + totalRate1);
				break;
			} else if (totalRate2 < totalRate3 && totalRate2 < totalRate4 && totalRate2 < totalRate1
					&& minWeekEnd.getHotelRating() > minWeekEndReward.getHotelRating()) {
				System.out.println("Best rate Hotel is : " + minWeekEnd.getHotelName());
				System.out.println(minWeekEnd);
				System.out.println(minWeekEnd.getHotelName() + " Total Rate is : " + totalRate2);
				break;
			} else if (totalRate3 < totalRate1 && totalRate3 < totalRate2 && totalRate3 < totalRate4
					&& minWeekDaysReward.getHotelRating() > minWeekDays.getHotelRating()) {
				System.out.println("Best rate Hotel is : " + minWeekDaysReward.getHotelName());
				System.out.println(minWeekDaysReward);
				System.out.println(minWeekDaysReward.getHotelName() + " Total Rate is : " + totalRate3);
				break;
			} else if (totalRate4 < totalRate1 && totalRate4 < totalRate2 && totalRate4 < totalRate3
					&& minWeekEndReward.getHotelRating() > minWeekEnd.getHotelRating()) {
				System.out.println("Best rate Hotel is : " + minWeekEndReward.getHotelName());
				System.out.println(minWeekEndReward);
				System.out.println(minWeekEndReward.getHotelName() + " Total Rate is : " + totalRate4);
				break;
			}
		case 3:
			Hotel maxRated = hotelDetails.stream().max(Comparator.comparing(Hotel::getHotelRating)).orElseThrow();
			int totalRatehotel = (weekEndsCount) * (maxRated.getHotelPriceWeekEnds())
					+ (weekDaysCount) * (maxRated.getHotelPriceWeekDays());
			System.out.println("Best Rate Hotel is : " + maxRated.getHotelName());
			System.out.println(maxRated);
			System.out.println(maxRated.getHotelName() + " Total Rate is : " + totalRatehotel);
			break;
		}

	}

	// finding best rate and cheap hotel as per requirement
	public void getMinPriceHotel(int weekEndsCount, int weekDaysCount, int opt) {
		Hotel minWeekDays = hotelDetails.stream().min(Comparator.comparing(Hotel::getHotelPriceWeekDays)).orElseThrow();
		Hotel minWeekEnd = hotelDetails.stream().min(Comparator.comparing(Hotel::getHotelPriceWeekEnds)).orElseThrow();
		long totalRate1 = 0;
		long totalRate2 = 0;
		totalRate1 = (weekEndsCount) * (minWeekDays.getHotelPriceWeekEnds())
				+ (weekDaysCount) * (minWeekDays.getHotelPriceWeekDays());
		totalRate2 = (weekEndsCount) * (minWeekEnd.getHotelPriceWeekEnds())
				+ (weekDaysCount) * (minWeekEnd.getHotelPriceWeekDays());

		switch (opt) {
		case 1:
			if (totalRate1 < totalRate2) {
				System.out.println("Best rate Hotel is : " + minWeekDays.getHotelName());
				System.out.println(minWeekDays);
				System.out.println(minWeekDays.getHotelName() + " Total Rate is : " + totalRate1);
			} else {
				System.out.println("Best Price rate Hotel is : " + minWeekEnd.getHotelName());
				System.out.println(minWeekEnd);
				System.out.println(minWeekEnd.getHotelName() + " Total Rate is : " + totalRate2);
			}
			break;
		case 2:
			if (totalRate1 < totalRate2 && minWeekDays.getHotelRating() > minWeekEnd.getHotelRating()) {
				System.out.println("Best rate Hotel is : " + minWeekDays.getHotelName());
				System.out.println(minWeekDays);
				System.out.println(minWeekDays.getHotelName() + " Total Rate is : " + totalRate1);
			} else {
				System.out.println("Best Price rate Hotel is : " + minWeekEnd.getHotelName());
				System.out.println(minWeekEnd);
				System.out.println(minWeekEnd.getHotelName() + " Total Rate is : " + totalRate2);
			}
			break;
		case 3:
			Hotel maxRated = hotelDetails.stream().max(Comparator.comparing(Hotel::getHotelRating)).orElseThrow();
			int totalRatehotel = (weekEndsCount) * (maxRated.getHotelPriceWeekEnds())
					+ (weekDaysCount) * (maxRated.getHotelPriceWeekDays());
			System.out.println("Best Rate Hotel is : " + maxRated.getHotelName());
			System.out.println(maxRated);
			System.out.println(maxRated.getHotelName() + " Total Rate is : " + totalRatehotel);
			break;

		}

	}
}
