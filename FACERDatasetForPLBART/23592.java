        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            
            TextView tv = (TextView) view.findViewById(R.id.line1);
            
            String name = cursor.getString(mTitleIdx);
            tv.setText(name);
            
            long id = cursor.getLong(mIdIdx);
            
            ImageView iv = (ImageView) view.findViewById(R.id.icon);
            if (id == RECENTLY_ADDED_PLAYLIST) {
                iv.setImageResource(R.drawable.ic_mp_playlist_recently_added_list);
            } else {
                iv.setImageResource(R.drawable.ic_mp_playlist_list);
            }
            ViewGroup.LayoutParams p = iv.getLayoutParams();
            p.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            p.height = ViewGroup.LayoutParams.WRAP_CONTENT;

            iv = (ImageView) view.findViewById(R.id.play_indicator);
            iv.setVisibility(View.GONE);

            view.findViewById(R.id.line2).setVisibility(View.GONE);
        }

