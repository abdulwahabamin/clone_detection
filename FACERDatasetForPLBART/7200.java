        @Override
        public void run() {
            try {
                if( mList == null ) return;
                setPriority( Thread.MIN_PRIORITY );
                thumb_sz = getImgWidth();
                options = new BitmapFactory.Options();
                res = ctx.getResources();
                int fails_count = 0;
                boolean visible_only = mList.length > 100;  // too many icons
                for( int a = 0; a < 2; a++ ) {
                    boolean succeeded = true;
                    boolean need_update = false, proc_visible = false, proc_invisible = false;
                    int processed = 0;
                    for( int i = 0; i < mList.length ; i++ ) {
                        visible_only = visible_only || fails_count > 1;
                        //if( visible_only ) Log.v( TAG, "thumb on requests only" );
                        int n = -1;
                        while( true ) {
                            for( int j = 0; j < mList.length ; j++ ) {
                                if( mList[j].need_thumb ) {
                                    n = j;
                                    proc_visible = true;
                                    //Log.v( TAG, "A thumbnail requested ahead of time!!! " + n + ", " + mList[n].f.getName() );
                                    break;
                                }
                                else {
                                    mList[j].remThumbnailIfOld( visible_only ? 10000 : 60000 );  // clear not in use to free memory
                                }
                            }
                            if( !visible_only || proc_visible ) break;
                            //Log.v( TAG, "Tired. Waiting for a request to proceed" );
                            synchronized( owner ) {
                                owner.wait();
                            }
                        }
                        proc_invisible = n < 0;
                        if( proc_invisible )
                            n = i;
                        else
                            i--;
                        if( !proc_visible ) {
                            yield();
                            sleep( 10 );
                        }
                        FileItem f = mList[n];
                        f.need_thumb = false;

                        if( f.isThumbNail() )
                            continue;   // already exist

                        String fn = f.f.getAbsolutePath();
                        int fn_h = ( fn + " " + f.f.length() ).hashCode();
                        SoftReference<Drawable> cached_soft = null;
                        synchronized( thumbnailCache ) {
                            cached_soft = thumbnailCache.get( fn_h );
                        }
                        if( cached_soft != null )
                            f.setThumbNail( cached_soft.get() );

                        String ext = Utils.getFileExt( fn );
                        if( ext == null ) continue;
                        if( ext.equals( ".apk" ) ) f.thumb_is_icon = true;
                        if( !f.isThumbNail() ) {
                            int ext_hash = ext.hashCode(), ht_sz = ext_h.length;
                            boolean not_img = true;
                            for( int j = 0; j < ht_sz; j++ ) {
                                if( ext_hash == ext_h[j] ) {
                                    not_img = false;
                                    break;
                                }
                            }
                            if( not_img ) {
                                f.no_thumb = true;
                                f.setThumbNail( null );
                                continue;
                            }
                            //Log.v( TAG, "Creating a thumbnail for " + n + ", " + fn );
                            if( createThumbnail( fn, f, ext_hash ) ) {
                                synchronized( thumbnailCache ) {
                                    thumbnailCache.put( fn_h, new SoftReference<Drawable>( f.getThumbNail() ) );
                                }
                            }
                            else {
                                succeeded = false;
                                if( fails_count++ > 10 ) {
                                    Log.e( TAG, "To many fails, give up" );
                                    return;
                                }
                            }
                        }
                        need_update = true;
                        if( f.isThumbNail() && ( processed++ > 3 || ( proc_visible && proc_invisible ) ) ) {
                            //Log.v( TAG, "Time to refresh!" );
                            Message msg = thread_handler.obtainMessage( NOTIFY_THUMBNAIL_CHANGED );
                            msg.sendToTarget();
                            yield();
                            proc_visible = false;
                            need_update = false;
                            processed = 0;
                        }
                    }
                    if( need_update ) {
                        Message msg = thread_handler.obtainMessage( NOTIFY_THUMBNAIL_CHANGED );
                        msg.sendToTarget();
                    }
                    if( succeeded ) break;
                }
            } catch( Exception e ) {
                //Log.e( TAG, "ThumbnailsThread.run()", e );
            }
        }

