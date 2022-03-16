    @Override
    public void onStop() {
        paused = true;
        handler.removeMessages(REFRESH);

        super.onStop();
    }    

