        MyViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.file_video_icon);
            tv = (TextView) view.findViewById(R.id.item_video_name);
            mLayout = (LinearLayout) view.findViewById(R.id.video_linear);
            file_video_delete = (TextView) view.findViewById(R.id.file_video_delete);
        }

