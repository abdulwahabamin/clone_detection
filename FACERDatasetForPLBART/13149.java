        /**
         * {@inheritDoc}
         */
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            if (interpolatedTime < 1.0f) {
                int height = (int)(this.mViewHeight * interpolatedTime);
                if (this.mEffect.compareTo(ANIMATION_TYPE.EXPAND) == 0) {
                    this.mViewLayoutParams.height = height;
                } else {
                    this.mViewLayoutParams.height = this.mViewHeight - height;
                }
                this.mView.setLayoutParams(this.mViewLayoutParams);
                this.mView.requestLayout();
            }
        }

