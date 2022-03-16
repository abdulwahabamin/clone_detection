        public void onProgressChanged(SeekBar bar, int progress, boolean fromuser) {
            if (!fromuser || (service == null)) return;
            long now = SystemClock.elapsedRealtime();
            if ((now - lastSeekEventTime) > 250) {
                lastSeekEventTime = now;
                posOverride = service.duration() * progress / 1000;
                service.seek(posOverride);

                // trackball event, allow progress updates
                if (!fromTouch) {
                    refreshNow();
                    posOverride = -1;
                }
            }
        }

