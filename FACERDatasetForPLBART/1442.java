        private void sendViaLoop(){
            int iMtu = BLECentralHelper.getInstance().getMtu();
            long startTime = System.currentTimeMillis();
            for(int iBytesSent = 0;!mEnd && iBytesSent < 1024 * 1024 ; iBytesSent += iMtu ) {
                processOutgoingMsg("/transfer");
                updateProgressBar(iBytesSent);
            }
            long difference = (System.currentTimeMillis() - startTime) / 1000;
            showInfo("1 MB took " + difference + " secs to complete");
        }

