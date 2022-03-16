        public void onClick(View v) {
            if (mService == null) return;
            try {
                if (mService.position() < 2000) {
                    mService.prev();
                } else {
                    mService.seek(0);
                    mService.play();
                }
            } catch (RemoteException ex) {
            }
        }

