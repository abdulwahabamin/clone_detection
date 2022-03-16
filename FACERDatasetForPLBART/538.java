    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (groupInfoList == null || groupInfoList.get(groupPosition) == null) {
            return null;
        }
        GroupViewHolder groupViewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_group_info, null);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.nameTv = (TextView) convertView.findViewById(R.id.item_group_name);
            groupViewHolder.iconIv = (ImageView) convertView.findViewById(R.id.item_group_icon);
            convertView.setTag(groupViewHolder);
        } else{
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        GroupInfo groupInfo = groupInfoList.get(groupPosition);
        List<FriendInfo> friendInfoList = groupInfo.getFriendList();
        if(friendInfoList != null && friendInfoList.size() > 0){
            groupViewHolder.nameTv.setText(groupInfo.getGroupName() +"("+groupInfo.getOnlineNumber()+"/" +groupInfo.getFriendList().size()+")");
        } else{
            groupViewHolder.nameTv.setText(groupInfo.getGroupName()+"(0/0)");
        }
        return convertView;
    }

