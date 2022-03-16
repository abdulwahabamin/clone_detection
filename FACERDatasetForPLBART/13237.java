    /**
     * Method that check if the app is signed with the platform signature
     *
     * @param ctx The current context
     * @return boolean If the app is signed with the platform signature
     */
    public static boolean isAppPlatformSignature(Context ctx) {
        if (sIsAppPlatformSigned == null) {
            try {
                // First check that the app is installed as a system app
                PackageManager pm = ctx.getPackageManager();
                ApplicationInfo ai = pm.getApplicationInfo(ctx.getPackageName(),
                        PackageManager.GET_SIGNATURES);
                if ((ai.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                    sIsAppPlatformSigned = Boolean.FALSE;
                } else {
                    final MessageDigest sha1 = MessageDigest.getInstance("SHA1");
                    final CertificateFactory cf = CertificateFactory.getInstance("X.509");

                    // Get signature of the current package
                    PackageInfo info = pm.getPackageInfo(ctx.getPackageName(),
                            PackageManager.GET_SIGNATURES);
                    Signature[] signatures = info.signatures;
                    X509Certificate cert = (X509Certificate) cf.generateCertificate(
                            new ByteArrayInputStream(signatures[0].toByteArray()));
                    sha1.update(cert.getEncoded());
                    String appHash = HexDump.toHexString(sha1.digest());

                    // Get the signature of the system package
                    info = pm.getPackageInfo("android",
                            PackageManager.GET_SIGNATURES);
                    signatures = info.signatures;
                    cert = (X509Certificate) cf.generateCertificate(
                            new ByteArrayInputStream(signatures[0].toByteArray()));
                    sha1.update(cert.getEncoded());
                    String systemHash = HexDump.toHexString(sha1.digest());

                    // Is platform signed?
                    sIsAppPlatformSigned = appHash.equals(systemHash);
                }

            } catch (NameNotFoundException e) {
                sIsAppPlatformSigned = Boolean.FALSE;
            } catch (GeneralSecurityException e) {
                sIsAppPlatformSigned = Boolean.FALSE;
            }
        }
        return sIsAppPlatformSigned.booleanValue();
    }

