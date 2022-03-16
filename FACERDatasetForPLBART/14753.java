        @Override
        public void run() {
            if(mediaPlayer != null){
                currentTime.setText(milliSecondsToTime(mediaPlayer.getCurrentPosition()));
                seekBar.setProgress(mediaPlayer.getCurrentPosition()/1000);
            }

            handler.postDelayed(this, 1000);
        }

