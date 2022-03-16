    @Override
    public void toggle() {
        View child = getChildAt(0);
        if (child instanceof Checkable) {
            ((Checkable) child).toggle();
        }
    }

