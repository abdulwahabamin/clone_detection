        public void run() {
            if (null != musicService.getAlbumPic()) {
                Bitmap bitmap = BitmapFactory.decodeFile(musicService.getAlbumPic());
                playIvPic.setImageBitmap(bitmap);
            } else {
                playIvPic.setImageResource(R.mipmap.pic_holder);
            }
            playSbProgress.setMax(musicService.getDuration());
            playTvName.setText(musicService.getSongName());
            playTvSinger.setText(musicService.getSingerName());
            playTvAlbum.setText(musicService.getAlbum());
            playTvTotalTime.setText(formatTime(musicService.getDuration()));
            playSbProgress.setProgress(musicService.getCurrent());
            playTvCurrentTime.setText(formatTime(musicService.getCurrent()));
            handler.postDelayed(updateThread, 100);
        }

