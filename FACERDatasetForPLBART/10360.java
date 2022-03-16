        /**
         * Constructor of <code>ExpandCollapseAnimation</code>
         *
         * @param view The view to animate
         * @param viewHeight The maximum height of view. Used to compute the animation translation
         * @param duration The duration of the animation
         * @param effect The effect of the animation
         */
        public ExpandCollapseAnimation(
                View view, int viewHeight, int duration, ANIMATION_TYPE effect) {
            super();
            this.mView = view;
            this.mViewHeight = viewHeight;
            this.mEffect = effect;
            this.mViewLayoutParams = (LayoutParams) view.getLayoutParams();
            setDuration(duration);
        }

