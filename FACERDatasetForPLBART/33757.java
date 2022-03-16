    @Override
    public boolean isChecked() {
        View child = getChildAt(0);
        if (child instanceof Checkable) {
            return ((Checkable) child).isChecked();
        } else {
            return false;
        }
    }

