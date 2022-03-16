    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Don't show the menu items if we got launched by path/filedescriptor, or
        // if we're in one shot mode. In most cases, these menu items are not
        // useful in those modes, so for consistency we never show them in these
        // modes, instead of tailoring them to the specific file being played.
        if (MusicUtils.getCurrentAudioId() >= 0 && !mOneShot) {
            menu.add(0, GOTO_START, 0, R.string.goto_start).setIcon(R.drawable.ic_menu_music_library);
            menu.add(0, PARTY_SHUFFLE, 0, R.string.party_shuffle); // icon will be set in onPrepareOptionsMenu()
            SubMenu sub = menu.addSubMenu(0, ADD_TO_PLAYLIST, 0,
                    R.string.add_to_playlist).setIcon(android.R.drawable.ic_menu_add);
            MusicUtils.makePlaylistMenu(this, sub);
            menu.add(0, USE_AS_RINGTONE, 0, R.string.ringtone_menu_short).setIcon(R.drawable.ic_menu_set_as_ringtone);
            menu.add(0, DELETE_ITEM, 0, R.string.delete_item).setIcon(R.drawable.ic_menu_delete);

            /**
             * Add menu for sending media file over Bluetooth
             */
            sub = menu.addSubMenu(MENU_GROUP_BT, 0 , 0,
                    R.string.menu_share).setIcon(android.R.drawable.ic_menu_share);
            sub.add(MENU_GROUP_BT,MENU_ITEM_SEND_BT,0, R.string.menu_send_bt);

            boolean bluetoothEnabled = false;
            if (mBluetooth != null) {
               bluetoothEnabled = mBluetooth.isEnabled();
            }
            menu.setGroupEnabled(MENU_GROUP_BT, bluetoothEnabled);
            menu.setGroupVisible(MENU_GROUP_BT, bluetoothEnabled);
            return true;
        }
        return false;
    }

