        @Override
        public void run() {
            if (mPlayerService != null && mPlayerService.isPlaying()) {
                progressBar.setMax(mPlayerService.getDuration());
                progressBar.setProgress(mPlayerService.getCurrentPosition());
            }
            if (mUpdateProgress) {
                handler.postDelayed(mUpdateRunnable, 500);
            }
        }

