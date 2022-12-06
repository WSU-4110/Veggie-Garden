package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The design pattern that I integrated into this class is the VirtualGardenState design pattern. This class controls the virtual garden view within the app. After adding the state design pattern, the class has two states. The default state is the view only state and the other state is the editing state. In the view only state, the user can view their virtual garden and access the PlantID for all of their plants by tapping any plant, to then be linked to that plant's PlantID screen. The state can be changed back and forth by tapping a state-switching button on the screen. The editing state allows the user to rearrange the virtual garden layout by dragging and dropping the veggies to different locations on the grid layout. Also, the editing state allows the user to select one or multiple veggies at once with the ability to do things such as update their "Watered" status, mark them as Harvested, or delete them completely. Note, these actions may be done on the PlantID page for individual plants, but the edit garden feature is mostly convenient for making large scale adjustments early on in the season, when the garden is most volatile.
 */
public class VirtualGarden extends AppCompatActivity {
    int veggiesInGarden;
    //private PlantID myPlants;
    public int currentState = 1; //state 1 is read only, state 2 is edit

    //table filled with containers that can show little pictures and can contain a link when clicked on


    class VirtualGardenState {
        public void changeToOppositeState() {
            //changes current state to opposite state
            if (currentState == 1) {
                currentState = 2;
            } else if (currentState == 2) {
                currentState = 1;
            }
        }

        public void changeStateToReadOnly() {
            //changes current state to read only state
        }

        public void changeStateToEdit() {
            //changes current state to edit state
        }
    }

    class ReadOnlyState extends VirtualGardenState {
        private void dragToScroll() {
        }

        private void tapToGoToPlantID() {
        }

        public void changeStateToEdit() {
            currentState = 2;
        }
    }

    class EditState extends VirtualGardenState {
        private void dragToRearrangeVeggies() {
        }

        private void tapToSelectVeggies() {
        }

        public void changeStateToReadOnly() {
            currentState = 1;
        }
    }

}