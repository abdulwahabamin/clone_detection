        @Override
        public void onMovedToScrapHeap(View view) {
            final ImageView iconThumb = (ImageView) view.findViewById(R.id.icon_thumb);
            if (iconThumb != null) {
                final ThumbnailAsyncTask oldTask = (ThumbnailAsyncTask) iconThumb.getTag();
                if (oldTask != null) {
                    oldTask.preempt();
                    iconThumb.setTag(null);
                }
            }
        }

