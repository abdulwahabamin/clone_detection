    @Override
    public void bind(ShuffleAllSongsVisitable visitable,
                     final BaseListItemOnClickListener onClickListener,
                     Context context) {
        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.OnClick();
            }
        });
    }

