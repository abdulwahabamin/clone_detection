    void loadThumbnail(MediaViewHolder holder,int position,int selection){

        Util.loadAlbumArt(fileDirectoryList.get(position).getPath(),selection)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<Bitmap>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        subscription=s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        if(bitmap!=null){
                            if(selection==Util.VIDEO_ART ){
                                glide.load(bitmap)
                                    .apply(AppController.getRequestOptions())
                                    .into(holder.thumbnail);
                            }
                            else if(selection==Util.MUSIC_ART ){
                                glide.load(bitmap)
                                        .apply(AppController.getCircleRequestOptions())
                                        .into(holder.thumbnail);
                            }
                        }

                        else{
                            if(selection==Util.VIDEO_ART ){
                                glide.load(R.drawable.video)
                                        .apply(AppController.getRequestOptions())
                                        .into(holder.thumbnail);
                            }
                            else if(selection==Util.MUSIC_ART ){
                                glide.load(R.drawable.music)
                                        .apply(AppController.getCircleRequestOptions())
                                        .into(holder.thumbnail);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG,"Error: "+t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

