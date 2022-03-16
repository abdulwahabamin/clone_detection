    /**
     * Set the draggable view portion. Use to null, to allow the whole panel to be draggable
     *
     * @param dragView A view that will be used to drag the panel.
     */
    public void setDragView(View dragView) {
        if (mDragView != null && mDragViewClickable) {
            mDragView.setOnClickListener(null);
        }
        mDragView = dragView;
        if (mDragView != null) {
            mDragView.setClickable(true);
            mDragView.setFocusable(false);
            mDragView.setFocusableInTouchMode(false);
            if (mDragViewClickable) {
                mDragView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!isEnabled()) return;
                        if (!isPanelExpanded() && !isPanelAnchored()) {
                            expandPanel(mAnchorPoint);
                        } else {
                            collapsePanel();
                        }
                    }
                });
            }
        }
    }

