    /**
     * 刷新下拉头中上次更新时间的文字�??述.
     */
    private void refreshUpdatedAtValue(){
        String tmp=mSpf.getString(LAST_UPDATED_AT,"");
        if("".equals(tmp)){
            updateAt.setText("暂未更新过");
        }
        else{
            tmp="上次更新于："+tmp;
            updateAt.setText(tmp);
        }

    }

