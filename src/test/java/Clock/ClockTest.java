package Clock;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ClockTest {

    @Test
    public void test_getTime() {
        Clock clock = new Clock(3, 20, 15);
        assertThat(clock.getTime(), is("3:20:15"));
    }

    @Test
    public void test_few_seconds() {
        Clock c1 = new Clock(3, 20, 7);
        assertThat(c1.getTime(), is("3:20:07"));
    }

    @Test
    public void test_few_minutes() {
        Clock c1 = new Clock(6, 8, 20);
        assertThat(c1.getTime(), is("06:08:20"));
    }

    @Test
    public void test_few_hours() {
        Clock c1 = new Clock(6, 8, 20);
        assertThat(c1.getTime(), is("06:08:20"));
    }

    @Test
    public void test_few_zeros() {
        Clock c1 = new Clock(0, 0, 0);
        assertThat(c1.getTime(), is("00:00:00"));
    }

    @Test
    public void add_seconds() {
        Clock clock = new Clock(13, 20, 15);
        clock.addSeconds(12);
        assertThat(clock.getTime(), is("13:20:27"));
    }

    @Test
    public void add_seconds_to_next_minute() {
        Clock clock = new Clock(13, 20, 50);
        clock.addSeconds(20);
        assertThat(clock.getTime(), is("13:21:10"));
    }

    @Test
    public void add_seconds_until_adds_more_minutes() {
        Clock clock = new Clock(13, 20, 50);
        clock.addSeconds(200);
        assertThat(clock.getTime(), is("13:24:10"));
    }

    @Test
    public void add_seconds_until_adds_more_hours() {
        Clock clock = new Clock(1, 3, 5);
        clock.addSeconds((60 * 60 * 3) + (60 * 5) * 30);
        assertThat(clock.getTime(), is("06:33:05"));
    }

    @Test
    public void modify_two_clocks() {
        Clock c1 = new Clock(0, 0, 0);
        Clock c2 = new Clock(0, 0, 0);

        //c1.addSeconds(2);
        //c2.addSeconds(2);
        addSecs(c1,c2, 2);

        assertThat(c1.getTime(), is("00:00:02"));
        assertThat(c2.getTime(), is("00:00:05"));
    }

    void addSecs(Clock clock1, Clock clock2, int s) {
        clock1.addSeconds(s);
        clock2.addSeconds(s);

    }

}