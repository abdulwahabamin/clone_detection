        private void doRemove() {
            final File file = filedata.get(position);
            judgeAlertDialog(context, "�??醒", "你确认删除" + file.getName() + "�?�？", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    deleteDir(file);
                    filedata.remove(file);
                    notifyDataSetChanged();
                    showToast(file.getName()+"删除�?功");
                }
            },null);
        }

