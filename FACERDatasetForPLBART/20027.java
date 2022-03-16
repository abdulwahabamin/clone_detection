    private void doDragFloatView(boolean forceInvalidate) {
        int movePos = getFirstVisiblePosition() + getChildCount() / 2;
        View moveItem = getChildAt(getChildCount() / 2);

        if (moveItem == null) {
            return;
        }

        doDragFloatView(movePos, moveItem, forceInvalidate);
    }

