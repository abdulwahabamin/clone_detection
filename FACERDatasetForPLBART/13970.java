        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            TextView tv1 = (TextView)view.findViewById(R.id.listview_item_line_one);
            tv1.setTextColor(Color.BLACK);
            TextView tv2 = (TextView)view.findViewById(R.id.listview_item_line_two);
            tv2.setTextColor(Color.BLACK);
            ImageView iv = (ImageView)view.findViewById(R.id.listview_item_image);
            iv.setVisibility(View.GONE);
            FrameLayout fl = (FrameLayout)view.findViewById(R.id.track_list_context_frame);
            fl.setVisibility(View.GONE);
            ViewGroup.LayoutParams p = iv.getLayoutParams();
            if (p == null) {
                // seen this happen, not sure why
                DatabaseUtils.dumpCursor(cursor);
                return;
            }
            p.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            p.height = ViewGroup.LayoutParams.WRAP_CONTENT;

            String mimetype = cursor.getString(cursor.getColumnIndexOrThrow(Audio.Media.MIME_TYPE));

            if (mimetype == null) {
                mimetype = "audio/";
            }
            if (mimetype.equals("artist")) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(Audio.Artists.ARTIST));
                String displayname = name;
                boolean isunknown = false;
                if (name == null || name.equals(MediaStore.UNKNOWN_STRING)) {
                    displayname = context.getString(R.string.unknown);
                    isunknown = true;
                }
                tv1.setText(displayname);

                int numalbums = cursor.getInt(cursor.getColumnIndexOrThrow("data1"));
                int numsongs = cursor.getInt(cursor.getColumnIndexOrThrow("data2"));

                String songs_albums = MusicUtils.makeAlbumsLabel(context, numalbums, numsongs,
                        isunknown);

                tv2.setText(songs_albums);

            } else if (mimetype.equals("album")) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(Audio.Albums.ALBUM));
                String displayname = name;
                if (name == null || name.equals(MediaStore.UNKNOWN_STRING)) {
                    displayname = context.getString(R.string.unknown);
                }
                tv1.setText(displayname);

                name = cursor.getString(cursor.getColumnIndexOrThrow(Audio.Artists.ARTIST));
                displayname = name;
                if (name == null || name.equals(MediaStore.UNKNOWN_STRING)) {
                    displayname = context.getString(R.string.unknown);
                }
                tv2.setText(displayname);

            } else if (mimetype.startsWith("audio/") || mimetype.equals("application/ogg")
                    || mimetype.equals("application/x-ogg")) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(Audio.Media.TITLE));
                tv1.setText(name);

                String displayname = cursor.getString(cursor
                        .getColumnIndexOrThrow(Audio.Artists.ARTIST));
                if (displayname == null || displayname.equals(MediaStore.UNKNOWN_STRING)) {
                    displayname = context.getString(R.string.unknown);
                }
                name = cursor.getString(cursor.getColumnIndexOrThrow(Audio.Albums.ALBUM));
                if (name == null || name.equals(MediaStore.UNKNOWN_STRING)) {
                    name = context.getString(R.string.unknown);
                }
                tv2.setText(displayname + " - " + name);
            }
        }

