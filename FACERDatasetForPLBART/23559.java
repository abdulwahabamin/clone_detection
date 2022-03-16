    /** Get album art for specified album. You should not pass in the album id
     * for the "unknown" album here (use -1 instead)
     */
    public static Bitmap getArtwork(Context context, int album_id, boolean allowDefault) {

        if (album_id < 0) {
            // This is something that is not in the database, so get the album art directly
            // from the file.
            Bitmap bm = getArtworkFromFile(context, null, -1);
            if (bm != null) {
                return bm;
            }
            if (allowDefault) {
                return getDefaultArtwork(context);
            } else {
                return null;
            }
        }

        ContentResolver res = context.getContentResolver();
        Uri uri = ContentUris.withAppendedId(sArtworkUri, album_id);
        if (uri != null) {
            InputStream in = null;
            try {
                in = res.openInputStream(uri);
                return BitmapFactory.decodeStream(in, null, sBitmapOptions);
            } catch (FileNotFoundException ex) {
                // The album art thumbnail does not actually exist. Maybe the user deleted it, or
                // maybe it never existed to begin with.
                Bitmap bm = getArtworkFromFile(context, null, album_id);
                if (bm != null) {
                    if (bm.getConfig() == null) {
                        bm = bm.copy(Bitmap.Config.RGB_565, false);
                        if (bm == null) {
                            if (allowDefault) {
                                return getDefaultArtwork(context);
                            } else {
                                return null;
                            }
                        }
                    }
                    // Put the newly found artwork in the database.
                    // Note that this shouldn't be done for the "unknown" album,
                    // but if this method is called correctly, that won't happen.
                    
                    // first write it somewhere
                    String file = Environment.getExternalStorageDirectory()
                        + "/albumthumbs/" + String.valueOf(System.currentTimeMillis());
                    if (ensureFileExists(file)) {
                        try {
                            OutputStream outstream = new FileOutputStream(file);
                            boolean success = bm.compress(Bitmap.CompressFormat.JPEG, 75, outstream);
                            outstream.close();
                            if (success) {
                                ContentValues values = new ContentValues();
                                values.put("album_id", album_id);
                                values.put("_data", file);
                                Uri newuri = res.insert(sArtworkUri, values);
                                if (newuri == null) {
                                    // Failed to insert in to the database. The most likely
                                    // cause of this is that the item already existed in the
                                    // database, and the most likely cause of that is that
                                    // the album was scanned before, but the user deleted the
                                    // album art from the sd card.
                                    // We can ignore that case here, since the media provider
                                    // will regenerate the album art for those entries when
                                    // it detects this.
                                    success = false;
                                }
                            }
                            if (!success) {
                                File f = new File(file);
                                f.delete();
                            }
                        } catch (FileNotFoundException e) {
                            Log.e(TAG, "error creating file", e);
                        } catch (IOException e) {
                            Log.e(TAG, "error creating file", e);
                        }
                    }
                } else if (allowDefault) {
                    bm = getDefaultArtwork(context);
                } else {
                    bm = null;
                }
                return bm;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                }
            }
        }
        
        return null;
    }

