    @SuppressLint("NewApi")
    private void init(Context context, AttributeSet attributeSet) {
        mVisible = true;
        mColorNormal = getColor(R.color.material_blue_500);
        mColorPressed = darkenColor(mColorNormal);
        mColorRipple = lightenColor(mColorNormal);
        mColorDisabled = getColor(android.R.color.darker_gray);
        mType = TYPE_NORMAL;
        mShadow = true;
        mScrollThreshold = getResources().getDimensionPixelOffset(R.dimen.fab_scroll_threshold);
        mShadowSize = getDimension(R.dimen.fab_shadow_size);
        if (hasLollipopApi()) {
            StateListAnimator stateListAnimator = AnimatorInflater.loadStateListAnimator(context,
                    R.anim.fab_press_elevation);
            setStateListAnimator(stateListAnimator);
        }
        if (attributeSet != null) {
            initAttributes(context, attributeSet);
        }
        updateBackground();
    }

