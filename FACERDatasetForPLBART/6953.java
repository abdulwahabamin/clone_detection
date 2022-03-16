    @Override
    protected void onProgressUpdate(Integer... values) {
        int v = values[0];
        tv.setText("已扫�??文件数：" + v);
        fileAdapter.notifyDataSetChanged();
    }

