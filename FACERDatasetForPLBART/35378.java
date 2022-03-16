    @Override
    public void initEvent() {
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.feedback:
                        AlertDialog.Builder dialogBuilder;
                        if (MyApplication.nightMode2()){
                           dialogBuilder  = new AlertDialog.Builder(MainActivity.this, R.style.NightDialog);
                        }else{
                            dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        }
                       dialogBuilder.setTitle("�??馈").setMessage("在使用过程中，有任何问题�?��?�以�?��?到邮箱：byhieg@gmail.com").setPositiveButton("�?�", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                        break;

                    case R.id.location:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED||
                                    checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                                    checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                                LogUtils.e("Permissions","还是没有�?��?啊");
                                // 申请一个（或多个）�?��?，并�??供用于回调返回的获�?��?（用户定义)
                                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE,
                                        Manifest.permission.ACCESS_COARSE_LOCATION,
                                        Manifest.permission.ACCESS_FINE_LOCATION,
                                        Manifest.permission.ACCESS_WIFI_STATE,
                                        Manifest.permission.ACCESS_NETWORK_STATE,
                                        Manifest.permission.CHANGE_WIFI_STATE,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, Constants.PERMISSION);
                            }else{
                                mHomePresenter.doBaiduLocation();
                                LogUtils.e("Permissions","已�?有�?��?了");
                            }
                        }else{
                            mHomePresenter.doBaiduLocation();
                        }

                        break;

                    case R.id.like:
                        startActivity(LoveAppActivity.class);
                        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                        break;
                    case R.id.add_city:
                        startActivity(CityManageActivity.class);
                        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                        break;
                }
                return true;
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int position = 0;
                switch (menuItem.getItemId()) {
                    case R.id.trending:
                        break;
                    case R.id.setting:
                        position = 1;
                        break;
                    case R.id.share:
                        position = 2;
                        break;
                    case R.id.help:
                        position = 3;
                        break;
                    case R.id.lab:
                        position = 4;
                        break;
                    case R.id.wiki:
                        position = 5;
                        break;
                    case R.id.more:
                        position = 6;
                        break;
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                Intent intent = new Intent(getApplicationContext(), SlideMenuActivity.class);
                intent.putExtra("itemId", position);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                return true;
            }
        });

        EventBus.getDefault().register(this);
    }

