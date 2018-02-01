package edu.ccd;

public class EnumTypes {
    public EnumTypes() {
        System.out.println("\n-- Enum Types --");
        quickCalendar();
    }

    private enum Day {
        SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);

        private final int value;

        public int value() {
            return this.value;
        }

        private Day(int _value) {
            value=_value;
        }
    }

    private String engDaysOfTheWeek[] = {"Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private String deuDaysOfTheWeek[] = {"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};
    private String swaDaysOfTheWeek[] = {"Jumapili", "Jumatatu", "Jumanne", "Jumatano", "Alhamisi", "Ijumaa", "Jumamosi"};

    private void quickCalendar() {
        Day today = Day.WEDNESDAY;
        if(today == Day.FRIDAY)
            System.out.println("Friday, time to party!");
        else
            System.out.println("Keep trudging forward.");

        System.out.print(engDaysOfTheWeek[Day.SUNDAY.value()] + ", ");
        System.out.print(engDaysOfTheWeek[Day.MONDAY.value()] + ", ");
        System.out.print(engDaysOfTheWeek[Day.TUESDAY.value()] + ", ");
        System.out.print(engDaysOfTheWeek[Day.WEDNESDAY.value()] + ", ");
        System.out.print(engDaysOfTheWeek[Day.THURSDAY.value()] + ", ");
        System.out.print(engDaysOfTheWeek[Day.FRIDAY.value()] + ", ");
        System.out.println(engDaysOfTheWeek[Day.SATURDAY.value()]);

        System.out.print(deuDaysOfTheWeek[Day.SUNDAY.value()] + ", ");
        System.out.print(deuDaysOfTheWeek[Day.MONDAY.value()] + ", ");
        System.out.print(deuDaysOfTheWeek[Day.TUESDAY.value()] + ", ");
        System.out.print(deuDaysOfTheWeek[Day.WEDNESDAY.value()] + ", ");
        System.out.print(deuDaysOfTheWeek[Day.THURSDAY.value()] + ", ");
        System.out.print(deuDaysOfTheWeek[Day.FRIDAY.value()] + ", ");
        System.out.println(deuDaysOfTheWeek[Day.SATURDAY.value()]);

        System.out.print(swaDaysOfTheWeek[Day.SUNDAY.value()] + ", ");
        System.out.print(swaDaysOfTheWeek[Day.MONDAY.value()] + ", ");
        System.out.print(swaDaysOfTheWeek[Day.TUESDAY.value()] + ", ");
        System.out.print(swaDaysOfTheWeek[Day.WEDNESDAY.value()] + ", ");
        System.out.print(swaDaysOfTheWeek[Day.THURSDAY.value()] + ", ");
        System.out.print(swaDaysOfTheWeek[Day.FRIDAY.value()] + ", ");
        System.out.println(swaDaysOfTheWeek[Day.SATURDAY.value()]);
    }
}
