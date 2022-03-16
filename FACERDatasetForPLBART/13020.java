    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.FLAG_EDITOR_ACTION:
                //Consume the event
                doDone(false);
                return true;
            case KeyEvent.KEYCODE_TAB:
                //Do tab, and consume the event
                doTab();
                return true;
            default:
                break;
        }
        return false;
    }

