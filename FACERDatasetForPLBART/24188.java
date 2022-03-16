    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == myKeyCode) {
            return performClick();
        }
        return super.onKeyDown(keyCode, event);
    }

