        private final boolean createThumbnail( String fn, FileItem f, int h ) {
            final String func_name = "createThubnail()"; 
            try {
                if( h == apk_h ) {
                    try {
                        f.thumb_is_icon = true;
                        PackageManager pm = ctx.getPackageManager();
                        PackageInfo info = pm.getPackageArchiveInfo( fn, 0 );
                        if( info != null ) {
                            Drawable icon = null;
                            try {
                                icon = pm.getApplicationIcon( info.packageName );
                            } catch( Exception e ) {
                            }
                            if( icon != null ) {
                               //Log.v( TAG, "icon for " + fn );
                               f.setIcon( icon );
                               return true;
                            }
                        }
                        MnfUtils mnfu = new MnfUtils( fn );
                        Drawable icon = mnfu.extractIcon();
                        if( icon != null ) {
                           f.setIcon( icon );
                           return true;
                        }
                        f.setIcon( pm.getDefaultActivityIcon() );
                        return true;
                    }
                    catch( Exception e ) {
                    }
                    return false;
                }
                // let's try to take it from the mediastore
                try {
                    String[] proj = { BaseColumns._ID };
                    String where = Media.DATA + " = '" + fn + "'";
                    Cursor cursor = cr.query( Media.EXTERNAL_CONTENT_URI, proj, where, null, null );
                    if( cursor != null && cursor.getCount() > 0 ) {
                        cursor.moveToPosition( 0 );
                        long id = cursor.getLong( 0 );
                        cursor.close();
                        String[] th_proj = new String[] {
                            BaseColumns._ID,     // 0
                            Thumbnails.WIDTH,    // 1
                            Thumbnails.HEIGHT,   // 2
                            Thumbnails.IMAGE_ID  // 3
                        };
                        cursor = Thumbnails.queryMiniThumbnail( cr, id, Thumbnails.MINI_KIND, th_proj );
                        if( cursor != null && cursor.getCount() > 0 ) {
                            cursor.moveToPosition( 0 );
                            Uri tcu = ContentUris.withAppendedId( Thumbnails.EXTERNAL_CONTENT_URI, cursor.getLong(0) );
                            int tw = cursor.getInt( 1 );
                            int th = cursor.getInt( 2 );
                            //Log.v( TAG, "th id: " + cursor.getLong(0) +  ", org id: " + cursor.getLong(3) + ", w: " + tw +  ", h: " + th );
                            cursor.close();
                            InputStream in = cr.openInputStream( tcu );
                            
                            if( tw > 0 && th > 0 ) {
                                int greatest = Math.max( tw, th );
                                int factor = greatest / thumb_sz;
                                int b;
                                for( b = 0x8000000; b > 0; b >>= 1 )
                                    if( b <= factor ) break;
                                options.inSampleSize = b;
                            }
                            else                            
                                options.inSampleSize = 4;                            
                            options.inJustDecodeBounds = false;
                            options.inTempStorage = buf;
                            Bitmap bitmap = BitmapFactory.decodeStream( in, null, options );
                            if( bitmap != null ) {
                                BitmapDrawable drawable = new BitmapDrawable( res, bitmap );
                                f.setThumbNail( drawable );
                                in.close();
                                //Log.v( TAG, "a thumbnail was stolen from " + tcu );
                                return true;
                            }
                        }
                    }
                } catch( Exception e ) {
                    //Log.e( TAG, fn, e );
                }
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                options.outWidth = 0;
                options.outHeight = 0;
                options.inTempStorage = buf;
                
                FileInputStream fis = new FileInputStream( fn );
                BitmapFactory.decodeStream( fis, null, options);
                //BitmapFactory.decodeFile( fn, options );
                if( options.outWidth > 0 && options.outHeight > 0 ) {
                    f.attr = "" + options.outWidth + "x" + options.outHeight;
                    int greatest = Math.max( options.outWidth, options.outHeight );
                    int factor = greatest / thumb_sz;
                    int b;
                    for( b = 0x8000000; b > 0; b >>= 1 )
                        if( b < factor ) break;
                    options.inSampleSize = b;
                    options.inJustDecodeBounds = false;
                    Bitmap bitmap = BitmapFactory.decodeFile( fn, options );
                    if( bitmap != null ) {
                        BitmapDrawable drawable = new BitmapDrawable( res, bitmap );
//                        drawable.setGravity( Gravity.CENTER );
//                        drawable.setBounds( 0, 0, 60, 60 );
                        f.setThumbNail( drawable );
                        fis.close();
                        return true;
                    }
                }
                else
                    Log.w( TAG, "failed to get an image bounds" );
                fis.close();
                Log.e( TAG, func_name + " failed for " + fn );
            } catch( RuntimeException rte ) {
                Log.e( TAG, func_name, rte );
            } catch( FileNotFoundException fne ) {
                Log.e( TAG, func_name, fne );
            } catch( IOException ioe ) {
                Log.e( TAG, func_name, ioe );
            } catch( Error err ) {
                Log.e( TAG, func_name, err );
            }
            return false;
        }

