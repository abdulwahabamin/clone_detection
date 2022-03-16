    private void playNext() {
        if (callback != null) {
            callback.playNext();
        } else {
            Intent intent = new Intent(getContext().getApplicationContext(), MediaPlayerService.class);
            intent.setAction(Constants.ACTION_NEXT);
            getContext().getApplicationContext().startService(intent);
        }
    }

