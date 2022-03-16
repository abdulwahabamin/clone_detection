    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (groupInfoList == null || groupInfoList.size() == 0) {
            return null;
        }
        return groupInfoList.get(groupPosition).getFriendList().get(childPosition);
    }

