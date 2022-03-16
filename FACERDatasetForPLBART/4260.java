    public void promptCacheChange(int ypos, ListView list) {
        if(!activeCachechange) {
            activeCachechange=true;
            synchronized (this) {
                int firstpos = list.getFirstVisiblePosition();
                int lastpos = list.getLastVisiblePosition();

                if (lastpos > 0 && lastvis != lastpos) {

                    if (lastvis < lastpos) {
                        // going down
                        //Log.e("SCR","GPOING DOWN");
                        for (int i = lastpos; i <= lastpos + 10; i++) {
                            File f = Searcher.get(i).getAsFileItem();
                            if (f != null) {
                                //if(f.getName().endsWith("383.jpg")){BLog.e("PREL1", f.getPath());}
                                ImageCache.CacheBitmap cb = ImageCache.get(f.getPath());

                                if (cb == null) {
                                    if(Files.isImage(Files.removeBriefFileExtension(f.getName()))) {
                                        //BLog.e("PREL", f.getPath());
                                        LoadImageTask lt = new LoadImageTask();
                                        lt.setData(f, i, null);
                                        lt.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);

                                    } else if(Files.isVideo(Files.removeBriefFileExtension(f.getName()))) {
                                        ImageCache.CacheBitmap bMap=ImageCache.getNewCacheBitmap();
                                        Bitmap bitmap= ThumbnailUtils.createVideoThumbnail(f.getAbsolutePath(), MediaStore.Video.Thumbnails.MICRO_KIND);
                                        bMap.bitmap=bitmap;
                                        bMap.status=1;
                                        ImageCache.putFinal(f.getPath(),bMap);
                                    }
                                }

                            } else {
                                //BLog.e("BREAK1: "+ i);
                                break;
                            }
                        }
                    } else {
                        // going up
                        //Log.e("SCR","GPOING up");
                        for (int i = firstpos; i >= 0 && i >= firstpos - 10; i--) {
                            File f = Searcher.get(i).getAsFileItem();
                            if (f != null) {

                                ImageCache.CacheBitmap cb = ImageCache.get(f.getPath());
                                if (cb == null) {
                                    if(Files.isImage(Files.removeBriefFileExtension(f.getName()))) {
                                        //BLog.e("PREL", f.getPath());
                                        LoadImageTask lt = new LoadImageTask();
                                        lt.setData(f, i, null);
                                        lt.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, true);

                                    } else if(Files.isVideo(Files.removeBriefFileExtension(f.getName()))) {
                                        ImageCache.CacheBitmap bMap=ImageCache.getNewCacheBitmap();
                                        Bitmap bitmap= ThumbnailUtils.createVideoThumbnail(f.getAbsolutePath(), MediaStore.Video.Thumbnails.MICRO_KIND);
                                        bMap.bitmap=bitmap;
                                        bMap.status=1;
                                        ImageCache.putFinal(f.getPath(),bMap);
                                    }
                                }
                            } else {
                                //BLog.e("BREAK2: "+i);
                                break;
                            }
                        }
                    }

                    //lastypos=ypos;
                    lastvis = lastpos;
                }
            }
            activeCachechange=false;
        }
        //list.refreshDrawableState();
    }

