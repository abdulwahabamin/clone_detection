        private synchronized void refreshIfVisible(File image, int pos) {

            if(parent!=null) {
                RelativeLayout view = (RelativeLayout) parent.getChildAt(pos);
                if(view!=null) {
                    parent.childDrawableStateChanged(view);
                    //BLog.e("REFR", "refresh "+image.getPath());
                    //view=(RelativeLayout)this.getView(pos, view, parent);

                    //parent.invalidate();

                }

            }

        }

