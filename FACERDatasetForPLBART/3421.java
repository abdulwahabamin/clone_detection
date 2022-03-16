    private void toggle(final boolean visible, final boolean animate, boolean force) {
        if (mVisible != visible || force) {

            mVisible = visible;
            int height = getHeight();
            //BLog.e("Called toggle()  - 1 - height: "+height);
            if (height == 0 && !force) {
                ViewTreeObserver vto = getViewTreeObserver();
                if (vto.isAlive()) {
                    vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        @Override
                        public boolean onPreDraw() {
                            ViewTreeObserver currentVto = getViewTreeObserver();
                            if (currentVto.isAlive()) {
                                currentVto.removeOnPreDrawListener(this);
                            }
                            toggle(visible, animate, true);
                            //BLog.e("Called toggle()  - 2");
                            return true;
                        }
                    });
                    //BLog.e("Called toggle()  - 3");
                    return;
                }
            }
            int translationY = visible ? 0 : height + getMarginBottom();
            if (animate) {
                //BLog.e("Called toggle()  - 4: "+translationY);
                ViewPropertyAnimator.animate(this).setInterpolator(mInterpolator).setDuration(TRANSLATE_DURATION_MILLIS).translationY(translationY);
            } else {
                //BLog.e("Called toggle()  - 5");
                ViewHelper.setTranslationY(this, translationY);
            }

            // On pre-Honeycomb a translated view is still clickable, so we need to disable clicks manually
            if (!hasHoneycombApi()) {
                //BLog.e("Called toggle()  - 6");
                setClickable(visible);
            }
        }
    }

