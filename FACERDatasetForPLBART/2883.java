    @Override
    public void onClick(View v) {
        final Intent intent = new Intent();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (v.getId()) {
            case R.id.name_search:
                final EditText userId = new EditText(this);
                userId.setHint("请输入关键字");
                userId.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
                builder.setTitle("请输入文件�??：")
                        .setCancelable(false)
                        .setNegativeButton("�?�消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String FileName = userId.getText().toString().trim();
                                if (FileName.equals("")) {
                                    Toast.makeText(FileActivity.this, "输入�?能为空", Toast.LENGTH_SHORT).show();
                                } else {
                                    Intent intent = new Intent(FileActivity.this, ShowActivity.class);
                                    intent.putExtra("class", "filename");
                                    intent.putExtra("filename",FileName);
                                    startActivity(intent);
                                }
                            }
                        })
                        .setView(userId, 150, 17, 70, 20)
                        .show();
                materialSheetFab.hideSheet();
                break;
            case R.id.type_search:
                final EditText type_id = new EditText(this);
                type_id.setHint("例如:mp4");
                type_id.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
                builder.setTitle("请输入文件类型：")
                        .setCancelable(false)
                        .setNegativeButton("�?�消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String FileType = type_id.getText().toString().trim();
                                if (FileType.equals("")) {
                                    Toast.makeText(FileActivity.this, "输入�?能为空", Toast.LENGTH_SHORT).show();
                                } else {
                                    Intent intent = new Intent(FileActivity.this, ShowActivity.class);
                                    intent.putExtra("class", "filetype");
                                    intent.putExtra("filetype",FileType);
                                    startActivity(intent);
                                }
                            }
                        })
                        .setView(type_id, 150, 17, 70, 20)
                        .show();
                materialSheetFab.hideSheet();
                break;
            case R.id.file_image:
                intent.setClass(this, ShowActivity.class);
                intent.putExtra("class", "image");
                startActivity(intent);
                break;
            case R.id.file_music:
                intent.setClass(this, ShowActivity.class);
                intent.putExtra("class", "music");
                startActivity(intent);
                break;
            case R.id.file_video:
                intent.setClass(this, ShowActivity.class);
                intent.putExtra("class", "video");
                startActivity(intent);
                break;
            case R.id.file_word:
                intent.setClass(this, ShowActivity.class);
                intent.putExtra("class", "word");
                startActivity(intent);
                break;
            case R.id.file_apk:
                intent.setClass(this, ShowActivity.class);
                intent.putExtra("class", "apk");
                startActivity(intent);
                break;
            case R.id.file_zip:
                intent.setClass(this, ShowActivity.class);
                intent.putExtra("class", "zip");
                startActivity(intent);
                break;
            case R.id.file_bottom:
                intent.setClass(this, MemoryActivity.class);
                intent.putExtra("total", mToalS);
                intent.putExtra("free", mFreeS);
                startActivity(intent);
                break;
            case R.id.menu_clear:
                ACache mCatch = ACache.get(FileActivity.this);
                mCatch.clear();
                SharedPreferences table = getSharedPreferences("table", MODE_PRIVATE);
                SharedPreferences.Editor edit = table.edit();
                edit.putBoolean("firstImage", true);
                edit.putBoolean("firstMusic", true);
                edit.putBoolean("firstVideo", true);
                edit.putBoolean("firstWord", true);
                edit.putBoolean("firstApk", true);
                edit.putBoolean("firstZip", true);
                edit.apply();
                Toast.makeText(this, "清�?�缓存�?功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_check:
                Toast.makeText(this, "已�?是最新版本", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_about:
                startActivity(new Intent(FileActivity.this, AboutActivity.class));
                break;
            case R.id.menu_quit:
                finish();
                break;
            case R.id.menu_title:
                Toast.makeText(this, "别瞎点，我�?�是一排文字。", Toast.LENGTH_SHORT).show();
                break;
        }
    }

