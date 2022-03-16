    /**
     * Method that opens the associated intent.
     *
     * @param ri The resolve information
     * @param intent The user selection
     * @param remember If the user selection, must be remembered
     * @see ResolverActivity (copied from)
     * @hide
     */
    @SuppressWarnings({"deprecation"})
    void onIntentSelected(ResolveInfo ri, Intent intent, boolean remember) {

        boolean isPlatformSigned = AndroidHelper.isAppPlatformSignature(this.mContext);

        // Register preferred association is only allowed by platform signature
        // The app will be signed with this signature, but when is launch from
        // inside ADT, the app is signed with testkey.
        if (isPlatformSigned && this.mAllowPreferred) {

            PackageManager pm = this.mContext.getPackageManager();

            // Remove preferred application if user don't want to remember it
            if (this.mPreferred != null && !remember) {
                pm.clearPackagePreferredActivities(
                        this.mPreferred.activityInfo.packageName);
            }

            // Associate the activity under these circumstances:
            //  - The user has selected the remember option
            //  - The selected intent is not an internal editor (internal editors are private and
            //    can be associated)
            //  - The selected intent is not the current preferred selection
            if (remember && !IntentsActionPolicy.isInternalEditor(ri) && !isPreferredSelected()) {

                // Build a reasonable intent filter, based on what matched.
                IntentFilter filter = new IntentFilter();

                if (intent.getAction() != null) {
                    filter.addAction(intent.getAction());
                }
                Set<String> categories = intent.getCategories();
                if (categories != null) {
                    for (String cat : categories) {
                        filter.addCategory(cat);
                    }
                }
                filter.addCategory(Intent.CATEGORY_DEFAULT);

                int cat = ri.match & IntentFilter.MATCH_CATEGORY_MASK;
                Uri data = intent.getData();
                if (cat == IntentFilter.MATCH_CATEGORY_TYPE) {
                    String mimeType = intent.resolveType(this.mContext);
                    if (mimeType != null) {
                        try {
                            filter.addDataType(mimeType);
                        } catch (IntentFilter.MalformedMimeTypeException e) {
                            Log.w(TAG, e);
                            filter = null;
                        }
                    }
                }
                if (data != null && data.getScheme() != null && filter != null) {
                    // We need the data specification if there was no type,
                    // OR if the scheme is not one of our magical "file:"
                    // or "content:" schemes (see IntentFilter for the reason).
                    if (cat != IntentFilter.MATCH_CATEGORY_TYPE
                            || (!"file".equals(data.getScheme()) //$NON-NLS-1$
                                    && !"content".equals(data.getScheme()))) { //$NON-NLS-1$
                        filter.addDataScheme(data.getScheme());

                        // Look through the resolved filter to determine which part
                        // of it matched the original Intent.
                        // ri.filter should not be null here because the activity matches a filter
                        // Anyway protect the access
                        if (ri.filter != null) {
                            Iterator<IntentFilter.AuthorityEntry> aIt =
                                                        ri.filter.authoritiesIterator();
                            if (aIt != null) {
                                while (aIt.hasNext()) {
                                    IntentFilter.AuthorityEntry a = aIt.next();
                                    if (a.match(data) >= 0) {
                                        int port = a.getPort();
                                        filter.addDataAuthority(a.getHost(),
                                                port >= 0 ? Integer.toString(port) : null);
                                        break;
                                    }
                                }
                            }
                            Iterator<PatternMatcher> pIt = ri.filter.pathsIterator();
                            if (pIt != null) {
                                String path = data.getPath();
                                while (path != null && pIt.hasNext()) {
                                    PatternMatcher p = pIt.next();
                                    if (p.match(path)) {
                                        filter.addDataPath(p.getPath(), p.getType());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                // If we don't have a filter then don't try to associate
                if (filter != null) {
                    try {
                        AssociationsAdapter adapter =
                                (AssociationsAdapter)this.mGrid.getAdapter();
                        final int cc = adapter.getCount();
                        ComponentName[] set = new ComponentName[cc];
                        int bestMatch = 0;
                        for (int i = 0; i < cc; i++) {
                            ResolveInfo r = adapter.getItem(i);
                            set[i] = new ComponentName(
                                    r.activityInfo.packageName, r.activityInfo.name);
                            // Use the match of the selected intent
                            if (intent.getComponent().compareTo(set[i]) == 0) {
                                bestMatch = r.match;
                            }
                        }

                        // The only way i found to ensure of the use of the preferred activity
                        // selected is to clear preferred activity associations
                        if (this.mPreferred != null) {
                            pm.clearPackagePreferredActivities(
                                    this.mPreferred.activityInfo.packageName);
                        }

                        // This is allowed for now in AOSP, but probably in the future this will
                        // not work at all
                        pm.addPreferredActivity(filter, bestMatch, set, intent.getComponent());

                    } catch (Exception e) {
                        // Capture the exception
                        ExceptionUtil.translateException(this.mContext, e, true, false);
                        DialogHelper.showToast(
                                this.mContext,
                                R.string.msgs_action_association_failed,
                                Toast.LENGTH_SHORT);
                    }
                }
            }
        }

        if (intent != null) {
            // Capture security exceptions
            try {
                mContext.startActivity(intent);
            } catch (Exception e) {
                ExceptionUtil.translateException(this.mContext, e);
            }
        }
    }

