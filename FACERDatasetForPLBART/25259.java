    @Override
    public void onPause() {
        super.onPause();
        stopTimer();
        handler.removeCallbacksAndMessages(null);
        removePlayerListeners();
    }

