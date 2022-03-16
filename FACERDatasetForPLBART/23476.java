    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.browse_button:
                intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(Uri.EMPTY, "vnd.android.cursor.dir/artistalbum");
                startActivity(intent);
                break;
            case R.id.albums_button:
                intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(Uri.EMPTY, "vnd.android.cursor.dir/album");
                startActivity(intent);
                break;
            case R.id.tracks_button:
                intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(Uri.EMPTY, "vnd.android.cursor.dir/track");
                startActivity(intent);
                break;
            case R.id.playlists_button:
                intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(Uri.EMPTY, MediaStore.Audio.Playlists.CONTENT_TYPE);
                startActivity(intent);
                break;
            case R.id.nowplaying:
                intent = new Intent("com.android.music.PLAYBACK_VIEWER");
                startActivity(intent);
                break;
        }
    }

