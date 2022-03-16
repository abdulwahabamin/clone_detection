        @Override
        public void run() {
            currentSongName.setText(fragmentCommunicator.getCurrentSongName());
            currentTime.setText(fragmentCommunicator.getCurrentSongTime());
            totalTime.setText(fragmentCommunicator.getSongLengthText());
            seekBar.setMax(fragmentCommunicator.getSongLength() / 1000);
            seekBar.setProgress(fragmentCommunicator.getCurrentSongPosition());
            handler.postDelayed(this, 1000);
        }

