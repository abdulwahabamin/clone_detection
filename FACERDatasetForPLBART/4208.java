        private synchronized void refreshIfVisibleOld(File image, int pos) {

            if(parent!=null) {
                //int first=parent.getFirstVisiblePosition();
                //int last=parent.getLastVisiblePosition();
                RelativeLayout view = (RelativeLayout) parent.getChildAt(pos);
                if(view!=null) {
                    //BLog.e("REFR", "refresh "+image.getPath());
                    view=(RelativeLayout)this.getView(pos, view, parent);
                    view.refreshDrawableState();
                    //parent.invalidate();
                }
            }

        }

