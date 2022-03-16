    @Override
    public void onPlayQueueDestroyed() {
        if(findViewById(R.id.peek_player) != null) {
            peekPlayerParent.removeView(peekPlayer);
        }
    }

