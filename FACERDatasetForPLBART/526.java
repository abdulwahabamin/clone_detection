    @Override
    public void HelpConvert(HelperViewHolder viewHolder, int position, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return;
        }
        ImageView iconIv = viewHolder.getView(R.id.item_friend_icon);
        TextView nameTv = viewHolder.getView(R.id.item_friend_name);
        TextView addressTv = viewHolder.getView(R.id.item_friend_address);
        TextView statusTv = viewHolder.getView(R.id.item_friend_status);
        iconIv.setVisibility(View.GONE);
        statusTv.setVisibility(View.GONE);
        if(!StringUtil.isNullOrEmpty(bluetoothDevice.getName())){
            nameTv.setText(bluetoothDevice.getName());
        } else{
            nameTv.setText(mContext.getString(R.string.device_unknown));
        }
        addressTv.setText(bluetoothDevice.getAddress());
    }

