        @Override
        public void onClick(View v) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    playAll(mContext, songIDs, getAdapterPosition(), albumID,
                            TimberUtils.IdType.Album, false,
                            arraylist.get(getAdapterPosition()), true);
                }
            }, 100);

        }

