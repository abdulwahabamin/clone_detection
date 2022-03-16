        public void run() {
            if (MyBottomBehavior.this.viewDragHelper != null && MyBottomBehavior.this.viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else {
                MyBottomBehavior.this.setStateInternal(this.targetState);
            }

        }

