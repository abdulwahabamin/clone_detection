    private void scanBackward(int repcnt, long delta) {
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
            long newpos = startSeekPos - delta;
            if (newpos < 0) {
                // move to previous track
                service.previous();
                long duration = service.duration();
                startSeekPos += duration;
                newpos += duration;
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

