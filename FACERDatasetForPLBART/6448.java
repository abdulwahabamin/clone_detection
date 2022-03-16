    @Override
    public void run() {
        while (true) {
            try {
                final Runnable command = mQueue.take();
                command.run();
            } catch (InterruptedException e) {
                // That was weird; let's go look for more tasks.
            }
        }
    }

