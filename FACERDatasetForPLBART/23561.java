    private static Bitmap getArtworkFromFile(Context context, Uri uri, int albumid) {
        Bitmap bm = null;
        byte [] art = null;
        String path = null;

        if (sArtId == albumid) {
            //Log.i("@@@@@@ ", "reusing cached data", new Exception());
            if (mCachedBit != null) {
                return mCachedBit;
            }
            art = mCachedArt;
        } else {
            // try reading embedded artwork
            if (uri == null) {
                try {
                    int curalbum = sService.getAlbumId();
                    if (curalbum == albumid || albumid < 0) {
                        path = sService.getPath();
                        if (path != null) {
                            uri = Uri.parse(path);
                        }
                    }
                } catch (RemoteException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }
            if (uri == null) {
                if (albumid >= 0) {
                    Cursor c = query(context,MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                            new String[] { MediaStore.Audio.Media._ID, MediaStore.Audio.Media.ALBUM },
                            MediaStore.Audio.Media.ALBUM_ID + "=?", new String [] {String.valueOf(albumid)},
                            null);
                    if (c != null) {
                        if (c.moveToFirst()) {
                            int trackid = c.getInt(0);
                            uri = ContentUris.withAppendedId(
                                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, trackid);
                            if (MediaFile.UNKNOWN_STRING.equals(c.getString(1))) {
                                albumid = -1;
                            }
                        }
                        c.close();
                    }
                }
            }
            if (uri != null) {
                MediaScanner scanner = new MediaScanner(context);
                ParcelFileDescriptor pfd = null;
                try {
                    pfd = context.getContentResolver().openFileDescriptor(uri, "r");
                    if (pfd != null) {
                        FileDescriptor fd = pfd.getFileDescriptor();
                        art = scanner.extractAlbumArt(fd);
                    }
                } catch (IOException ex) {
                } catch (SecurityException ex) {
                } finally {
                    try {
                        if (pfd != null) {
                            pfd.close();
                        }
                    } catch (IOException ex) {
                    }
                }
            }
        }
        // if no embedded art exists, look for AlbumArt.jpg in same directory as the media file
        if (art == null && path != null) {
            if (path.startsWith(sExternalMediaUri)) {
                // get the real path
                Cursor c = query(context,Uri.parse(path),
                        new String[] { MediaStore.Audio.Media.DATA},
                        null, null, null);
                if (c != null) {
                    c.moveToFirst();
                    if (!c.isAfterLast()) {
                        path = c.getString(0);
                    }
                    c.close();
                }
            }
            int lastSlash = path.lastIndexOf('/');
            if (lastSlash > 0) {
                String artPath = path.substring(0, lastSlash + 1) + "AlbumArt.jpg";
                File file = new File(artPath);
                if (file.exists()) {
                    art = new byte[(int)file.length()];
                    FileInputStream stream = null;
                    try {
                        stream = new FileInputStream(file);
                        stream.read(art);
                    } catch (IOException ex) {
                        art = null;
                    } finally {
                        try {
                            if (stream != null) {
                                stream.close();
                            }
                        } catch (IOException ex) {
                        }
                    }
                } else {
                    // TODO: try getting album art from the web
                }
            }
        }
        
        if (art != null) {
            try {
                // get the size of the bitmap
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inJustDecodeBounds = true;
                opts.inSampleSize = 1;
                BitmapFactory.decodeByteArray(art, 0, art.length, opts);
                
                // request a reasonably sized output image
                // TODO: don't hardcode the size
                while (opts.outHeight > 320 || opts.outWidth > 320) {
                    opts.outHeight /= 2;
                    opts.outWidth /= 2;
                    opts.inSampleSize *= 2;
                }
                
                // get the image for real now
                opts.inJustDecodeBounds = false;
                bm = BitmapFactory.decodeByteArray(art, 0, art.length, opts);
                if (albumid != -1) {
                    sArtId = albumid;
                }
                mCachedArt = art;
                mCachedBit = bm;
            } catch (Exception e) {
            }
        }
        return bm;
    }

