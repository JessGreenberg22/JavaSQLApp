package utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Helper {private static final LocalTime START_BUSINESS_HOURS_EST = LocalTime.of(8,0);
    private static final LocalTime END_BUSINESS_HOURS_EST = LocalTime.of(22,0);

    private static ObservableList<LocalTime> startTimeList = FXCollections.observableArrayList();
    private static ObservableList<LocalTime> endTimeList = FXCollections.observableArrayList();

    private static void generateStartEndTimes(){
        ZonedDateTime estStartZDT = ZonedDateTime.of(LocalDate.now(),START_BUSINESS_HOURS_EST, ZoneId.of("America/New_York"));
        ZonedDateTime estEndZDT = ZonedDateTime.of(LocalDate.now(),END_BUSINESS_HOURS_EST, ZoneId.of("America/New_York"));
        LocalTime localStart = estStartZDT.withZoneSameInstant(ZoneId.systemDefault()).toLocalTime();
        //System.out.println("localStart = " + localStart);
        LocalTime localEnd = estEndZDT.withZoneSameInstant(ZoneId.systemDefault()).toLocalTime();

        if(startTimeList.size() == 0 || endTimeList.size() == 0){
            while (localStart.isBefore(localEnd)){
                startTimeList.add(localStart);
                localStart = localStart.plusMinutes(15);
                endTimeList.add(localStart);
            }
        }

    }

    public static ObservableList<LocalTime> getStartTimeList() {
        generateStartEndTimes();
        return startTimeList;
    }

    public static ObservableList<LocalTime> getEndTimeList() {
        generateStartEndTimes();
        return endTimeList;
    }
}
