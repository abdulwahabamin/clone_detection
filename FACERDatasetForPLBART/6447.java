    @Override
    public void execute(Runnable command) {
        preempt();
        Preconditions.checkNotNull(command);
        mQueue.add(command);
    }

