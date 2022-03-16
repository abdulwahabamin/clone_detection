        public void run() {
            try {
                long totalDuration = mp.getDuration();
                long currentDuration = mp.getCurrentPosition();

                songTotalDurationLabel.setText("" + utils.milliSecondsToTimer(totalDuration));
                songCurrentDurationLabel.setText("" + utils.milliSecondsToTimer(currentDuration));

                int progress = utils.getProgressPercentage(currentDuration, totalDuration);
                songProgressBar.setProgress(progress);

                mHandler.postDelayed(this, 100);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

