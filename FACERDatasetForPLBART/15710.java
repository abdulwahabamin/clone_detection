            @Override
            public void onClick(View view) {
                int granted = ContextCompat.checkSelfPermission(mParentActivity, Manifest.permission.READ_EXTERNAL_STORAGE);
                if (granted != PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted
                    Log.v("Files","permission not granted");
                }
                SongContent.SongItem item = (SongContent.SongItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);

                    context.startActivity(intent);
                }
            }

