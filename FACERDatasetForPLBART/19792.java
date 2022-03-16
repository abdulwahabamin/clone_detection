        /**
         * Tries to claim the user's drag motion, and requests disallowing any ancestors from stealing events in the drag.
         */
        private void attemptClaimDrag() {
                if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                }
        }

