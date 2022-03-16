    private synchronized void refreshIfVisible(File image, int pos) {

        if(parent!=null) {
            int first=parent.getFirstVisiblePosition();
            int last=parent.getLastVisiblePosition();
            LinearLayout view = (LinearLayout) parent.getChildAt(pos);
            if(view!=null) {
                //BLog.e("REFR", "refresh "+image.getPath());
                view=(LinearLayout)this.getView(pos, view, parent);

                parent.invalidate();

            }
        }

    }

