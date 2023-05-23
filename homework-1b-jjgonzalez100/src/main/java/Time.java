import java.sql.SQLOutput;
import java.time.LocalTime;

public final class Time {

    private int hour;
    private int min;
    private int sec;
    public char meridiem;

    public Time() {
        this.hour = 12;
        this.min = 0;
        this.sec = 0;
        this.meridiem = 'A';
    }

    public Time(int hour, int min, int sec, char meridiem) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        this.meridiem = meridiem;
    }

    public Time(Time original) {
        this.hour = original.hour;
        this.min = original.min;
        this.sec = original.sec;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMin() {
        return this.min;
    }

    public int getSec() {
        return this.sec;
    }

    public char getMeridiem() {
        return this.meridiem;
    }

    public int getTotalMinutes() {
        int givenMins = (this.hour * 60) + this.min;
        int totalMins = 0;

        if(this.meridiem == 'A' && this.hour != 12) {
            totalMins = givenMins;
        }
        else if(this.meridiem == 'P' && this.hour != 12) {
            totalMins = 720 + givenMins;
        }
        else if(this.meridiem == 'A' && this.hour == 12) {
            totalMins = this.min;
        }
        else if(this.meridiem == 'P' && this.hour == 12) {
            totalMins = givenMins;
        }

        return totalMins;
    }

    public int getTotalSeconds() {
        int givenSecs = ((this.hour * 60) + this.min) * 60 + this.sec;
        int totalSecs = 0;

        if(this.meridiem == 'A' && this.hour != 12) {
            totalSecs = givenSecs;
        }
        else if(this.meridiem == 'P' && this.hour != 12) {
            totalSecs = 43200 + givenSecs;
        }
        else if(this.meridiem == 'A' && this.hour == 12) {
            totalSecs = (this.min * 60) + this.sec;
        }
        else if(this.meridiem == 'P' && this.hour == 12) {
            totalSecs = givenSecs;
        }

        return totalSecs;
    }

    public static Time localTimeToTimeObject(LocalTime time) {
        int hour = time.getHour();

        if(hour > 12) {
            hour = hour - 12;
        }

        int min = time.getMinute();
        int sec = time.getSecond();
        char day;

        if(time.getHour() >= 0 && time.getHour() < 12) {
            day = 'A';
        }
        else {
            day = 'P';
        }

        Time newTime = new Time(hour, min, sec, day);

        return newTime;
    }

    public static Time[] getMultipleTimes(LocalTime[] timeGroup) {
        Time[] newTimeArray = new Time[timeGroup.length];

        for(int i = 0; i < newTimeArray.length; i++) {
            newTimeArray[i] = localTimeToTimeObject(timeGroup[i]);
            if(newTimeArray[i].hour == 12) {
                newTimeArray[i].meridiem = 'A';
            }
            System.out.println(newTimeArray[i]);
            System.out.println(timeGroup[i]);
        }

        return newTimeArray;

    }
}
