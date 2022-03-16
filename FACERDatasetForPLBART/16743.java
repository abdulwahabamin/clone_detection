    private void setOnPopupMenuListener(MyViewHolder viewHolder, final MediaBrowserCompat.MediaItem mediaItem) {
        viewHolder.popupMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final PopupMenu menu = new PopupMenu(context, v);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(final MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.popup_song_play:
                                popupMenuSelectedListener.onPlaySelected(mediaItem);
                                break;
                            case R.id.popup_share:
                                popupMenuSelectedListener.onShareSelected(mediaItem);
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                menu.inflate(R.menu.menu_popup);
                menu.show();
            }
        });
    }

