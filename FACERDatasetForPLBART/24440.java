    @Override
    public void onServiceConnected(MediaPlayback s) {
        service = s;
        playQueueCursor = new PlayQueueCursor(service, getActivity().getContentResolver());
        listAdapter = new SimpleCursorAdapterWithContextMenu(
                getActivity(),
                R.layout.edit_track_list_item,
                playQueueCursor,
                PlayQueueCursor.COLUMNS,
                new int[]{R.id.line1, R.id.line2, R.id.duration, R.id.play_indicator, R.id.crossfade_indicator},
                0);
        listAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            final String unknownArtist = PlayQueueFragment.this.getActivity().getString(R.string.unknown_artist_name);

            @Override
            public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
                switch (view.getId()) {
                    case R.id.line2:
                        String name = cursor.getString(columnIndex);
                        if (name == null || name.equals(MediaStore.UNKNOWN_STRING)) {
                            ((TextView) view).setText(unknownArtist);
                        } else {
                            ((TextView) view).setText(name);
                        }

                        return true;

                    case R.id.duration:
                        int secs = cursor.getInt(columnIndex);
                        if (secs == 0) {
                            ((TextView) view).setText("");
                        } else {
                            ((TextView) view).setText(MusicUtils.formatDuration(PlayQueueFragment.this.getActivity(), secs));
                        }
                        return true;

                    case R.id.play_indicator:
                        if (service != null) {
                            int cursorPosition = cursor.getPosition();
                            if (cursorPosition == service.getQueuePosition()) {
                                view.setVisibility(View.VISIBLE);
                            } else {
                                view.setVisibility(View.INVISIBLE);
                            }
                            return true;
                        }

                    case R.id.crossfade_indicator:
                        if (service != null) {
                            int cursorPosition = cursor.getPosition();
                            if (cursorPosition == service.getCrossfadeQueuePosition()) {
                                view.setVisibility(View.VISIBLE);
                            } else {
                                view.setVisibility(View.INVISIBLE);
                            }
                            return true;
                        }

                    default:
                        return false;
                }

            }
        });
        setListAdapter(listAdapter);
    }

