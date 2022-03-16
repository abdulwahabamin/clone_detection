    @Override
    public void updateDuration(long dur) {
        Log.d(TAG, "updateDuration:called");
        int duration = (int) dur;
        songCurrentPositionSeekBar.setMax(duration);
        totalTimeTv.setText(DateUtils.formatElapsedTime(duration/1000));

        Log.i(TAG, "updateDuration:total="+DateUtils.formatElapsedTime(duration/1000));
    }

