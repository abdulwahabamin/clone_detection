    /**
     * 当所有的刷新逻辑完�?以�?�，记�?�调用一下
     */
    public void finishRefreshing(){
        mProgressBar.setVisibility(View.INVISIBLE);
        if(mSpf.getString("update_flag","false").equals("true")) {
            Date dt = new Date();
            DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
            mSpf.edit().putString(LAST_UPDATED_AT, df.format(dt)).apply();
            description.setText("数�?�更新�?功");
            updateIndicationImage.setImageResource(R.drawable.update_success);
            updateIndicationImage.setVisibility(View.VISIBLE);
            refreshUpdatedAtValue();
        }
        else{
            description.setText("数�?�更新失败");
            updateIndicationImage.setImageResource(R.drawable.update_fail);
            updateIndicationImage.setVisibility(View.VISIBLE);
        }
        new HideHeaderTask().execute();
    }

