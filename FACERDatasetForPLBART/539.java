    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (groupInfoList == null || groupInfoList.get(groupPosition) == null
                || groupInfoList.get(groupPosition).getFriendList() == null
                || groupInfoList.get(groupPosition).getFriendList().get(childPosition) == null) {
            return null;
        }
        FriendViewHolder friendViewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_friend_info, null);
            friendViewHolder = new FriendViewHolder();
            friendViewHolder.iconIv = (ImageView) convertView.findViewById(R.id.item_friend_icon);
            friendViewHolder.nameTv = (TextView) convertView.findViewById(R.id.item_friend_name);
            friendViewHolder.addressTv = (TextView) convertView.findViewById(R.id.item_friend_address);
            friendViewHolder.statusTv = (TextView) convertView.findViewById(R.id.item_friend_status);
            convertView.setTag(friendViewHolder);
        } else{
            friendViewHolder = (FriendViewHolder) convertView.getTag();
        }
        FriendInfo friendInfo = groupInfoList.get(groupPosition).getFriendList().get(childPosition);
        friendViewHolder.nameTv.setText(friendInfo.getFriendNickName()+"("+friendInfo.getIdentificationName()+")");
        friendViewHolder.addressTv.setText(friendInfo.getDeviceAddress());
        if(friendInfo.isOnline()){
            friendViewHolder.statusTv.setText(context.getString(R.string.device_online));
        } else{
            friendViewHolder.statusTv.setText(context.getString(R.string.device_offline));
        }
        return convertView;
    }

