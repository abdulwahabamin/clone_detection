        /**
         * An end event is received - see if this is an event we are listening for
         */
        public void onAnimationEnd(Animator animation) {
            if (mRule == Dependency.AFTER) {
                startIfReady(animation);
            }
        }

