    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_MENU:
                showOverflowPopUp(this.mOptionsAnchorView);
                return true;
            case KeyEvent.KEYCODE_BACK:
                checkDirtyState();
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

