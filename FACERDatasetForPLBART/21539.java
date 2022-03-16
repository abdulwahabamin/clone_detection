        @Override
        public void onClick(View v) {
            if (mBusy) {
                return;
            }
            final File f = mFileSet.get(getAdapterPosition());

            if (f.isDirectory() && updateDataSetAsync(f)) {
                albumArt.setImageDrawable(mIcons[3]);
            } else if (f.isFile()) {

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int current = -1;
                        long songId = SongLoader.getSongFromPath(mFileSet.get(getAdapterPosition()).getAbsolutePath(), mContext).id;
                        int count = 0;
                        for (Song song : mSongs) {
                            if (song.id != -1) {
                                count++;
                            }
                        }
                        long[] ret = new long[count];
                        int j = 0;
                        for (int i = 0; i < getItemCount(); i++) {
                            if (mSongs.get(i).id != -1) {
                                ret[j] = mSongs.get(i).id;
                                if (mSongs.get(i).id == songId) {
                                    current = j;
                                }
                                j++;
                            }
                        }
                        playAll(mContext, ret, current, -1, TimberUtils.IdType.NA,
                                false, mSongs.get(getAdapterPosition()), false);
                    }
                }, 100);


            }
        }

