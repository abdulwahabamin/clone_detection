    @Override
    public void bind(final QueueItemVisitable visitable,
                     final QueueItemOnClickListener onClickListener,
                     Context context) {
        titleTv.setText(visitable.getMediaItem().getDescription().getTitle());
        subtitleTv.setText(visitable.getMediaItem().getDescription().getSubtitle());
        indexTv.setText(visitable.getIndexToDisplay()+"");

        if (visitable.getIndexToDisplay() == 0) {
            playingIconIv.setVisibility(View.VISIBLE);
            indexTv.setVisibility(View.GONE);
        } else {
            playingIconIv.setVisibility(View.GONE);
            indexTv.setVisibility(View.VISIBLE);
        }

        if (visitable.getIndexToDisplay() < 0) {
            titleTv.setTextColor(disabledColor);
            subtitleTv.setTextColor(disabledColor);
            indexTv.setTextColor(disabledColor);
        } else {
            titleTv.setTextColor(enabledTitleColor);
            subtitleTv.setTextColor(enabledSubtitleColor);
            indexTv.setTextColor(enabledSubtitleColor);
        }

        parentRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onQueueItemClick(visitable.getMediaItem());
            }
        });
    }

