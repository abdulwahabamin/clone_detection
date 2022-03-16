        @Override
        public void onReceive(Context context, Intent intent) {
            // The service could disappear while the broadcast was in flight,
            // so check to see if it's still valid
            if (service == null) {
                return;
            }

            if (intent.getAction().equals(MediaPlaybackService.QUEUE_CHANGED)) {
                if (deletedOneRow) {
                    // This is the notification for a single row that was
                    // deleted previously, which is already reflected in the UI.
                    deletedOneRow = false;
                    return;
                }
                playQueueCursor.requery();
                listAdapter.notifyDataSetChanged();
            }

            getListView().invalidateViews();
            if (!listScrolled && !queueZoomed) getListView().setSelection(service.getQueuePosition() + 1);
        }

