    private void ReName(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        final EditText userId = new EditText(mContext);
        userId.setHint("注�?请加上文件�?�缀�??，例如:.mp4");
        builder.setTitle("请输入新命�??：")
                .setCancelable(false)
                .setNegativeButton("�?�消", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String newName = userId.getText().toString().trim();
                        if (newName.equals("")) {
                            Toast.makeText(mContext, "输入�?能为空", Toast.LENGTH_SHORT).show();
                        } else {
                            //�?命�??File
                            FileUtils.rename(mDatas.get(position), newName );

                            //更新显示数�?�
                            String path = mDatas.get(position).getParent();
                            File file = new File(path + "/" + newName);
                            mDatas.remove(position);
                            mDatas.add(position, file);
                            notifyDataSetChanged();
                            Toast.makeText(mContext, "�?命�??文件�?功", Toast.LENGTH_SHORT).show();


                        }
                    }
                })
                .setView(userId, 150, 20, 70, 20)
                .show();
    }

