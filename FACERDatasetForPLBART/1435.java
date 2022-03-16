    /**
     * Tries to connect to a RFCOMMSocket to achieve high-throughput transfer rates
     *
     */
    private void transferData(){
        if(mBleMode == BLEMode.PERIPHERAL ) {
            // 1st - unleash RFCOMM Socket machinery...
            BLEPeripheralHelper.getInstance().initRfcommService();
            showInfo("Initializing RFCOMM socket...");
        }
    }

