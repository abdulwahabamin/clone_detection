    public void onRestoreInstanceState(CoordinatorLayout parent, V child, Parcelable state) {
        MyBottomBehavior.SavedState ss = (MyBottomBehavior.SavedState) state;
        super.onRestoreInstanceState(parent, child, ss.getSuperState());
        if (ss.state != 1 && ss.state != 2) {
            this.state = ss.state;
        } else {
            this.state = 4;
        }

    }

