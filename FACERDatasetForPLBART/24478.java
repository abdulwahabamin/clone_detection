        private void getColumnIndices(Cursor cursor) {
            try {
                titleIdx = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.TITLE);
                artistIdx = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.ARTIST);
                durationIdx = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DURATION);

                audioIdIdx = cursor.getColumnIndex(MediaStore.Audio.Playlists.Members.AUDIO_ID);
                if (audioIdIdx < 0) {
                    audioIdIdx = cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns._ID);
                }

                if (indexer != null) {
                    indexer.setCursor(cursor);
                } else if (!isEditMode() && !isAlbum) {
                    String alpha = getString(R.string.fast_scroll_alphabet);

                    indexer = new MusicAlphabetIndexer(cursor, titleIdx, alpha);
                }
            } catch (IllegalArgumentException e) {
                Log.w(LOGTAG, "Cursor does not contain expected columns, actually contains: "
                        + Arrays.toString(cursor.getColumnNames()) + " - " + e.toString());
            }
        }

