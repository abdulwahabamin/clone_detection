    @Override
    public void bind(final DetailTitleVisitable visitable,
                     final DetailTitleOnClickListener onClickListener,
                     Context context) {

        titleTv.setText(visitable.getMediaItem().getDescription().getTitle());
        subtitleTv.setText(visitable.getMediaItem().getDescription().getSubtitle());

        parentView.setBackgroundColor(visitable.getBackgroundColor());
        titleTv.setTextColor(visitable.getTitleTextColor());
        subtitleTv.setTextColor(visitable.getSubtitleTextColor());

        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do nothing
            }
        });
    }

