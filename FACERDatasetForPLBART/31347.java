        @Override
        public void onNext(BitmapCacheWrapper bitmapCacheWrapper) {
            if (view != null) {
                if (viewType == VIEW_TYPE_VIEW) {
                    view.setBackground(new BitmapDrawable(view.getContext().getResources(), bitmapCacheWrapper.getBitmap()));
                } else if (viewType == VIEW_TYPE_IMAGEVIEW) {
                    ((ImageView)view).setImageDrawable(new BitmapDrawable(view.getContext().getResources(), bitmapCacheWrapper.getBitmap()));
                }
            }
        }

