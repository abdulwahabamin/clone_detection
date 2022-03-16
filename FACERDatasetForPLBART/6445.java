    /**
     * Execute the given task. If given task is not {@link Preemptable}, it will
     * preempt all outstanding preemptable tasks.
     */
    public <P> void execute(AsyncTask<P, ?, ?> task, P... params) {
        if (task instanceof Preemptable) {
            synchronized (mPreemptable) {
                mPreemptable.add(new WeakReference<Preemptable>((Preemptable) task));
            }
            task.executeOnExecutor(mNonPreemptingExecutor, params);
        } else {
            task.executeOnExecutor(this, params);
        }
    }

