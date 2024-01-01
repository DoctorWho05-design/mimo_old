package mimo.Controller.Routine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import mimo.Mimo;

public abstract class Routine {
    protected ScheduledExecutorService mScheduler;
    private int mInitialDelay;
    private TimeUnit mTimeUnit;
    private int mPeriod;


    public Routine(int mInitialDelay, TimeUnit mTimeUnit, int mPeriod) {
        this.mInitialDelay = mInitialDelay;
        this.mTimeUnit = mTimeUnit;
        this.mPeriod = mPeriod;
        startRuotine();
    }

    private void startRuotine() {
        Thread schedulerThread = new Thread(() -> {
            mScheduler = Executors.newScheduledThreadPool(1);
            mScheduler.scheduleAtFixedRate(() -> {
                handleRuotine();
            }, mInitialDelay, mPeriod, mTimeUnit);
        });
        schedulerThread.start();
        Mimo.DEBUGER.startMethod("thread.start()");

    } 
    
    public abstract void handleRuotine();
}
