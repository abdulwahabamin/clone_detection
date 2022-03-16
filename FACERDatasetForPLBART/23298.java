        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
           View v = super.newView(context, cursor, parent);
           ImageView iv = (ImageView) v.findViewById(R.id.icon);
           iv.setVisibility(View.VISIBLE);
           ViewGroup.LayoutParams p = iv.getLayoutParams();
           p.width = ViewGroup.LayoutParams.WRAP_CONTENT;
           p.height = ViewGroup.LayoutParams.WRAP_CONTENT;

           TextView tv = (TextView) v.findViewById(R.id.duration);
           tv.setVisibility(View.GONE);
           iv = (ImageView) v.findViewById(R.id.play_indicator);
           iv.setVisibility(View.GONE);
           
           return v;
        }

