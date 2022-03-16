    public static Flowable<Bitmap> loadAlbumArt(String path,int selection){

        return Flowable.create(new FlowableOnSubscribe<Bitmap>() {
            @Override
            public void subscribe(FlowableEmitter<Bitmap> e) throws Exception {
                android.media.MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                //Log.e(TAG,"Path: "+path);
                mmr.setDataSource(path);
                byte [] data=null;
                Bitmap bitmap=null;
                if(selection==MUSIC_ART) {
                    data = mmr.getEmbeddedPicture();
                    if(data != null)
                    {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 8;
                        bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,options);
                        e.onNext(bitmap);
                    }
                }
                else if(selection==VIDEO_ART){
                    bitmap=mmr.getFrameAtTime();
                    e.onNext(bitmap);
                }


                e.onComplete();
            }
        },BackpressureStrategy.BUFFER);

    }

