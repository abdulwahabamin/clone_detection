    public void setData(List<? extends BaseAdapterData> data) {
        if (Check.isEmpty(data)) {
            return;
        }
        mData.clear();
        addData(data);
    }

