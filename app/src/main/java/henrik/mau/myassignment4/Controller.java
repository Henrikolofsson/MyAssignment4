package henrik.mau.myassignment4;

import android.support.v4.app.Fragment;

import Fragments.DataFragment;
import Fragments.StartFragment;

public class Controller {
    private MainActivity mainActivity;

    private DataFragment dataFragment;
    private StartFragment startFragment;

    public Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        initializeFragments();
        setFragment("StartFragment");
    }

    private void initializeFragments() {
        initializeDataFragment();
        initializeStartFragment();
    }

    private void initializeDataFragment() {
        dataFragment = (DataFragment) mainActivity.getFragment("DataFragment");
        if(dataFragment == null){
            dataFragment = new DataFragment();
            mainActivity.addFragment(dataFragment, "DataFragment");
            dataFragment.setActiveFragment("StartFragment");
        }
    }

    private void initializeStartFragment() {
        startFragment = (StartFragment) mainActivity.getFragment("StartFragment");
        if(startFragment == null){
            startFragment = new StartFragment();
        }
        startFragment.setController(this);
    }

    /*
   Used to dynamically be able to change the fragments.
 */
    private void setFragment(String tag) {
        switch (tag) {
            case "StartFragment":
                setFragment(startFragment, tag);
                break;


        }
    }

    /*
       Sends the fragment to the main activity to make a fragment transaction, and also
       store the TAG of the active fragment in DataFragment to easily get the active fragment.
     */
    private void setFragment(Fragment fragment, String tag) {
        mainActivity.setFragment(fragment, tag);
        dataFragment.setActiveFragment(tag);
    }

    public boolean onBackPressed() {
        String activeFragment = dataFragment.getActiveFragment();

        switch(activeFragment) {

        }
        return false;
    }
}
