    public void unregisterSeekListener(SeekListener listener) {
        if(seekListenerList.size() == 1) {
            stopSeekMonitor();
        }
        seekListenerList.remove(listener);
    }

