package psi.com.psi;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;


import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.Assert.assertTrue;

/**
 * Created by HJ Chin on 12/12/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MapTest {

    private UiDevice device;
    private static final String PSI_APP = "psi.com.psi.mock";
    private static final int LAUNCH_TIMEOUT = 5000;

    @Test
    public void testDisplayMarker(){

        device = UiDevice.getInstance(getInstrumentation());

        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(PSI_APP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        device.wait(Until.hasObject(By.pkg(PSI_APP).depth(0)),
                LAUNCH_TIMEOUT);

        UiDevice device = UiDevice.getInstance(getInstrumentation());

        UiObject northMarker = device.findObject(new UiSelector().descriptionContains("north"));
        assertTrue(northMarker.exists());

        UiObject eastMarker = device.findObject(new UiSelector().descriptionContains("east"));
        assertTrue(eastMarker.exists());

        UiObject southMarker = device.findObject(new UiSelector().descriptionContains("south"));
        assertTrue(southMarker.exists());

        UiObject westMarker = device.findObject(new UiSelector().descriptionContains("west"));
        assertTrue(westMarker.exists());

        UiObject centralMarker = device.findObject(new UiSelector().descriptionContains("central"));
        assertTrue(centralMarker.exists());
    }
}
