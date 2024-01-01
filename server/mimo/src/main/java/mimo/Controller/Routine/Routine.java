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
    private String mRoutineName;
    private Thread mSchedulerThread;


    public Routine(String mRoutineName, int mInitialDelay, TimeUnit mTimeUnit, int mPeriod) {
        this.mRoutineName = mRoutineName;
        this.mInitialDelay = mInitialDelay;
        this.mTimeUnit = mTimeUnit;
        this.mPeriod = mPeriod;
        initRoutine();
    }

    private void initRoutine() {
        mSchedulerThread = new Thread(() -> {
            mScheduler = Executors.newScheduledThreadPool(1);
            mScheduler.scheduleAtFixedRate(() -> {
                handleRuotine();
            }, mInitialDelay, mPeriod, mTimeUnit);
        });
    } 

    public void startRoutine() {
        mSchedulerThread.start();
        Mimo.DEBUGER.startMethod("thread.start()");
    }

    public void stopRoutine() {
        mSchedulerThread.stop();
    }
    
    public String getRoutineName() {
        return mRoutineName;
    }

    public abstract void handleRuotine();
}
