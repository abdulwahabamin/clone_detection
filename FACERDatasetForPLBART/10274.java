        /**
         * Method that performs a fade animation.
         *
         * @param out Fade out (true); Fade in (false)
         */
        void fadeEfect(final boolean out) {
            Activity activity = (Activity)getContext();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Animation fadeAnim = out ?
                            new AlphaAnimation(1, 0) :
                                new AlphaAnimation(0, 1);
                            fadeAnim.setDuration(50L);
                            fadeAnim.setFillAfter(true);
                            fadeAnim.setInterpolator(new AccelerateInterpolator());
                            NavigationView.this.startAnimation(fadeAnim);
                }
            });
        }

