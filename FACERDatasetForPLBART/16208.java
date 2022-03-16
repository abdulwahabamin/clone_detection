    @Override
    public void onDestroy() {
        super.onDestroy();
        player.close();
        handler.closeAllHandlers();
        stopForeground(false);
    }

