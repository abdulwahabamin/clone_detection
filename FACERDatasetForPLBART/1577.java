    public void setData(List<BluetoothDevice> device){
       if (device != null){
           this.allPairedDevices = device;
           notifyDataSetChanged();
       }
       else{
           this.allPairedDevices = null;
           notifyDataSetChanged();

       }

    }

