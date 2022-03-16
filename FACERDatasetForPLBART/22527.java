    private void captureValues(TransitionValues transitionValues) {
        final View view = transitionValues.view;
        transitionValues.values.put(PROPERTY_BOUNDS, new Rect(
                view.getLeft(), view.getTop(), view.getRight(), view.getBottom()
        ));
        int[] position = new int[2];
        transitionValues.view.getLocationInWindow(position);
        transitionValues.values.put(PROPERTY_POSITION, position);
    }

