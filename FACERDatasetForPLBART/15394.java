        /**
         * You CANNOT use this player anymore after calling release()
         */
        public void release() {
            stop();
            mCurrentMediaPlayer.release();
            VisualizerUtils.releaseVisualizer();
        }

