    @Override
    public Object getGroup(int groupPosition) {
        if (groupInfoList == null || groupInfoList.size() == 0) {
            return null;
        }
        return groupInfoList.get(groupPosition);
    }

