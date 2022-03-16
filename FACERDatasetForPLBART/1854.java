    public SearchAdapter(List<BluetoothDevice> devices, List<Boolean> states, ItemClickListener listener, Context context) {
        this.devices = devices;
        this.listener = listener;
        this.states=states;
        this.context=context;
    }

