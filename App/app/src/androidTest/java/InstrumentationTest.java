import static org.junit.Assert.assertEquals;

import com.example.app.Plant;
import com.example.app.R;
import com.example.app.PlantId;
import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.runner.AndroidJUnit4;


import com.example.app.PlantsPage;
import com.google.android.material.card.MaterialCardView;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InstrumentationTest {

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
            MaterialCardView cardView = (MaterialCardView) ll.getChildAt(0);
            PlantId plant = (PlantId) cardView.getChildAt(0);

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

    @Test
    public void
}