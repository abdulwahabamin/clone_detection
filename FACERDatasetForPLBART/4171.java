        public View getView(int position, View convertView, ViewGroup parent) {
            bGridViewImage imageView;
            //ImageView chkImg;
            RelativeLayout lay;
            if (convertView == null) {
                lay=new RelativeLayout(activity);


                lay.setGravity(Gravity.CENTER_HORIZONTAL| Gravity.CENTER_VERTICAL);
                lay.setLayoutParams(param);


            } else {
                lay=(RelativeLayout) convertView;
                lay.removeAllViews();
            }

            imageView = new bGridViewImage(activity);
            imageView.setId(R.id.file_images_image_view_id);
            //imageView = new ImageView(activity);

            //chkImg = new ImageView(activity);
            //chkImg.setId(R.id.file_images_image_check_id);
            //chkImg.setLayoutParams(laycheck);
            //chkImg.setPadding(10,10,15,10);
            //chkImg.

            FileItem f= items.get(position).getAsFileItem();


            if(f!=null) {
                //chkImg.setVisibility(View.VISIBLE);
                //if(f.getAbsoluteFile().isDirectory())
                //    chkImg.setVisibility(View.GONE);
                //imageView.setTag(f.getPath());
                //chkImg.setTag(""+position);
                lay.setTag("" + position);
                RelativeLayout rel=new RelativeLayout(activity);
                rel.setLayoutParams(txtppod);
                rel.setPadding(0, txtItemPadTop, 0, 0);

                TextView txt = new TextView(activity);
                txt.setLayoutParams(txtparams);
                txt.setText(Sf.shortenText(f.getName(), 26));

                txt.setBackgroundColor(activity.getResources().getColor(R.color.black_alpha_strong));
                txt.setTextColor(activity.getResources().getColor(R.color.grey));
                txt.setPadding(8, 2, 4, 8);
                //txt.setGravity(Gravity.CENTER_HORIZONTAL);
                txt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);



                rel.setId(R.id.file_images_text_view_id);
                rel.addView(txt);

                //imageView.setImageBitmap(null);
                //imageView.setImageDrawable(null);
                if(Files.isImage(Files.removeBriefFileExtension(f.getName()))) {
                    imageView.setImageDrawable(f,imgWidth,imgHeight);

                } else {
                    //FileItem fi= fm.getDirectoryItem(position);
                    imageView.setImageDrawable(activity.getResources().getDrawable(f.icon));
                    imageView.setLayoutParams(new GridView.LayoutParams(imgWidth, imgHeight));
                    //imageView.setImageLayoutParams(100,100);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setPadding(8, 8, 8, 8);
                }

                lay.addView(imageView);
                //lay.addView(chkImg);
                lay.addView(rel);

                View.OnClickListener lastItemListner = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = Sf.toInt(view.getTag().toString());
                        IndexerFile item = items.get(pos);
                        FileManagerDisk fm = new FileManagerDisk();
                        fm.setCurrentDirectory(activity, item.getString(IndexerFile.STRING_FILEPATH));
                        fm.readDirectory(activity);
                        File f =  item.getAsFileItem();
                        if(f.exists()) {
                            if (Files.isImage(Files.removeBriefFileExtension(item.getString(IndexerFile.STRING_FILENAME)))) {

                                List<FileItem> its = new ArrayList<FileItem>();
                                its.add(item.getAsFileItem());
                                FileManagerList fml = new FileManagerList(its);
                                fml.setStartAtPosition(0);
                                State.addCachedFileManager(fml);
                                Bgo.openFragmentBackStack(activity, new ImagesSliderFragment());

                            } else if (Files.isTextFile(item.getString(IndexerFile.STRING_FILENAME))) {
                                State.addCachedFileManager(fm);
                                State.addToState(State.SECTION_TEXT_FILE_VIEW, new StateObject(StateObject.STRING_FILE_PATH, f.getAbsolutePath()));
                                Bgo.openFragmentBackStack(activity, new TextFileFragment());
                            } else {
                                if (Files.removeBriefFileExtension(f.getName()).endsWith(".zip")) {

                                    FileManagerZip fmz = new FileManagerZip(f.getAbsolutePath());
                                    State.addCachedFileManager(fmz);
                                    Bgo.openFragmentBackStack(activity, new ZipExploreFragment());

                                } else {
                                    Device.openAndroidFile(activity, f);
                                }
                            }
                        }

                        if (mDrawerLayout != null) {
                            mDrawerLayout.closeDrawer(mFragmentContainerView);
                        }
                    }
                };
                lay.setOnClickListener(lastItemListner);

            }

            return lay;
        }

