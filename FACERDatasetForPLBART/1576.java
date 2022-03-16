    @Override
    public int getItemCount() {
        if ( allPairedDevices != null){
            return allPairedDevices.size();
        }
        return 0;
    }

