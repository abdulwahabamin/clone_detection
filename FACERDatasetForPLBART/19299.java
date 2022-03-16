        @Override
        public void run() {
            FadeAnimation fadeOut = new FadeAnimation(mSeekbarIndicatorLayoutParent,
                                                      300, 0.9f, 0.0f, null);
            fadeOut.animate();
        }

