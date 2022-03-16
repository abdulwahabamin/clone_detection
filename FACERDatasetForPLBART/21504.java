        @Override
        public void onClick(View v) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    playAll(mContext, songIDs, getAdapterPosition(), artistID,
                            TimberUtils.IdType.Artist, false,
                            arraylist.get(getAdapterPosition()), true);
                }
            }, 100);

        }

