        public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
            int top;
            byte targetState;
            int currentTop;
            if (yvel < 0.0F) {//上滑
                currentTop = releasedChild.getTop();
                if (currentTop >= MyBottomBehavior.this.halfExpandedOffset) {
                    top = MyBottomBehavior.this.halfExpandedOffset;
                    targetState = 6;
                } else {
                    top = 0;
                    targetState = 3;
                }
            } else if (!MyBottomBehavior.this.hideable || !MyBottomBehavior.this.shouldHide(releasedChild, yvel) || releasedChild.getTop() <= MyBottomBehavior.this.collapsedOffset && Math.abs(xvel) >= Math.abs(yvel)) {
                currentTop = releasedChild.getTop();
                if (currentTop == 0){
                    top = 0;
                    targetState = 3;
                }else if (currentTop <= MyBottomBehavior.this.halfExpandedOffset) {
                    top = MyBottomBehavior.this.halfExpandedOffset;
                    targetState = 6;
                } else {
                    top = MyBottomBehavior.this.collapsedOffset;
                    targetState = 4;
                }
            } else {
                top = MyBottomBehavior.this.parentHeight;
                targetState = 5;
            }

            if (MyBottomBehavior.this.viewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), top)) {
                MyBottomBehavior.this.setStateInternal(2);
                ViewCompat.postOnAnimation(releasedChild, MyBottomBehavior.this.new SettleRunnable(releasedChild, targetState));
            } else {
                MyBottomBehavior.this.setStateInternal(targetState);
            }

        }

