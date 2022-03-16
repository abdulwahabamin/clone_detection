    private void preempt() {
        synchronized (mPreemptable) {
            int count = 0;
            for (WeakReference<Preemptable> ref : mPreemptable) {
                final Preemptable p = ref.get();
                if (p != null) {
                    count++;
                    p.preempt();
                }
            }
            mPreemptable.clear();
        }
    }

