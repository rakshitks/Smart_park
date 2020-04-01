<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="com.google.firebase.firestore" >

    <uses-sdk
        android:minSdkVersion="14"
        android:targetSdkVersion="26" />

    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />

    <application>
        <service android:name="com.google.firebase.components.ComponentDiscoveryService" >
            <meta-data
                android:name="com.google.firebase.components:com.google.firebase.firestore.FirestoreRegistrar"
                android:value="com.google.firebase.components.ComponentRegistrar" />
        </service>
    </application>

</manifest>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              