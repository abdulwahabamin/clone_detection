        @Override
        public void run() {
            long position = MusicPlayer.position();
            if (mCircularProgress != null) {
                mCircularProgress.setProgress((int) position);
                if (elapsedtime != null && getActivity() != null)
                    elapsedtime.setText(TimberUtils.makeShortTimeString(getActivity(), position / 1000));

            }
            overflowcounter--;
            if (MusicPlayer.isPlaying()) {
                int delay = (int) (1500 - (position % 1000));
                if (overflowcounter < 0 && !fragmentPaused) {
                    overflowcounter++;
                    mCircularProgress.postDelayed(mUpdateCircularProgress, delay);
                }
            }

        }

