    void setStateInternal(int state) {
        if (this.state != state) {
            this.state = state;
            if (state != 6 && state != 3) {
                if (state == 5 || state == 4) {
                    this.updateImportantForAccessibility(false);
                }
            } else {
                this.updateImportantForAccessibility(true);
            }

            View bottomSheet = (View) this.viewRef.get();
            if (bottomSheet != null && this.callback != null) {
                this.callback.onStateChanged(bottomSheet, state);
            }

        }
    }

