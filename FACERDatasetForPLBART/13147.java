    /**
     * Method that sets the {@link FileSystemObject} selection list
     *
     * @param newSelection The new selection list
     */
    public void setSelection(List<FileSystemObject> newSelection) {
        // Compute the selection
        if (newSelection != null && newSelection.size() > 0) {
            this.mStatus.setText(computeSelection(newSelection));
        }

        // Requires show the animation (expand or collapse)?
        // Is the current state need to be changed?
        if ((newSelection == null || newSelection.size() == 0) &&
                this.getVisibility() == View.GONE) {
            return;
        }
        if ((newSelection != null && newSelection.size() > 0) &&
                this.getVisibility() == View.VISIBLE) {
            return;
        }

        // Need some animation
        final ExpandCollapseAnimation.ANIMATION_TYPE effect =
                (newSelection != null && newSelection.size() > 0) ?
                        ExpandCollapseAnimation.ANIMATION_TYPE.EXPAND :
                        ExpandCollapseAnimation.ANIMATION_TYPE.COLLAPSE;
        ExpandCollapseAnimation animation =
                                    new ExpandCollapseAnimation(
                                            this,
                                            this.mViewHeight,
                                            this.mEffectDuration,
                                            effect);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation anim) {
                LayoutParams params = (LayoutParams)getLayoutParams();
                if (effect.compareTo(ExpandCollapseAnimation.ANIMATION_TYPE.EXPAND) == 0) {
                    params.height = 0;
                } else if (effect.compareTo(ExpandCollapseAnimation.ANIMATION_TYPE.COLLAPSE) == 0) {
                    params.height = SelectionView.this.mViewHeight;
                }
                SelectionView.this.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation anim) {/**NON BLOCK**/}

            @Override
            public void onAnimationEnd(Animation anim) {
                LayoutParams params = (LayoutParams)getLayoutParams();
                if (effect.compareTo(ExpandCollapseAnimation.ANIMATION_TYPE.COLLAPSE) == 0) {
                    params.height = 0;
                    requestLayout();
                    SelectionView.this.setVisibility(View.GONE);
                } else {
                    params.height = SelectionView.this.mViewHeight;
                    requestLayout();
                    SelectionView.this.setVisibility(View.VISIBLE);
                }
            }
        });
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        startAnimation(animation);
    }

