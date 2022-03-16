    private void updateDuration(MediaMetadataCompat metadata) {
        if (metadata == null) {
            return;
        }
        FireLog.d(TAG, "updateDuration called ");
        int duration = (int) metadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
        seekBar.setMax(duration);
        circularSeekBar.setMax(duration);
        endTv.setText(DateUtils.formatElapsedTime(duration / 1000));
    }

