    /**
     * Overrides to provide fading when slide removal is enabled.
     */
    @Override
    public void onDragFloatView(View floatView, Point position, Point touch) {

        if (mRemoveEnabled && mIsRemoving) {
            mPositionX = position.x;
        }
    }

