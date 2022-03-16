    public static <V extends View> MyBottomBehavior<V> from(V view) {
        LayoutParams params = view.getLayoutParams();
        if (!(params instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        } else {
            Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
            if (!(behavior instanceof MyBottomBehavior)) {
                throw new IllegalArgumentException("The view is not associated with MyBottomBehavior");
            } else {
                return (MyBottomBehavior) behavior;
            }
        }
    }

