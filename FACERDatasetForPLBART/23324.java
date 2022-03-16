    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(PARTY_SHUFFLE);
        if (item != null) {
            int shuffle = MusicUtils.getCurrentShuffleMode();
            if (shuffle == MediaPlaybackService.SHUFFLE_AUTO) {
                item.setIcon(R.drawable.ic_menu_party_shuffle);
                item.setTitle(R.string.party_shuffle_off);
            } else {
                item.setIcon(R.drawable.ic_menu_party_shuffle);
                item.setTitle(R.string.party_shuffle);
            }
        }

        /**
         * Add menu for sending media file over Bluetooth
         */
        boolean bluetoothEnabled = false;
        if (mBluetooth != null) {
           bluetoothEnabled = mBluetooth.isEnabled();
        }
        menu.setGroupEnabled(MENU_GROUP_BT, bluetoothEnabled);
        menu.setGroupVisible(MENU_GROUP_BT, bluetoothEnabled);

        return true;
    }

