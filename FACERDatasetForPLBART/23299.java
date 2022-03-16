        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            TextView tv = (TextView) view.findViewById(R.id.line1);
            String name = cursor.getString(mTitleIdx);
            tv.setText(name);
            
            tv = (TextView) view.findViewById(R.id.line2);
            name = cursor.getString(mAlbumIdx);
            StringBuilder builder = new StringBuilder();
            if (name == null || name.equals(MediaFile.UNKNOWN_STRING)) {
                builder.append(context.getString(R.string.unknown_album_name));
            } else {
                builder.append(name);
            }
            builder.append("\n");
            name = cursor.getString(mArtistIdx);
            if (name == null || name.equals(MediaFile.UNKNOWN_STRING)) {
                builder.append(context.getString(R.string.unknown_artist_name));
            } else {
                builder.append(name);
            }
            tv.setText(builder.toString());

            String text = cursor.getString(mMimeIdx);
            ImageView iv = (ImageView) view.findViewById(R.id.icon);;
            if("audio/midi".equals(text)) {
                iv.setImageResource(R.drawable.midi);
            } else if(text != null && (text.startsWith("audio") ||
                    text.equals("application/ogg") ||
                    text.equals("application/x-ogg"))) {
                iv.setImageResource(R.drawable.ic_search_category_music_song);
            } else if(text != null && text.startsWith("video")) {
                iv.setImageResource(R.drawable.movie);
            } else {
                iv.setImageResource(0);
            }
        }

