    private void ReName(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        final EditText userId = new EditText(mContext);
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
                            FileUtils.rename(mDatas.get(position), newName + ".mp3");

                            //更新显示数�?�
                            String path = mDatas.get(position).getParent();
                            File file = new File(path + "/" + newName + ".mp3");
                            mDatas.remove(position);
                            mDatas.add(position, file);
                            notifyDataSetChanged();
                            Toast.makeText(mContext, "�?命�??文件�?功", Toast.LENGTH_SHORT).show();

                            //更新缓存
                            String s = String.valueOf(position);
                            String name = "{\"path\":\"" + file.getAbsolutePath() + "\"}";
                            mCache.put(s + "music", name);

                        }
                    }
                })
                .setView(userId, 150, 20, 70, 20)
                .show();
    }

