    @Override
    protected void onPostExecute(ArrayList<File> data) {
        tv.setText("扫�??完�?，共扫�??文件：" + filenum + "个");
        fileAdapter.setfiledata(data);
        //
        fileAdapter.notifyDataSetChanged();

    }

