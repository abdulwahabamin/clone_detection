    @Override
    public int getChildrenCount(int groupPosition) {
        if (groupInfoList == null || groupInfoList.size() == 0) {
            return 0;
        }
        return groupInfoList.get(groupPosition).getFriendList().size();
    }

