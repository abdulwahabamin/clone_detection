    void loadThumbnail(RecentFileViewHolder holder, int position, int selection){

        Util.loadAlbumArt(totalList.get(position).getPath(),selection)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<Bitmap>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        if(bitmap!=null){
                            if(selection==Util.VIDEO_ART ){
                                requestManager.load(bitmap)
                                        .apply(AppController.getRequestOptions())
                                        .into(holder.icon);
                            }
                            else if(selection==Util.MUSIC_ART ){
                                requestManager.load(bitmap)
                                        .apply(AppController.getCircleRequestOptions())
                                        .into(holder.icon);
                            }
                        }

                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(RecentFilesAdapter.class.getSimpleName(),"Error: "+t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

