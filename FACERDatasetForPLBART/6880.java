    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            KEYCODE_BACK_PRESSED_QTY++;
            if (KEYCODE_BACK_PRESSED_QTY == 2) {
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(50);
                Snackbar.make(findViewById(android.R.id.content), "Press 1 more time to exit...", Snackbar.LENGTH_SHORT).show();
            } else if (KEYCODE_BACK_PRESSED_QTY == 3) {
                KEYCODE_BACK_PRESSED_QTY = 0;
                openQuitDialog();
            }
            if (!current_path.equals(Environment.getExternalStorageDirectory().getPath())) {
                KEYCODE_BACK_PRESSED_QTY--;
                current_path = current_path.substring(0, current_path.lastIndexOf("/"));
                updateList();
            }
        } else if (keyCode == KeyEvent.KEYCODE_MENU)
        {
            switchWindows();
        }
        return true;
    }

