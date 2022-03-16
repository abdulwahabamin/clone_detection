    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSeekbarUpdate();
        executorService.shutdown();
    }

