    @Override
    public void onBindViewHolder(final AlbumAdapter.MyViewHolder holder, final int position) {
       final Album album = albumList.get(position);
       ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        permissionStatus = context.getSharedPreferences("permissionStatus",MODE_PRIVATE);
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
       //        if (holder.imageLoader == null)
//            holder.imageLoader = AppController.getInstance().getImageLoader();
//        holder.thumbnail.setImageUrl(album.getFlag(),holder.imageLoader);
        holder.gl.setText(album.getSong());
        holder.g2.setText("Artists: "+album.getArtists());
        name=album.getUrl();
        song=album.getSong();
        Glide.with(context).load(album.getCover_image()).into(holder.imageView);

        buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.options_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                final Album album2 = albumList.get(position);

                                Intent intent=new Intent(context,Main2Activity.class);
                                intent.putExtra("url",album2.getUrl());
                                intent.putExtra("image",album2.getCover_image());
                                intent.putExtra("song",album2.getSong());
                                intent.putExtra("artists",album2.getArtists());
                                context.startActivity(intent);
                                break;
                            case R.id.menu2:
                                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                                        //Show Information about why you need the permission
                                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                        builder.setTitle("Need Storage Permission");
                                        builder.setMessage("This app needs storage permission.");
                                        builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CONSTANT);
                                            }
                                        });
                                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                        builder.show();
                                    } else if (permissionStatus.getBoolean(Manifest.permission.WRITE_EXTERNAL_STORAGE,false)) {
                                        //Previously Permission Request was cancelled with 'Dont Ask Again',
                                        // Redirect to Settings after showing Information about why you need the permission
                                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                        builder.setTitle("Need Storage Permission");
                                        builder.setMessage("This app needs storage permission.");
                                        builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                                sentToSettings = true;
                                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                                                intent.setData(uri);
                                                ((Activity)context).startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                                                Toast.makeText(context, "Go to Permissions to Grant Storage", Toast.LENGTH_LONG).show();
                                            }
                                        });
                                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                        builder.show();
                                    }
                                    else {
                                        //just request the permission
                                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CONSTANT);
                                    }


                                    SharedPreferences.Editor editor = permissionStatus.edit();
                                    editor.putBoolean(Manifest.permission.WRITE_EXTERNAL_STORAGE,true);
                                    editor.commit();




                                } else {
                                    //You already have the permission, just go ahead.
                                    proceedAfterPermission();
                                }

                              break;

                            case R.id.menu3:
                                try {
                                    Intent i = new Intent(Intent.ACTION_SEND);
                                    i.setType("text/plain");

                                    i.putExtra(Intent.EXTRA_TEXT, album.getUrl());
                                    context.startActivity(Intent.createChooser(i, "Choose one"));
                                } catch(Exception e) {
                                    //e.toString();
                                }

                                break;
                    }

                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });



    }

