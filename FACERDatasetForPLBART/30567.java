        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            if (MyBottomBehavior.this.state == 1) {
                return false;
            } else if (MyBottomBehavior.this.touchingScrollingChild) {
                return false;
            } else {
                if (MyBottomBehavior.this.state == 3 && MyBottomBehavior.this.activePointerId == pointerId) {
                    View scroll = (View) MyBottomBehavior.this.nestedScrollingChildRef.get();
                    if (scroll != null && scroll.canScrollVertically(-1)) {
                        return false;
                    }
                }

                return MyBottomBehavior.this.viewRef != null && MyBottomBehavior.this.viewRef.get() == child;
            }
        }

