    private void setButtonsClickListener() {
        //play pause button
        playPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        playPauseBtn.setBackgroundResource(R.drawable.play);
                    } else {
                        mediaPlayer.start();
                        updateSeekBar();
                        playPauseBtn.setBackgroundResource(R.drawable.pause);
                    }
                }
            }
        });

        //seek bar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                    mediaPlayer.seekTo(progress);

                int currentPos = mediaPlayer.getCurrentPosition() / 1000;
                int duration = mediaPlayer.getDuration() / 1000;
                updateTextViews(currentPos,duration);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //forward button
        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPos = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                currentPos += 5000;
                if(currentPos > duration)
                    currentPos = duration;
                seekBar.setMax(duration);
                seekBar.setProgress(currentPos);
                mediaPlayer.seekTo(currentPos);
                updateTextViews(currentPos/1000 , duration /1000);

            }
        });

        //backward button
        backWardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPos = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                currentPos -= 5000;
                if(currentPos < 0)
                    currentPos = 0;
                seekBar.setMax(duration);
                seekBar.setProgress(currentPos);
                mediaPlayer.seekTo(currentPos);
                updateTextViews(currentPos/1000 , duration /1000);

            }
        });
    }

