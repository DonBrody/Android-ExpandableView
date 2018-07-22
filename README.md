# Android-ExpandableView
Custom Android component that extends ResizableRelativeLayout (another custom component in my repositories), and provides children with the functionality needed to expand and collapse from the bottom of the screen. This view will also resize itself on orientation change.

## Prerequisites
Make sure you have a version of Android Studio installed that supports Kotlin (3+ should be fine).

## Running the Demo
Just download the project, open it in Android Studio, connect to a virtual or physical device, and run it! There shouldn't be any further configuration required (unless you need to download build tools, etc., but Android Studio should prompt you to do that).

The demo is one activity (MainActivity.java). Below are GIF's of the functionality in both ladscape and portrait. Notice that in both orientations the ExpandableButtonPanel takes up 90% of the screen width. That is because it extends the [ResizableRelativeLayout](https://github.com/DonBrody/Android-ResizableRelativeLayout).

<img height="300px" width="400px" src="https://s3.amazonaws.com/don-brody-images/ExpandableView+Landscape.gif"/>&nbsp;&nbsp;&nbsp;&nbsp;<img height="400px" width="300px" src="https://s3.amazonaws.com/don-brody-images/ExpandableView+Portrait.gif"/>

## How It Works
The ExpandableView extends the [ResizableRelativeLayout](https://github.com/DonBrody/Android-ResizableRelativeLayout) and is responsible for expanding and collapsing itself on command. Simply call translateLayout to expand or collapse the component. It keeps track of its own state, so call isExpanded to determine if the view is expanded or collapsed. You may also register an ExpandableStateListener with the component to be notified of its state changes.

*Important Notes*:
* The ExpandableView ignores any calls to translateLayout that occur while it is expanding or collapsing.
* Because ExpandableView extends [ResizableRelativeLayout](https://github.com/DonBrody/Android-ResizableRelativeLayout), you must add the following line to the manifest for each activity that utilizes this component (for more information see the [ResizableRelativeLayout README](https://github.com/DonBrody/Android-ResizableRelativeLayout):
```
android:configChanges="orientation|screenSize"
```
* Any component that extends ExpandableView must be the child of a RelativeLayout, and must align the bottom of their container. Here is an example from this demo project:
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent">

    <Button
        android:id="@+id/actionButton"
        android:layout_width="400dp"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_alignParentTop="true"
        android:layout_marginTop="150dp"
        android:background="@color/colorPrimary"
        android:textColor="@android:color/white"
        android:textAllCaps="false" />

    <com.donbrody.expandableview.components.example.ExpandableButtonPanel
        android:id="@+id/expandableButtonPanel"
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:visibility="invisible" />

</RelativeLayout>
```
* Lastly, note that the view's visibility is initially set to invisible. The ExpandableView will handle its own visibility after its creation. Setting it initially to invisible ensures that the user will not see it after its creation (the component is created in its expanded state, then immediately collapsed).

## Next Steps
Add the ExpandableView to any (and hopefully all :) of your projects, extend it with any views you'd like, and enjoy!

## Dependencies
* [ResizableRelativeLayout](https://github.com/DonBrody/Android-ResizableRelativeLayout)

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
