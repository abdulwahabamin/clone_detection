    private void scanForward(int repcnt, long delta) {
        if(service == null) return;
        if(repcnt == 0) {
            startSeekPos = service.position();
            lastSeekEventTime = 0;
        } else {
            if (delta < 5000) {
                // seek at 10x speed for the first 5 seconds
                delta = delta * 10;
            } else {
                // seek at 40x after that
                delta = 50000 + (delta - 5000) * 40;
            }
            long newpos = startSeekPos + delta;
            long duration = service.duration();
            if (newpos >= duration) {
                // move to next track
                service.next();
                startSeekPos -= duration; // is OK to go negative
                newpos -= duration;
            }
            if (((delta - lastSeekEventTime) > 250) || repcnt < 0){
                service.seek(newpos);
                lastSeekEventTime = delta;
            }
            if (repcnt >= 0) {
                posOverride = newpos;
            } else {
                posOverride = -1;
            }
            refreshNow();
        }
    }

