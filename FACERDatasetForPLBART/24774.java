    public static void changeListButton(int position){
        try {
            ImageView imageView = (ImageView) mRecyclerView.findViewHolderForLayoutPosition(position).itemView.findViewById(R.id.isplay);
            if (PlayerConstants.mSongPlayback.isPlay) {
                imageView.setImageResource(R.drawable.pause);
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setImageResource(R.drawable.play);
                imageView.setVisibility(View.VISIBLE);
            }
        }
        catch (Exception e) {}
    }

