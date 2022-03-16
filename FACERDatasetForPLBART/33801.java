        @Override
        public void onUpdate(float frac, float smoothFrac) {
            if (mDragState != DRAGGING) {
                cancel();
            } else {
                mDragDeltaY = (int) (smoothFrac * mFinalDragDeltaY + (1f - smoothFrac)
                        * mInitDragDeltaY);
                mFloatLoc.y = mY - mDragDeltaY;
                doDragFloatView(true);
            }
        }

