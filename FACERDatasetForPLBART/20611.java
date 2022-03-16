    private void invalidateAfterUpdate() {
        View view = mView.get();
        if (view == null || view.getParent() == null) {
            return;
        }

        final RectF after = mAfter;
        computeRect(after, view);
        after.union(mBefore);

        ((View)view.getParent()).invalidate(
                (int) Math.floor(after.left),
                (int) Math.floor(after.top),
                (int) Math.ceil(after.right),
                (int) Math.ceil(after.bottom));
    }

