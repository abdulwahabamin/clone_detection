    private void updateRepeatItem(Menu menu) {
        MenuItem item = menu.findItem(R.id.repeat);
        if (item != null) {
            if (service != null) {
                switch (service.getRepeatMode()) {
                    case MediaPlayback.REPEAT_ALL:
                        item.setIcon(R.drawable.ic_mp_repeat_all_btn);
                        break;
                    case MediaPlayback.REPEAT_CURRENT:
                        item.setIcon(R.drawable.ic_mp_repeat_once_btn);
                        break;
                    case MediaPlayback.REPEAT_STOPAFTER:
                        item.setIcon(R.drawable.ic_mp_repeat_stopafter_btn);
                        break;
                    default:
                        item.setIcon(R.drawable.ic_mp_repeat_off_btn);
                        break;
                }
            } else {
                item.setIcon(R.drawable.ic_mp_repeat_off_btn);
            }
        }
    }

