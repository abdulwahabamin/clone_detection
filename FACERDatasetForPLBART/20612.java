    private void computeRect(final RectF r, View view) {
        // compute current rectangle according to matrix transformation
        final float w = view.getWidth();
        final float h = view.getHeight();

        // use a rectangle at 0,0 to make sure we don't run into issues with scaling
        r.set(0, 0, w, h);

        final Matrix m = mTempMatrix;
        m.reset();
        transformMatrix(m, view);
        mTempMatrix.mapRect(r);

        r.offset(view.getLeft(), view.getTop());

        // Straighten coords if rotations flipped them
        if (r.right < r.left) {
            final float f = r.right;
            r.right = r.left;
            r.left = f;
        }
        if (r.bottom < r.top) {
            final float f = r.top;
            r.top = r.bottom;
            r.bottom = f;
        }
    }

