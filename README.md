# SharePanel
[![API](https://img.shields.io/badge/API-15%2B-orange.svg)](https://developer.android.com/about/versions/android-4.0.3.html)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)]()

A small library to show share buttons panel with coordinatorLayout with behaviour
Library supports OS on API 15 and above.

![Showcase Video](demo.gif)

Try APK : [Download](demo.apk)

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```	
and then add dependency

```groovy
dependencies {
	compile 'com.github.architjn:SharePanel:1.0'
}
```


##Usage

###XML

```xml

    <com.architjn.sharepanel.SharePanel
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:app_layout_anchor="@id/collapsing_toolbar"
        app:app_layout_anchorGravity="bottom|right|end">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content">
	    <!-- Your Images Here -->
            <com.varunest.sparkbutton.SparkButton
                android:id="@+id/twitter_button"
                android:layout_width="50dp"
                android:layout_height="50dp"
                app:sparkbutton_activeImage="@drawable/ic_twitter"
                app:sparkbutton_iconSize="20dp"
                app:sparkbutton_primaryColor="@color/twitter_primary_color"
                app:sparkbutton_secondaryColor="@color/twitter_secondary_color" />

            <com.varunest.sparkbutton.SparkButton
                android:id="@+id/fb_button"
                android:layout_width="50dp"
                android:layout_height="50dp"
                app:sparkbutton_activeImage="@drawable/ic_facebook"
                app:sparkbutton_iconSize="20dp"
                app:sparkbutton_primaryColor="@color/fb_primary_color"
                app:sparkbutton_secondaryColor="@color/fb_secondary_color" />
        </LinearLayout>
    </com.architjn.sharepanel.SharePanel>
```
##Buttons Used
SparkButton : [https://github.com/varunest/SparkButton](https://github.com/varunest/SparkButton)


##License
Library falls under [Apache 2.0] (LICENSE.md)

