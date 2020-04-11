package org.sankul.watchdog;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import java.io.File;
import java.util.Objects;

//import android.support.v4.app.Fragment;
//import android.support.v7.preference.Preference;
//import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragmentCompat {


    public SettingsFragment() {
        // Required empty public constructor
    }

    private void deleteFile(File f) {
        if (!f.exists()) return;
        if (f.isDirectory()) {
            for (File cf : Objects.requireNonNull(f.listFiles())) {
                deleteFile(cf);
            }
            f.delete();
            return;
        }
        f.delete();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        Preference pref = findPreference("reset");
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                File base = Objects.requireNonNull(getActivity()).getCacheDir().getParentFile();
                String[] deletes = new String[]{"app_webview", "cache", "databases"};
                for (String ddir : deletes) {
                    deleteFile(new File(base, ddir));
                }
                System.exit(0);
                return true;
            }
        });
    }


}
