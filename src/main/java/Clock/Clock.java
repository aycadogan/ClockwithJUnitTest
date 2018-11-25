package Clock;

public class Clock {

    private int seconds;
    private int minutes;
    private int hours;

    public Clock(int h, int m, int s){
        this.seconds = s;
        this.minutes = m;
        this.hours = h;
    }

    public String getTime() {

        //write in one line
        // return prefixZero(this.hours) + ":" + prefixZero(this.minutes) + ":" +  prefixZero(this.seconds);

        String result = "";
        result += prefixZero(this.hours);
        result += ":";
        result += prefixZero(this.minutes);
        result += ":";
        result += prefixZero(this.seconds);
        return result;
    }

    public void addSeconds(int s) {

        this.seconds += s;

        this.minutes += this.seconds / 60;
        this.seconds %= 60;

        this.hours += this.minutes / 60;
        this.minutes %= 60;

    }

    public static String prefixZero(int number){

        //this kullanılmadı static method ekleyebilirsin.
        boolean isSmall = number < 10;

        String s = (isSmall ? "0" : "");
        return s + number;

        // or we can just write like:
        // return ( number < 10 ? "0" : "") + number;

        /**    String result="";
         if (number < 10){
         result += "0";
         } return result; */
    }


}
