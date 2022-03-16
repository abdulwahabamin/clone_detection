        public RootsAdapter(Context context, Collection<RootInfo> roots, Intent includeApps) {
            super(context, 0);

            RootItem recents = null;
            RootItem images = null;
            RootItem videos = null;
            RootItem audio = null;
            RootItem downloads = null;

            final List<RootInfo> clouds = Lists.newArrayList();
            final List<RootInfo> locals = Lists.newArrayList();

            for (RootInfo root : roots) {
                if (root.isRecents()) {
                    recents = new RootItem(root);
                } else if (root.isExternalStorage()) {
                    locals.add(root);
                } else if (root.isDownloads()) {
                    downloads = new RootItem(root);
                } else if (root.isImages()) {
                    images = new RootItem(root);
                } else if (root.isVideos()) {
                    videos = new RootItem(root);
                } else if (root.isAudio()) {
                    audio = new RootItem(root);
                } else {
                    clouds.add(root);
                }
            }

            final RootComparator comp = new RootComparator();
            Collections.sort(clouds, comp);
            Collections.sort(locals, comp);

            if (recents != null) add(recents);

            for (RootInfo cloud : clouds) {
                add(new RootItem(cloud));
            }

            if (images != null) add(images);
            if (videos != null) add(videos);
            if (audio != null) add(audio);
            if (downloads != null) add(downloads);

            for (RootInfo local : locals) {
                add(new RootItem(local));
            }

            if (includeApps != null) {
                final PackageManager pm = context.getPackageManager();
                final List<ResolveInfo> infos = pm.queryIntentActivities(
                        includeApps, PackageManager.MATCH_DEFAULT_ONLY);

                final List<AppItem> apps = Lists.newArrayList();

                // Omit ourselves from the list
                for (ResolveInfo info : infos) {
                    if (!context.getPackageName().equals(info.activityInfo.packageName)) {
                        apps.add(new AppItem(info));
                    }
                }

                if (apps.size() > 0) {
                    add(new SpacerItem());
                    for (Item item : apps) {
                        add(item);
                    }
                }
            }
        }

