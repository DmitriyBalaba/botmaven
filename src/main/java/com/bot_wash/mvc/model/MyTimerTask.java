package com.bot_wash.mvc.model;

import java.util.Timer;
import java.util.TimerTask;


public class MyTimerTask extends TimerTask
{
    private Long minutes = 5l;
    private Timer timer;
    private TimeOutWash timeOutWash;

    public MyTimerTask(Timer timer, Long minutes, TimeOutWash timeOutWash) {
        this.timer = timer;
        this.minutes = minutes;
        this.timeOutWash = timeOutWash;
        timer.schedule(this,1000,60000);
    }

    @Override
    public void run() {
        if (minutes == 0){
            System.out.println("end");
            timeOutWash.setFree(true);
            timer.cancel();
        }else if (minutes == 1)
        {

            System.out.println(minutes + " == " + (timeOutWash.getDateNow().getTime()));
            System.out.println(" Minutes left" + minutes);
        }
        minutes--;
    }

    public Long getMinutes() {
        return minutes;
    }
}