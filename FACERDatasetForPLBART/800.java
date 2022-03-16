    public CustomAdapterScan(ArrayList<BlueToothDeviceModel> data, Context context) {
        super(context, R.layout.list_item_for_scan_list, data);
        this.dataSet = data;
        this.mContext=context;

    }

