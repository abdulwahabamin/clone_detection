    @MediumTest
    public void testWorkerFragment_setRetainInstance() {
        mainActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                instrumentation.callActivityOnStart(mainActivity);
            }

        });

        WorkerFragmentToRetrieveJsonString workerFragment = (WorkerFragmentToRetrieveJsonString) mainActivity
                .getSupportFragmentManager().findFragmentByTag(
                        MainActivity.WORKER_FRAGMENT_TAG);
        assertTrue("Worker fragment has not called setRetainInstance(true)",
                workerFragment.getRetainInstance());
    }

