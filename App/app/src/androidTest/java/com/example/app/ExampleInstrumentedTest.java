package com.example.app;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

//    @Rule
//    public ActivityScenarioRule rule = new  ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        ActivityScenario<PlantsPage> scenario = ActivityScenario.launch(PlantsPage.class);
        scenario.onActivity(activity -> {
            Context appContext = activity.getApplicationContext();
            assertEquals("com.example.app", appContext.getPackageName());
        });

//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.app", appContext.getPackageName());
    }

    @Test
    public void listPlantsTest() {

        ActivityScenario<PlantsPage> scenario = ActivityScenario.launch(PlantsPage.class);
        scenario.onActivity(activity -> {
            LinearLayout ll = activity.findViewById(R.id.linear_layout);

            assertEquals(3, ll.getChildCount());
        });
    }

    @Test
    public void plantIdTest() {
        ActivityScenario<PlantsPage> scenario = ActivityScenario.launch(PlantsPage.class);
        scenario.onActivity(activity -> {
            LinearLayout ll = activity.findViewById(R.id.linear_layout);
            PlantId plant = (PlantId) ll.getChildAt(0);

            assertEquals("test", plant.getPlantName());
            assertEquals("test", plant.getPlantBirthday());
        });
    }

    @Test
    public void backButtonTest() {
        ActivityScenario<PlantsPage> scenario = ActivityScenario.launch(PlantsPage.class);
        scenario.onActivity(activity -> {
           Button button = activity.findViewById(R.id.backToMain);

           assertEquals("BACK", button.getText());
        });
    }
}