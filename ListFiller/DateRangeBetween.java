import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class DateRangeBetween {

	private List<String> newDates;

	DateRangeBetween(int year, int month, int day, int monthsAfter, int interval){


		this.rangeDate(year, month, day, monthsAfter, interval);

	}

	public void rangeDate(int year, int month, int day, int monthsAfter, int interval){


		LocalDate startDate = LocalDate.of(year, month, day);
		LocalDate endDate = startDate.plusMonths(monthsAfter);
		List<LocalDate> listOfDates = startDate.datesUntil(endDate)
		                            .collect(Collectors.toList());

		this.newDates = new ArrayList<>();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-YYYY");
		for(int x = 0; x < listOfDates.size(); x+=interval){

				String date = formatter.format(listOfDates.get(x));
				this.newDates.add(date);
		}


	}


	public List<String> getDates(){
		return this.newDates;
	}




}