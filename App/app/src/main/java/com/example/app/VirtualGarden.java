package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The design pattern that I integrated into this class is the State design pattern. This class controls the virtual garden view within the app. After adding the state design pattern, the class has two states. The default state is the view only state and the other state is the editing state. In the view only state, the user can view their virtual garden and access the PlantID for all of their plants by tapping any plant, to then be linked to that plant's PlantID screen. The state can be changed back and forth by tapping a state-switching button on the screen. The editing state allows the user to rearrange the virtual garden layout by dragging and dropping the veggies to different locations on the grid layout. Also, the editing state allows the user to select one or multiple veggies at once with the ability to do things such as update their "Watered" status, mark them as Harvested, or delete them completely. Note, these actions may be done on the PlantID page for individual plants, but the edit garden feature is mostly convenient for making large scale adjustments early on in the season, when the garden is most volatile.
 */
public class VirtualGarden extends AppCompatActivity {
    int veggiesInGarden;
    private PlantID myPlants;
    public int currentState = 1; //state 1 is read only, state 2 is edit


    class State {
        public void changeState() {
            //changes current state to opposite state
            if (currentState == 1) {
                currentState = 2;
            }
            else if(currentState == 2){
                currentState = 1;
            }
        }

        public void stateToReadOnly() {
            //changes current state to read only state
        }

        public void stateToEdit() {
            //changes current state to edit state
        }
    }

    class ReadOnlyState extends State {
        private void dragToScroll() {
        }

        private void tapToGoToPlantID() {
        }

        public void stateToEdit() {
            currentState = 2;
        }
    }

    class EditState extends State {
        private void dragToRearrangeVeggies() {
        }

        private void tapToSelectVeggies() {
        }

        public void stateToReadOnly() {
            currentState = 1;
        }
    }

}