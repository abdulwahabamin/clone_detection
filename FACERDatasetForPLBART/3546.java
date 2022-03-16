        /**
         * A start event is received - see if this is an event we are listening for
         */
        public void onAnimationStart(Animator animation) {
            if (mRule == Dependency.WITH) {
                startIfReady(animation);
            }
        }

