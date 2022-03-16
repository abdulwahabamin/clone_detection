        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            ViewHolder vh = (ViewHolder) view.getTag();

            cursor.copyStringToBuffer(titleIdx, vh.buffer1);
            vh.line1.setText(vh.buffer1.data, 0, vh.buffer1.sizeCopied);

            int secs = cursor.getInt(durationIdx);
            if (secs == 0) {
                vh.duration.setText("");
            } else {
                vh.duration.setText(MusicUtils.formatDuration(context, secs));
            }

            final StringBuilder builder = stringBuilder;
            builder.delete(0, builder.length());

            String name = cursor.getString(artistIdx);
            if (name == null || name.equals(MediaStore.UNKNOWN_STRING)) {
                builder.append(unknownArtistLabel);
            } else {
                builder.append(name);
            }
            int len = builder.length();
            if (vh.buffer2.length < len) {
                vh.buffer2 = new char[len];
            }
            builder.getChars(0, len, vh.buffer2, 0);
            vh.line2.setText(vh.buffer2, 0, len);

            long audioId = cursor.getLong(audioIdIdx);

            long playingId = -1;
            if (MusicUtils.sService != null) {
                playingId = MusicUtils.sService.getAudioId();
            }

            long crossfadingId = -1;
            if (MusicUtils.sService != null) {
                crossfadingId = MusicUtils.sService.getCrossfadeAudioId();
            }

            if (audioId == playingId) {
                vh.play_indicator.setVisibility(View.VISIBLE);
                vh.crossfade_indicator.setVisibility(View.INVISIBLE);
            } else if (audioId == crossfadingId) {
                vh.play_indicator.setVisibility(View.INVISIBLE);
                vh.crossfade_indicator.setVisibility(View.VISIBLE);
            } else {
                vh.play_indicator.setVisibility(View.INVISIBLE);
                vh.crossfade_indicator.setVisibility(View.INVISIBLE);
            }
        }

