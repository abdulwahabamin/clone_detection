    public SuggestionAdapter(Weather.SuggestionEntity data) {
        mIcon.add(R.drawable.ic_suggestion_comfort);
        mTitle.add("舒适度");
        mData.add(data.comf);
        mIcon.add(R.drawable.ic_suggestion_clothe);
        mTitle.add("穿衣");
        mData.add(data.drsg);
        mIcon.add(R.drawable.ic_suggestion_flu);
        mTitle.add("感冒");
        mData.add(data.flu);
        mIcon.add(R.drawable.ic_suggestion_car);
        mTitle.add("洗车");
        mData.add(data.cw);
        mIcon.add(R.drawable.ic_suggestion_sport);
        mTitle.add("�?动");
        mData.add(data.sport);
        mIcon.add(R.drawable.ic_suggestion_travel);
        mTitle.add("旅游");
        mData.add(data.trav);
        mIcon.add(R.drawable.ic_suggestion_uv);
        mTitle.add("紫外线");
        mData.add(data.uv);
    }

