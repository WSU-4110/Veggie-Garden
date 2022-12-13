import static androidx.test.core.app.ActivityScenario.launch;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.app.AddAPlant;
import com.example.app.MainActivity;
import com.example.app.Plant;
import com.example.app.R;
import com.example.app.PlantId;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.runner.AndroidJUnit4;


import com.example.app.PlantsPage;
import com.example.app.plantInfo;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InstrumentationTest {

//    @Rule
//    public ActivityScenarioRule rule = new  ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        ActivityScenario<PlantsPage> scenario = launch(PlantsPage.class);
        scenario.onActivity(activity -> {
            Context appContext = activity.getApplicationContext();
            assertEquals("com.example.app", appContext.getPackageName());
        });

//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.app", appContext.getPackageName());
    }

    @Test
    public void listPlantsTest() {

        ActivityScenario<PlantsPage> scenario = launch(PlantsPage.class);
        scenario.onActivity(activity -> {
            LinearLayout ll = activity.findViewById(R.id.linear_layout);

            assertEquals(0, ll.getChildCount());
        });
    }

//    @Test
//    public void plantIdTest() {
//        ActivityScenario<PlantsPage> scenario = launch(PlantsPage.class);
//        scenario.onActivity(activity -> {
//            LinearLayout ll = activity.findViewById(R.id.linear_layout);
//            MaterialCardView cardView = (MaterialCardView) ll.getChildAt(0);
//            PlantId plant = (PlantId) cardView.getChildAt(0);
//
//            assertEquals("test", plant.getPlantName());
//            assertEquals("test", plant.getPlantBirthday());
//        });
//    }

    @Test
    public void backButtonTest() {
        ActivityScenario<PlantsPage> scenario = launch(PlantsPage.class);
        scenario.onActivity(activity -> {
            Button button = activity.findViewById(R.id.backToMain);

            assertEquals("BACK", button.getText());
        });
    }

    @Test
    public void addPlantTest() {
        ActivityScenario<AddAPlant> scenario = launch(AddAPlant.class);
        scenario.onActivity(activity -> {
            Button back = activity.findViewById(R.id.backToMain);
            Button add = activity.findViewById(R.id.addPlant);

            assertEquals("BACK", back.getText());
            assertEquals("Add This Plant", add.getText());
        });
    }

    @Test
    public void  verifyPlantsPage() {
        ActivityScenario<PlantsPage> scenario = launch(PlantsPage.class);
        scenario.onActivity(activity -> {
            String result = activity.getLocalClassName();

            assertEquals("PlantsPage", result);
        });
    }

//    @Test
//    public void plantsInfoTest() {
//        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), plantInfo.class);
//        intent.putExtra("PLANT_NAME","corn");
//        ActivityScenario<plantInfo> scenario = ActivityScenario.launch(intent);
//
//        scenario.onActivity(activity -> {
//            FloatingActionButton delete = activity.findViewById(R.id.delete);
//
//            assertEquals(2131361957, delete.getId());
//            assertTrue(delete.isClickable());
//        });
//    }

//    @Test
//    public void plantsPageVerifyClickable() {
//        ActivityScenario<PlantsPage> scenario = launch(PlantsPage.class);
//        scenario.onActivity(activity -> {
//            LinearLayout ll = activity.findViewById(R.id.linear_layout);
//            MaterialCardView cardView = (MaterialCardView) ll.getChildAt(0);
//            PlantId plant = (PlantId) cardView.getChildAt(0);
//
//            assertTrue(plant.isClickable());
//        });
//    }

    @Test
    public void addPlantDefaultTest() {
        ActivityScenario<AddAPlant> scenario = launch(AddAPlant.class);
        scenario.onActivity(activity -> {
            CheckBox loc = activity.findViewById(R.id.location);

            assertFalse(loc.isChecked());
        });
    }

//    @Test
//    public void verifyPlantInfoClassName() {
//        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), plantInfo.class);
//        intent.putExtra("PLANT_NAME","corn");
//        ActivityScenario<plantInfo> scenario = ActivityScenario.launch(intent);
//        scenario.onActivity(activity -> {
//            String result = activity.getLocalClassName();
//
//            assertEquals("plantInfo", result);
//        });
//    }


}