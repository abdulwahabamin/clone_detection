    @Override
    protected void onRestart() {
        super.onRestart();
        FragmentManager fragmentManager = getSupportFragmentManager();
        WorkerFragmentToRetrieveJsonString workerFragment =
                (WorkerFragmentToRetrieveJsonString) fragmentManager.findFragmentByTag(
                        MainActivity.WORKER_FRAGMENT_TAG);
        if (workerFragment == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            workerFragment = new WorkerFragmentToRetrieveJsonString();
            fragmentTransaction.add(workerFragment, MainActivity.WORKER_FRAGMENT_TAG);
            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();
        }

        workerFragment.retrieveLastRequestedWeatherInfo();
    }

